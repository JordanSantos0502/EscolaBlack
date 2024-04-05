package com.escola.escolablack.model;

import com.escola.escolablack.dto.DadosAtualizados;
import com.escola.escolablack.enums.Cargo;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "colaboradores")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    @Column(unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Embedded
    private Endereco endereco;

	public void atualizarInfo(@Valid DadosAtualizados dados) {
		this.nome = dados.nome();
		this.email = dados.email();		
	}
}
