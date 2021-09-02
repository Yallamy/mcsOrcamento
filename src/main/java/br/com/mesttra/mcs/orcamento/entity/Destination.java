package br.com.mesttra.mcs.orcamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;
import br.com.mesttra.mcs.orcamento.useful.Message;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Classe que representa a entidade Destination do Budget.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Table(name = "Destination")
@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class Destination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_destination")
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "destinationType", nullable = false)
	@NotNull(message = Message.TYPE_DESTINATION_REQUIRED)
	@Enumerated(EnumType.STRING)
	private DestinationTypeEnum destinationType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idBudget", nullable = false)
	@NotNull(message = Message.BUDGET_REQUIRED)
	@JsonIgnore
	private Budget budget;

}
