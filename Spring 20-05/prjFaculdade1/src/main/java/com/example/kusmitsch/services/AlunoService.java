package com.example.kusmitsch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.kusmitsch.entities.Aluno;
import com.example.kusmitsch.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	
	private final AlunoRepository alunoRepository;
	
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
			
	}
	
	public Aluno findAlunoById(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElse(null);
	}
	
	public Aluno insertAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
		public List<Aluno> findAllAlunos(){
			return alunoRepository.findAll();
		}
		
		public List<Aluno> BuscarAlunoPorCurso(String nomeCurso){
			return alunoRepository.findAlunosByCurso(nomeCurso);
		}
		
		
		public List<Aluno> BuscarPorNomeContendo(String nome){
			return alunoRepository.findByNomeContendo(nome);
		}
		
		public List<Aluno> BuscarAlunoComMaisDeUmCurso(){
			return alunoRepository.findAlunosComMaisDeUmCurso();
		}

}
