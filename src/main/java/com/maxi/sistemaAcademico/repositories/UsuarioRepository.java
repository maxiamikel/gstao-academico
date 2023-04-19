package com.maxi.sistemaAcademico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maxi.sistemaAcademico.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public List<Usuario> findByEmail(String email);

    public List<Usuario> findByLogin(String login);

    @Query("select u from Usuario u where u.login = :usr and u.senha = :pwd")
    public Usuario logar(String usr, String pwd);
    
}
