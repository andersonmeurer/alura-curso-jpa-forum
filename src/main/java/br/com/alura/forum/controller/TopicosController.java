package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

import br.com.alura.forum.contoller.dto.TopicoDto;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CrusoRepository;
import br.com.alura.forum.repository.ITopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private ITopicoRepository topicoRepository;
	@Autowired
	private CrusoRepository cursoRepository;

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

	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		if (null == nomeCurso) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
	}

	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
}
