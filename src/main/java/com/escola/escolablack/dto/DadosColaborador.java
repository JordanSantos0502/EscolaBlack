package com.escola.escolablack.dto;

import com.escola.escolablack.enums.Cargo;
import com.escola.escolablack.model.Endereco;


public record DadosColaborador(String nome, String email, String cpf, Cargo cargo, Endereco endereco) {
	
}
