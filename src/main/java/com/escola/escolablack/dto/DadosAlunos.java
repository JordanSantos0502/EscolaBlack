package com.escola.escolablack.dto;

import com.escola.escolablack.enums.Curso;
import com.escola.escolablack.model.Endereco;

public record DadosAlunos(String nome, String email,String cpf, String telefone, Curso curso, Endereco endereco) {

}
