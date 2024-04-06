package com.escola.escolablack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.escolablack.dto.DadosAlunos;
import com.escola.escolablack.dto.DadosAtualizadosAluno;
import com.escola.escolablack.model.AlunoModel;
import com.escola.escolablack.repository.AlunoRepository;
import com.escola.escolablack.service.AlunoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
    private AlunoService alunoService;

	@Autowired
	private AlunoRepository repository;
	
	@PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarAluno(@Valid @RequestBody DadosAlunos alunoDTO) {
        AlunoService.cadastrarAluno(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Colaborador cadastrado com sucesso!");
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/listar")
    public ResponseEntity<List<AlunoModel>> listarAlunos() {
        List<AlunoModel> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok().body(alunos);
    }
	
	@PutMapping
    public ResponseEntity<String> atualizarAluno (@PathVariable Long id, @RequestBody @Valid DadosAtualizadosAluno dados) {
    	var aluno = repository.getReferenceById(id);
    	aluno.atualizarInfo(dados);
    	repository.save(aluno);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
