package br.com.mesttra.mcs.orcamento.resource;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.mcs.orcamento.dto.request.AllocationRequestDTO;
import br.com.mesttra.mcs.orcamento.dto.request.BudgetRequestDTO;
import br.com.mesttra.mcs.orcamento.dto.response.AllocationResponseDTO;
import br.com.mesttra.mcs.orcamento.dto.response.BudgetResponseDTO;
import br.com.mesttra.mcs.orcamento.entity.Budget;
import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;
import br.com.mesttra.mcs.orcamento.entity.Destination;
import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;
import br.com.mesttra.mcs.orcamento.enums.SourceEnum;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import br.com.mesttra.mcs.orcamento.service.BudgetService;
import br.com.mesttra.mcs.orcamento.useful.ConstantsPath;
import br.com.mesttra.mcs.orcamento.useful.ConstantsSwagger;
import br.com.mesttra.mcs.orcamento.useful.Useful;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * Classe que disponibiliza os serviços para manter o budget.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value= ConstantsPath.PATH_BUDGET, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = ConstantsPath.PATH_BUDGET, produces = MediaType.APPLICATION_JSON_VALUE, tags = { ConstantsPath.TAG_BUDGET })
public class BudgetResource {
	
	private final BudgetService service;
	
	/**
	 * Método REST que cria um orçamento.
	 * @param request - BudgetRequestDTO
	 * @return ResponseEntity<?> - orçamento criado ou código de erro HTTP
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @throws ApplicationException 
	 * @since 2 de set de 2021
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = ConstantsSwagger.CREATE_BUDGET, 
		notes = ConstantsSwagger.CREATE_BUDGET_NOTES, response = BudgetResponseDTO.class)
	public @ResponseBody ResponseEntity<?> create(
			@Valid @RequestBody BudgetRequestDTO request) throws ApplicationException {

		Budget budget = Useful.convert(request, Budget.class);
		budget.setSource(SourceEnum.getEnum(request.getSource().toUpperCase()));

		budget = this.service.create(budget);
		BudgetResponseDTO response = Useful.convert(budget, BudgetResponseDTO.class);
		response.setTotalSpentAmount(BigDecimal.ZERO);
		response.setAllocations(new LinkedList<AllocationResponseDTO>());

		return new ResponseEntity<BudgetResponseDTO>(response, HttpStatus.OK);
	}

	/**
	 * Método REST que cria uma alocação de orçamento.
	 * @param id - id do orçamento
	 * @param request - alocação do orçamento
	 * @return ResponseEntity<?> - orçamento ou código de erro HTTP
	 * @throws ApplicationException 
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ApiOperation(value = ConstantsSwagger.CREATE_BUDGET_ALLOCATION, 
		notes = ConstantsSwagger.CREATE_BUDGET_ALLOCATION_NOTES, response = BudgetResponseDTO.class)
	public @ResponseBody ResponseEntity<?> createBudgetAllocation(
			@PathVariable("id") Long id,
			@Valid @RequestBody AllocationRequestDTO request) throws ApplicationException {

		BudgetAllocation allocation = Useful.convert(request, BudgetAllocation.class);

		Budget budget = this.service.createBudgetAllocation(id, allocation);
		
		BudgetResponseDTO response = Useful.convert(budget, BudgetResponseDTO.class);
		response.setTotalSpentAmount(this.service.getTotalSpentAmount(budget));

		return new ResponseEntity<BudgetResponseDTO>(response, HttpStatus.OK);
	}

	/**
	 * Método REST que recupera um orçamento.
	 * @param id - id do orçamento
	 * @return ResponseEntity<?> - orçamento recuperado ou código de erro HTTP
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @throws ApplicationException 
	 * @since 2 de set de 2021
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = ConstantsSwagger.RETRIEVE_BUDGET, 
		notes = ConstantsSwagger.RETRIEVE_BUDGET_NOTES, response = BudgetResponseDTO.class)
	public @ResponseBody ResponseEntity<?> retrieve(
			@PathVariable("id") Long id) throws ApplicationException {

		Budget budget = this.service.retrieve(id);
		BudgetResponseDTO response = Useful.convert(budget, BudgetResponseDTO.class);
		response.setTotalSpentAmount(this.service.getTotalSpentAmount(budget));

		return new ResponseEntity<BudgetResponseDTO>(response, HttpStatus.OK);
	}

	/**
	 * Método REST que lista os orçamentos de acordo com os filtros informados.
	 * @param source - filtro source do orçamento
	 * @param destination - filtro destination do orçamento
	 * @return ResponseEntity<?> - lista de orçamentos ou código de erro HTTP
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @throws ApplicationException 
	 * @since 2 de set de 2021
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = ConstantsSwagger.LIST_BUDGET, 
		notes = ConstantsSwagger.LIST_BUDGET_NOTES, response = BudgetResponseDTO.class)
	public @ResponseBody ResponseEntity<Page<?>> list(
			@PageableDefault(value = 30, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
			@RequestParam("source") Optional<String> source,
			@RequestParam("destination") Optional<String> destination) throws ApplicationException {

		List<Destination> destinations = null;
		String destinationFilter = destination.orElse(null);
		
		if(Objects.nonNull(destinationFilter)) {
			
			destinations = new LinkedList<Destination>();
			Destination destino = 
					Destination
					.builder()
					.destinationType(DestinationTypeEnum.getEnum(destinationFilter))
					.build();
			
			destinations.add(destino);
		}
		
		Budget budget = 
				Budget
				.builder()
				.source(SourceEnum.getEnum(source.orElse(null)))
				.destinations(destinations)
				.build();
		
		Page<Budget> page = this.service.list(budget, pageable);
		Page<BudgetResponseDTO> response = Useful.convertToPage(page, BudgetResponseDTO.class);
		
		for (BudgetResponseDTO budgetResponseDTO : response) {
			budgetResponseDTO.setTotalSpentAmount(this.service.getTotalSpentAmount(
					Budget
					.builder()
					.id(budgetResponseDTO.getId())
					.build()
					));
		}

		return ResponseEntity.ok(response);
	}

}
