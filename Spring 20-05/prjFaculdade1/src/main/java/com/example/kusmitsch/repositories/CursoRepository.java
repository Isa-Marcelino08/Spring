package com.example.kusmitsch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kusmitsch.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	// Buscar todos os cursos onde um aluno específico (por nome) está matriculado
	@Query("SELECT c FROM Curso c JOIN c.alunos a WHERE a.nome = :nomeAluno")
	List<Curso> findCursosByAluno(@Param("nomeAluno") String nomeAluno);


}

