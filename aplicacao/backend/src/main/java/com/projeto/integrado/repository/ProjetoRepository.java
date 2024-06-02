package com.projeto.integrado.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.integrado.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
	Optional<Projeto> findByProjetoDescricao(String projetoDescricao);

	@Query("SELECT p FROM Projeto p WHERE p.projetoDescricao LIKE %:descricao%")
    List<Projeto> findByProjetoDescricaoContaining(@Param("descricao") String descricao);
}