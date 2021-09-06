package br.com.mesttra.mcs.orcamento.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.mesttra.mcs.orcamento.useful.Message;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Classe que representa a entidade BudgetAllocation.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Table(name = "BudgetAllocation")
@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class BudgetAllocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_allocation")
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "spentAmount", nullable = false)
	@NotNull(message = Message.SPENT_AMOUNT_REQUIRED)
	private BigDecimal spentAmount;
	
	@Column(name = "dtAllocation", nullable = false)
	@NotNull(message = Message.DT_BUDGET_REQUIRED)
	private LocalDateTime dtAllocation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idBudget", nullable = false)
	@NotNull(message = Message.BUDGET_REQUIRED)
	@JsonIgnore
	private Budget budget;
}
