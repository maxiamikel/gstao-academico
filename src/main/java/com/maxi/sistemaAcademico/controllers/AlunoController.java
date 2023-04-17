package com.maxi.sistemaAcademico.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maxi.sistemaAcademico.models.Aluno;
import com.maxi.sistemaAcademico.services.AlunoService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("")
public class AlunoController {

    @Autowired
    private AlunoService service;
    
    @GetMapping("/inserirAluno")
    public ModelAndView inserirAluno(Aluno obj){
         ModelAndView mv = new ModelAndView();
         mv.setViewName("aluno/formAluno");
         mv.addObject("aluno", new Aluno());
         return mv;
    }

    @PostMapping("/criarAluno")
    public ModelAndView criarAluno(@Valid Aluno obj, BindingResult br){
        ModelAndView mv = new ModelAndView();
        if(br.hasErrors()){
            mv.setViewName("aluno/formAluno");
            mv.addObject("obj");
        }else{
           mv.setViewName("redirect:/aluno/listAluno");
            service.creatr(obj); 
        }
        return mv;
    }

    @GetMapping("/aluno/listAluno")

    public ModelAndView listarAluno(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/listAluno");
        List<Aluno> list = this.service.findAll();
        mv.addObject("alunos", list);
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterarAluno(@PathVariable Long id){
        ModelAndView mv = new ModelAndView();
        Aluno obj = service.findById(id);
        mv.setViewName("aluno/alterarAluno");
        mv.addObject("aluno", obj);
        return mv;
    }

    @PostMapping("/alterarAluno")
    public ModelAndView alterarAluno(Aluno obj){
        ModelAndView mv = new ModelAndView();
        service.creatr(obj);
        mv.setViewName("redirect:/aluno/listAluno");
        return mv;

    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        this.service.delete(id);
        return "redirect:/aluno/listAluno";
    }

    @GetMapping("/aluno/{cpf}")
    public ModelAndView findByCpf(@PathVariable String cpf){
        ModelAndView mv = new ModelAndView();
        Aluno aluno = this.service.findByCpf(cpf);
        mv.setViewName("aluno/detalhe");
        mv.addObject("aluno", aluno);
        return mv;

    }


    @GetMapping("/buscar")
    public ModelAndView buscarAluno(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/formBuscarAluno");
        return mv;
    }

    @GetMapping("/alunos-ativos")
    public ModelAndView findAlunosAtivos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/aluno/aluno-ativo");
        List<Aluno> alunosAtivos = this.service.findByStatusAtivos();
        mv.addObject("ativos", alunosAtivos);
        return mv;
    }

    @GetMapping("/alunos-inativos")
    public ModelAndView findAlunosInativos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/aluno/aluno-inativo");
        List<Aluno> alunosIntivos = this.service.findByStatusInativos();
        mv.addObject("inativos", alunosIntivos);
        return mv;
    }

    @GetMapping("/alunos-cancelados")
    public ModelAndView findAlunosCancelados(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/aluno/aluno-cancelado");
        List<Aluno> alunosCancelados = this.service.findByStatusCancelados();
        mv.addObject("cancelados", alunosCancelados);
        return mv;
    }

    @PostMapping("/pesquisar-aluno")
    public ModelAndView pesquisarPorCpf(String cpf){
        ModelAndView mv = new ModelAndView();
        List<Aluno> lista = new ArrayList<>();
        if(cpf == null || cpf.trim().isEmpty()){
             lista = this.service.findAll();
        }else{
            lista = this.service.findByCpf(cpf);
        }
        mv.setViewName("aluno/buscar-cpf");
        mv.addObject("lista", lista);
        return mv;
    }
}
