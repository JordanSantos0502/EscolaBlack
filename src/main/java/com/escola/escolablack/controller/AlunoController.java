package com.escola.escolablack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.escolablack.dto.DadosAlunos;
import com.escola.escolablack.dto.DadosColaborador;
import com.escola.escolablack.repository.AlunoRepository;
import com.escola.escolablack.service.AlunoService;
import com.escola.escolablack.service.ColaboradorService;

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
        ColaboradorService.cadastrarAluno(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Colaborador cadastrado com sucesso!");
    }
}
