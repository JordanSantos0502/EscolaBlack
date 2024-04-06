package com.escola.escolablack.dto;

import com.escola.escolablack.enums.Curso;
import com.escola.escolablack.model.Endereco;

public record DadosAtualizadosAluno(String nome, String telefone, Endereco endereco,Curso curso) {

}
