package com.maxi.sistemaAcademico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maxi.sistemaAcademico.models.Aluno;
import com.maxi.sistemaAcademico.services.AlunoService;

@Controller
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
    public ModelAndView criarAluno(Aluno obj){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/aluno/listAluno");
        service.creatr(obj);
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
}
