package com.escola.escolablack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.escolablack.model.AlunoModel;
import com.escola.escolablack.model.ColaboradorModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{
	Optional<ColaboradorModel> findByCpf(String cpf);
}
