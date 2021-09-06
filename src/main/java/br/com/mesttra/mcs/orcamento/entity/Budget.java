package br.com.mesttra.mcs.orcamento.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.google.gson.annotations.Expose;

import br.com.mesttra.mcs.orcamento.enums.SourceEnum;
import br.com.mesttra.mcs.orcamento.useful.Message;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Classe que representa a entidade Budget.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Table(name = "Budget")
@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_budget")
	@Column(name = "id", nullable = false)
	@Expose
	private Long id;
	
	@Column(name = "totalAmount", nullable = false)
	@NotNull(message = Message.TOTAL_AMOUNT_REQUIRED)
	private BigDecimal totalAmount;
	
	@Column(name = "dtBudget", nullable = false)
	@NotNull(message = Message.DT_BUDGET_REQUIRED)
	@Expose
	private LocalDateTime dtBudget;
	
	@Column(name = "source", nullable = false)
	@NotNull(message = Message.SOURCE_REQUIRED)
	@Enumerated(EnumType.STRING)
	private SourceEnum source;
	
	@OneToMany(mappedBy = "budget")
	@NotNull(message = Message.DESTINATIONS_REQUIRED)
	private List<Destination> destinations;
	
	@OneToMany(mappedBy = "budget")
	private List<BudgetAllocation> allocations;
	
}
