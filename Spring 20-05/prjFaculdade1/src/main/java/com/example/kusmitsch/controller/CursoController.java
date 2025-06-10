package com.example.kusmitsch.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.kusmitsch.entities.Curso;
import com.example.kusmitsch.services.CursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name="Cursos",description = "API de Cadastro de Cursos")
@RestController
@RequestMapping("/cursos")
public class CursoController {

private final CursoService cursoService;
	
	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}	
	
	// inserir
	@PostMapping("/salvar")
	@Operation(summary="Operação para Salvar Aluno")
	public Curso creatCurso(@RequestBody Curso curso) {
		return cursoService.insertCurso(curso);
	}
	
	// pegar id
	@GetMapping("/{id}")
	@Operation(summary="Operação para buscar Aluno por id")
	public Curso getCursoById(@PathVariable Long id ) {
		return cursoService.findCursoById(id);
	}
	
	// listar 
	@GetMapping("/listar")
	@Operation(summary="Operação para Listar os Aluno")
	public List<Curso> getAllCursos(){
	return cursoService.findAllCurso();
			
		}
	
	// query 
		
	@GetMapping("/curso-aluno/")
	@Operation(summary="Operação para Listar Curso pelo Aluno")
	public List<Curso> BuscarNomeCursoPorAluno(@RequestParam String nomeAluno){
		return cursoService.BuscarCursoPorAluno(nomeAluno);
	}

	
	
}


