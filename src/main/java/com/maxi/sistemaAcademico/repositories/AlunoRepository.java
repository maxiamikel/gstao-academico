package com.maxi.sistemaAcademico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maxi.sistemaAcademico.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByOrderByIdDesc();

    List<Aluno> findByCpfContainingIgnoreCase(String cpf);

    @Query("select a from Aluno a where a.status = 'ATIVO'")
    List<Aluno> findByStatusAtivos();

    @Query("select a from Aluno a where a.status = 'INATIVO'")
    List<Aluno> findByStatusInativos();

    @Query("select a from Aluno a where a.status = 'CANCELADO'")
    List<Aluno> findByStatusCancelado();


}
