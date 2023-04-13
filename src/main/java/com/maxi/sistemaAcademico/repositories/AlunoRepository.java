package com.maxi.sistemaAcademico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.sistemaAcademico.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByOrderByIdDesc();
    Aluno findByCpf(String cpf);
    
}
