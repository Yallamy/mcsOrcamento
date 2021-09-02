package br.com.mesttra.mcs.orcamento.useful;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.mesttra.mcs.orcamento.dto.request.BudgetRequestDTO;
import br.com.mesttra.mcs.orcamento.entity.Budget;


/**
 * Classe de teste que representa os cenários de testes da classe {@link Useful}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 1 de out. de 2020
 */
@SuppressWarnings("static-access")
public class UsefulTest {

	@InjectMocks
	private Useful util;
	
	private BudgetRequestDTO source;
	
	@BeforeEach
	public void setup() {

		this.source = 
				BudgetRequestDTO
				.builder()
				.build();
	}

	@Test
	public void convertModelMapperTest() {

		Budget entidade = util.convert(source, Budget.class);

		BudgetRequestDTO dto = util.convert(entidade, 
				BudgetRequestDTO.class);

		assertNotNull(entidade);
		assertNotNull(dto);
	}

	@Test
	public void convertModelMapperSourceNullTest() {

		Budget entidade = util.convert(null, Budget.class);

		assertNull(entidade);
	}

	@Test
	public void convertModelMapperDestinationNullTest() {

		Budget entidade = util.convert(source, null);

		assertNull(entidade);
	}
	
	@Test
	public void convertModelMapperToListTest() {
		
		List<BudgetRequestDTO> sourceList = 
				new LinkedList<BudgetRequestDTO>();
		
		sourceList.add(this.source);
		
		List<Budget> listaEntidade = util.convertToList(sourceList, 
				Budget.class);
		
		List<BudgetRequestDTO> listaDTO = util.convertToList(listaEntidade, 
				BudgetRequestDTO.class);
		
		
		assertNotNull(listaEntidade);
		assertNotNull(listaDTO);
	}
	
	@Test
	public void convertModelMapperToListSourceNullTest() {
		
		List<Budget> listaEntidade = util.convertToList(null, 
				Budget.class);
		
		assertNotNull(listaEntidade);
		assertEquals(0, listaEntidade.size());
	}
	
	@Test
	public void convertModelMapperToListDestinationNullTest() {
		
		List<BudgetRequestDTO> sourceList = 
				new LinkedList<BudgetRequestDTO>();
		
		sourceList.add(this.source);
		
		List<Budget> listaEntidade = util.convertToList(sourceList, 
				null);
		
		assertNotNull(listaEntidade);
		assertEquals(0, listaEntidade.size());
	}
	
	@Test
	public void convertModelMapperToPageTest() {
		
		List<BudgetRequestDTO> sourceList = 
				new LinkedList<BudgetRequestDTO>();
		
		sourceList.add(this.source);
		
		Page<BudgetRequestDTO> pageSource = new PageImpl<BudgetRequestDTO>(
				sourceList, Pageable.unpaged(), sourceList.size());
		
		Page<Budget> pageResponse = util.convertToPage(pageSource, 
				Budget.class);
		
		assertNotNull(pageResponse);
		assertEquals(1, pageResponse.getContent().size());
	}
	
	@Test
	public void convertModelMapperToPageSourceNullTest() {
		
		Page<Budget> pageResponse = util.convertToPage(null, 
				Budget.class);
		
		assertNull(pageResponse);
	}
	
	@Test
	public void convertModelMapperToPageDestinationNullTest() {
		
		List<BudgetRequestDTO> sourceList = 
				new LinkedList<BudgetRequestDTO>();
		
		sourceList.add(this.source);
		
		Page<BudgetRequestDTO> pageSource = new PageImpl<BudgetRequestDTO>(
				sourceList, Pageable.unpaged(), sourceList.size());
		
		Page<Budget> pageResponse = util.convertToPage(pageSource, 
				null);
		
		assertNull(pageResponse);
	}
}
