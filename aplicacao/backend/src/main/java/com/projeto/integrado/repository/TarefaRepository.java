package com.projeto.integrado.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.integrado.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    
    @Query("SELECT t FROM Tarefa t JOIN t.statusTarefa st WHERE st.statusDescricao = :statusDescricao")
    List<Tarefa> findByStatusDescricao(@Param("statusDescricao") String statusDescricao);
}