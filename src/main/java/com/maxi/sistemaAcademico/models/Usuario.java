package com.maxi.sistemaAcademico.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    @Size(min = 4, message = "O nome de usuario deve ter no minimo 4 caracteres.")
    private String login;

    @Column(name = "senha")
    @Size(min = 5, message = "A senha deve ter no minimo 5 digito")
    private String senha;

    @Email(message = "Informe um email valido. Ex: xxxx@y.com")
    private String email;

    private String privilegio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   public String getLogin() {
       return login;
   }

   public void setLogin(String login) {
       this.login = login;
   }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    
    
}
