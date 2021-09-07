package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return    
				"Olá"
				+ "</br></br>"
				+ "<a href=\"http://localhost:8080/h2-console\">Banco de dados!</a>"
				+"</br></br>"
				+ "<a href=\"http://localhost:8080/topicos\">Pesquisa todos</a>"
				+"</br></br>"
				+ "<a href=\"http://localhost:8080/topicos?nomeCurso=Spring+Boot\">Pesquisa com filtro</a>"
				+"";
	}
}
