package com.example.kusmitsch.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kusmitsch.entities.Aluno;
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	//Buscar todos os alunos que estão em um curso específico (por nome)
	@Query("SELECT a FROM Aluno a JOIN a.cursos c WHERE c.nomeCurso = :nomeCurso")
	List<Aluno> findAlunosByCurso(@Param("nomeCurso") String nomeCurso);
	
	//Buscar alunos por parte do nome (contendo texto)	
	@Query("SELECT a FROM Aluno a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
	List<Aluno> findByNomeContendo(@Param("nome") String nome);
	
	//Buscar alunos que estão matriculados em mais de um curso
	@Query("SELECT a FROM Aluno a WHERE SIZE(a.cursos) > 1")
	List<Aluno> findAlunosComMaisDeUmCurso();	

}


