package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.contoller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositoty.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

//	@RequestMapping("/topicos")
//	public List<TopicoDTO> lista() {
//		Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
//		return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
//	}

	/*
	 * @ResponseBody - Alternativa correta! Por padrão, o Spring considera que o
	 * retorno do método é o nome da página que ele deve carregar, mas ao utilizar a
	 * anotação @ResponseBody, indicamos que o retorno do método deve ser
	 * serializado e devolvido no corpo da resposta. substituir @ResponseBody da
	 * classe -> @RestController na classe
	 */
	
	
	@RequestMapping("/topicos")
	public List<TopicoDTO> lista() {
		List<Topico> topicos = topicoRepository.findAll();
		return TopicoDTO.converter(topicos);
	}
}
