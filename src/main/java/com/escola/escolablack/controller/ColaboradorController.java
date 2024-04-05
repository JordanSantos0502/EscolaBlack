package com.escola.escolablack.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.escola.escolablack.dto.DadosAtualizados;
import com.escola.escolablack.dto.DadosColaborador;
import com.escola.escolablack.model.ColaboradorModel;
import com.escola.escolablack.repository.ColaboradorRepository;
import com.escola.escolablack.service.ColaboradorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
	@Autowired
    private ColaboradorService colaboradorService;

	@Autowired
	private ColaboradorRepository repository;
	
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarColaborador(@Valid @RequestBody DadosColaborador colaboradorDTO) {
        ColaboradorService.cadastrarColaborador(colaboradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Colaborador cadastrado com sucesso!");
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<ColaboradorModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
    @GetMapping("/listar")
    public ResponseEntity<List<ColaboradorModel>> listarColaboradores() {
        List<ColaboradorModel> colaboradores = colaboradorService.listarColaboradores();
        return ResponseEntity.ok().body(colaboradores);
    }
    
    @PutMapping
    public ResponseEntity<String> atualizar (@PathVariable Long id, @RequestBody @Valid DadosAtualizados dados) {
    	var colaborador = repository.getReferenceById(id);
    	colaborador.atualizarInfo(dados);
    	repository.save(colaborador);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
}
