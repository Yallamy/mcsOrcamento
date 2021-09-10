package br.com.mesttra.mcs.orcamento.useful;

import static java.util.Objects.isNull;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * Classe que providencia um produtor de ObjectMapper
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 9 de set. de 2021
 */
public class ModelMapperProducer {

    private static ModelMapper mapper;
    
    private ModelMapperProducer() {}

    /**
     * Construtor da classe.
     * @return ModelMapper
     * @author Yallamy Nascimento (yallamy@gmail.com)
     * @since 9 de set. de 2021
     */
    public static ModelMapper getMapper() {
        if(isNull(mapper)) {
            init();
        }
        return mapper;
    }

    /**
     * Método que inicializa o ModelMapper
     * @author Yallamy Nascimento (yallamy@gmail.com)
     * @since 9 de set. de 2021
     */
    private static void init() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

}
