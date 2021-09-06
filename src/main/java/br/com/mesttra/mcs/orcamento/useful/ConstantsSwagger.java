package br.com.mesttra.mcs.orcamento.useful;

/**
 * Classe que posssui as constantes utilizadas no Swagger.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
public class ConstantsSwagger {

	//Swagger
    
    //serviços
    public static final String CREATE_BUDGET = "Criar um orçamento";
    
    public static final String CREATE_BUDGET_NOTES = "Cria um orçamento.";
    
    public static final String CREATE_BUDGET_ALLOCATION = "Criar uma alocação de orçamento";
    
    public static final String CREATE_BUDGET_ALLOCATION_NOTES = "Cria uma alocação de orçamento.";
    
    public static final String RETRIEVE_BUDGET = "Recuperar um orçamento";
    
    public static final String RETRIEVE_BUDGET_NOTES = "Recupera um orçamento por id.";
    
    public static final String LIST_BUDGET = "Listar os orçamentos";
    
    public static final String LIST_BUDGET_NOTES = "Listar os orçamentos de acordo com os filtros.";
    
    
    
    //DTOs - REQUESTS
    public static final String BUDGET_REQUEST_DTO = "Armazena os dados do request do orçamento.";
    
    public static final String BUDGET_REQUEST_TOTAL_AMOUNT_DTO = "Armazena o valor total do orçamento.";
    
    public static final String BUDGET_REQUEST_SOURCE_DTO = "Armazena a origem (FEDERAL, STATE, COUNTY) do orçamento.";
    
    public static final String BUDGET_REQUEST_DESTINATIONS_DTO = "Armazena os destinos do orçamento (ex: HEALTH, EDUCATION, SPORTS, INFRASTRUCTURE).";
    
    
    
    public static final String DESTINATION_REQUEST_DTO = "Armazena os dados do request do destino.";
    
    public static final String DESTINATION_REQUEST_TYPE_DTO = "Armazena os dados do tipo de destino.";
    
    
    
    public static final String ALLOCATION_REQUEST_DTO = "Armazena os dados do request da alocação do orçamento.";
    
    public static final String ALLOCATION_REQUEST_SPENT_AMOUNT_DTO = "Armazena os dados do valor alocação do orçamento.";
    
    
    //DTOs - RESPONSES
    public static final String BUDGET_RESPONSE_DTO = "Armazena os dados do response do orçamento.";
    
    public static final String BUDGET_RESPONSE_ID_DTO = "Armazena o id do orçamento.";
    
    public static final String BUDGET_RESPONSE_TOTAL_AMOUNT_DTO = "Armazena o valor total do orçamento.";
    
    public static final String BUDGET_RESPONSE_TOTAL_SPENT_AMOUNT_DTO = "Armazena o valor total gasto do orçamento.";
    
    public static final String BUDGET_RESPONSE_DT_DTO = "Armazena a data do orçamento.";
    
    public static final String BUDGET_RESPONSE_SOURCE_DTO = "Armazena a origem (FEDERAL, STATE, COUNTY) do orçamento.";
    
    public static final String BUDGET_RESPONSE_DESTINATIONS_DTO = "Armazena os destinos do orçamento (ex: HEALTH, EDUCATION, SPORTS, INFRASTRUCTURE).";
    
    public static final String BUDGET_RESPONSE_ALLOCATIONS_DTO = "Armazena as alocações do orçamento.";
    
    
    
    public static final String DESTINATION_RESPONSE_DTO = "Armazena os dados do response do destino.";
    
    public static final String DESTINATION_RESPONSE_ID_DTO = "Armazena o id do response do destino.";
    
    public static final String DESTINATION_RESPONSE_TYPE_DTO = "Armazena os dados do tipo de destino.";
    
    
    
    public static final String ALLOCATION_RESPONSE_DTO = "Armazena os dados do response da alocação do orçamento.";
    
    public static final String ALLOCATION_RESPONSE_ID_DTO = "Armazena o id do response da alocação do orçamento.";
    
    public static final String ALLOCATION_RESPONSE_SPENT_AMOUNT_DTO = "Armazena os dados do valor alocação do orçamento.";
    
    public static final String ALLOCATION_RESPONSE_DT_DTO = "Armazena os dados da data da alocação do orçamento.";
    
    
    

   
    
    
}
