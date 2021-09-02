package br.com.mesttra.mcs.orcamento.useful;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * Classe que apresenta métodos úteis para todo o projeto.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
public class Useful {
	
	/**
	 * Método que converte um tipo de classe para outro tipo de classe.
	 * @param source
	 * @param destinationType
	 * @return Class<E> tipo de classe de destino
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public static <E, T> E convert(T source, Class<E> destinationType) {
		
        E model = null;
        
        if (Objects.nonNull(source) && Objects.nonNull(destinationType)) {

             ModelMapper modelMapper = new ModelMapper();

             modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
             model = modelMapper.map(source, destinationType);
        }

        return model;
	}
	
	/**
	 * Método que converte um tipo de lista para outro tipo de lista.
	 * @param source
	 * @param destinationType
	 * @return List<E>  tipo de classe de destino
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public static <E, T> List<E> convertToList(List<T> source, Class<E> destinationType) {
		
		List<E> model = new LinkedList<E>();
		
		if (Objects.nonNull(source) && Objects.nonNull(destinationType)) {
			
			for (T item : source) {
				model.add(convert(item, destinationType));
			}
		}

		return model;
	}
	
	/**
	 * Método que converte um tipo de page para outro tipo de page.
	 * @param source
	 * @param typeDestination
	 * @return Page<E>
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public static <T, E> Page<E> convertToPage(Page<T> source, Class<E> destinationType) {

		Page<E> model = null;
		
		if (Objects.nonNull(source) && Objects.nonNull(destinationType)) {

			List<E> listContent = convertToList(source.getContent(), destinationType);
			
			Page<E> pageResponse = new PageImpl<>(listContent, source.getPageable(), source.getTotalElements());
			model = pageResponse;
		}

		return model;
	}
}
