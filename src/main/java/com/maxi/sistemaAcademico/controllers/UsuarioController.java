package com.maxi.sistemaAcademico.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maxi.sistemaAcademico.config.Config;
import com.maxi.sistemaAcademico.exceptions.UserLoginException;
import com.maxi.sistemaAcademico.models.Aluno;
import com.maxi.sistemaAcademico.models.Usuario;
import com.maxi.sistemaAcademico.services.UsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {


    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        mv.setViewName("login/login");
        return mv;
    }


    @GetMapping("/cadastro")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/cadastro");
        mv.addObject("user", new Usuario());
        return mv;
    }

    @PostMapping("criarUsuario")
    public ModelAndView criarUsuario(Usuario obj) throws Exception{
        ModelAndView mv = new ModelAndView();
       // Usuario novo = this.service.criarUsuario(obj);
        //mv.addObject("user", novo);
        this.service.criarUsuario(obj);
        mv.addObject("usuario", new Usuario());
        mv.setViewName("login/login");
        return mv;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("aluno", new Aluno());
        
        return mv;
    }
    
    @PostMapping("/login")
    public ModelAndView logar(@Valid Usuario obj, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, UserLoginException{
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        if(br.hasErrors()){
            mv.setViewName("login/login");
        }
        Usuario usuarioLogin = this.service.logar(obj.getLogin(), Config.md5(obj.getSenha()));
        if(usuarioLogin == null){
            mv.addObject("msg", "Usuario e/ou senha incorreto. Tente novamente");
        }else{
            session.setAttribute("usuarioLogado", usuarioLogin);
            return index();
        }

        return mv;
    }

    @PostMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.invalidate();
        return login();
    }
    
}
