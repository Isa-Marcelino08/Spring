package com.example.kusmitsch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.kusmitsch.entities.Curso;
import com.example.kusmitsch.repositories.CursoRepository;

@Service
public class CursoService {
	

private final CursoRepository cursoRepository; // cria uma variavel real 
	
	public CursoService(CursoRepository cursoRepository) { 
		this.cursoRepository = cursoRepository;
	}
	
	
	// preparando a busca por id
	public Curso findCursoById(Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElse(null);
	}
	
	// preparando busca geral
	public List<Curso> findAllCurso(){
		return cursoRepository.findAll();
	}
	
	public Curso insertCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	public List<Curso> BuscarCursoPorAluno(String nomeAluno){
		return cursoRepository.findCursosByAluno(nomeAluno);
	}
	
}
