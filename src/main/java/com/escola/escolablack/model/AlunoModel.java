package com.escola.escolablack.model;

import com.escola.escolablack.dto.DadosAtualizadosAluno;
import com.escola.escolablack.enums.Curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alunos")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    
    @NotBlank
    private String telefone;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    @Column(unique = true)
    private String cpf;
    
    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Embedded
    private Endereco endereco;
    
    public void atualizarInfo(@Valid DadosAtualizadosAluno dados) {
		this.nome = dados.nome();
		this.telefone = dados.telefone();
		this.endereco = new Endereco();
		this.curso = dados.curso();
	}
}
