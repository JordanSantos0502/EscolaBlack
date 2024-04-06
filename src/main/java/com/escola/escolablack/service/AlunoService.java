package com.escola.escolablack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escola.escolablack.dto.DadosAlunos;
import com.escola.escolablack.model.AlunoModel;
import com.escola.escolablack.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
    private static AlunoRepository alunoRepository;
	
	@Transactional
    public static String cadastrarAluno(DadosAlunos alunoDTO) {
    	
    	var existente = alunoRepository.findByCpf(alunoDTO.cpf());
		
		if(existente.isPresent()) {
			return "CPF Ja cadastrado";
		}
		else {
			var aluno = new AlunoModel(null, alunoDTO.nome(), alunoDTO.cpf(), alunoDTO.email(), alunoDTO.telefone(), alunoDTO.curso(), null);
			alunoRepository.save(aluno);
			return "Cadastro feito com sucesso";
		}
		
    }
	
	@Transactional(readOnly = true)
    public List<AlunoModel> listarAlunos() {
    	return alunoRepository.findAll();
    }
	
	@SuppressWarnings("unused")
	private DadosAlunos converterParaDTO(AlunoModel aluno) {
        return new DadosAlunos(aluno.getNome(), aluno.getEmail(), aluno.getCpf(),aluno.getTelefone() ,aluno.getCurso(), aluno.getEndereco());
    }
}
