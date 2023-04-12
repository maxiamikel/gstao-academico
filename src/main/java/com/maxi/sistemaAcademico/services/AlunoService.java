package com.maxi.sistemaAcademico.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.sistemaAcademico.models.Aluno;
import com.maxi.sistemaAcademico.repositories.AlunoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlunoService {

    @Autowired
    private AlunoRepository repo;

    public Aluno creatr(Aluno obj){
        obj.setDataCadastro(LocalDate.now());
        return repo.save(obj);
      // return null;
    }

    public List<Aluno> findAll(){
        return repo.findByOrderByIdDesc();
    }
    
}
