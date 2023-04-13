package com.maxi.sistemaAcademico.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    

    public Aluno findById(Long id){
        return repo.findById(id).orElseThrow( () -> new RuntimeException("O id expecificado não esta presente"));
    }

    public void delete(Long id){
        this.repo.deleteById(id);
    }

    public Aluno findByCpf(String cpf){
        Aluno aluno = repo.findByCpf(cpf);
        return aluno;
    }
}
