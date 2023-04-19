package com.maxi.sistemaAcademico.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.sistemaAcademico.config.Config;
import com.maxi.sistemaAcademico.exceptions.EmailExisteException;
import com.maxi.sistemaAcademico.exceptions.UserLoginException;
import com.maxi.sistemaAcademico.models.Usuario;
import com.maxi.sistemaAcademico.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario criarUsuario(Usuario obj) throws Exception{
        List<Usuario> userEmails = new ArrayList<>();
        List<Usuario> userLogins = new ArrayList<>();

        userEmails = this.repo.findByEmail(obj.getEmail());
        userLogins = this.repo.findByLogin(obj.getLogin());

         if(userEmails.size() != 0){
             throw new EmailExisteException("Ja existe esse email cadastrado para: "+ obj.getEmail() +" "+ obj.getLogin());
         }else{
             obj.setSenha(Config.md5(obj.getSenha()));
        }
        return this.repo.save(obj);        
    }
    

    public Usuario logar(String usr, String pwd) throws UserLoginException{
        Usuario logado = this.repo.logar(usr, pwd);
        return logado;
    }

}
