package com.escola.escolablack.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escola.escolablack.dto.DadosColaborador;
import com.escola.escolablack.model.ColaboradorModel;
import com.escola.escolablack.repository.ColaboradorRepository;

import java.util.List;

@Service
public class ColaboradorService {
	@Autowired
    private static ColaboradorRepository colaboradorRepository;

    @Transactional
    public static String cadastrarColaborador(DadosColaborador colaboradorDTO) {
    	
    	var existente = colaboradorRepository.findByCpf(colaboradorDTO.cpf());
		
		if(existente.isPresent()) {
			return "CPF Ja cadastrado";
		}
		else {
			var colaborador = new ColaboradorModel(null, colaboradorDTO.nome(), colaboradorDTO.cpf(), colaboradorDTO.email(), colaboradorDTO.cargo(), null);
			colaboradorRepository.save(colaborador); //INSERT 
			return "Cadastro feito com sucesso";
		}
		
    }
    @Transactional(readOnly = true)
    public List<ColaboradorModel> listarColaboradores() {
    	return colaboradorRepository.findAll();
    }

    @SuppressWarnings("unused")
	private DadosColaborador converterParaDTO(ColaboradorModel colaborador) {
        return new DadosColaborador(colaborador.getNome(), colaborador.getEmail(), colaborador.getCpf(), colaborador.getCargo(), colaborador.getEndereco());
    }
}
