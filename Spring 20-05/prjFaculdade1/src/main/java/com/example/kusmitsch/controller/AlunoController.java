package com.example.kusmitsch.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kusmitsch.entities.Aluno;
import com.example.kusmitsch.services.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name="Alunos",description = "API de Cadastro de Alunos")
@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private final AlunoService alunoService;
	
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	// inserir 
	@PostMapping("/salvar")
	@Operation(summary="Operação para Salvar Aluno")
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoService.insertAluno(aluno);
	}
	
	//pegar o id
	@GetMapping("/{id}")
	@Operation(summary="Operação para buscar Aluno por id")
	public Aluno getAluno(@PathVariable Long id ) {
		return alunoService.findAlunoById(id);
	}
	
	// listar 
	@GetMapping("/listar")
	@Operation(summary="Operação para Listar os Aluno")
	public List<Aluno> getAllAlunos(){
		return alunoService.findAllAlunos();
		
	}
	
	
	// query 
	
	@GetMapping("/alunos-curso/")
	@Operation(summary="Operação para Listar Aluno por curso")
	public List<Aluno> listarAlunoPorCurso(@RequestParam String nome){
		return alunoService.BuscarAlunoPorCurso(nome);
		
		
	}
	
	@GetMapping("/nome/")
	@Operation(summary="Operação para Listar Aluno por nome Contendo...")
	public List<Aluno> buscaPorNome(@RequestParam String nome){
		return alunoService.BuscarPorNomeContendo(nome);
	}
	
	
	@GetMapping("/multi-cursos")
	@Operation(summary="Operação para Listar Aluno com mais de um curso")
	public List<Aluno> buscarAlunoComMaisCursos(){
		return alunoService.BuscarAlunoComMaisDeUmCurso();
	}

}

