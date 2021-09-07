package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {

	// O proprio framework entende
	List<Topico> findByCursoNome(String nomeCurso);

	/*
	 * Query feita na mão. O Nome da Tabela deve ser igual o nome da classe, case
	 * sensitive
	 */
	@Query("select t from Topico t where t.curso.nome = :nomeCurso")
	List<Topico> carregarNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}