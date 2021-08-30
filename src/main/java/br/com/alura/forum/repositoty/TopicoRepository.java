package br.com.alura.forum.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}