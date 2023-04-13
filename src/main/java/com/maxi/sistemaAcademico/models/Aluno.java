package com.maxi.sistemaAcademico.models;

import java.time.LocalDate;

import com.maxi.sistemaAcademico.enums.Curso;
import com.maxi.sistemaAcademico.enums.Genero;
import com.maxi.sistemaAcademico.enums.Status;
import com.maxi.sistemaAcademico.enums.Turno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @Size(min = 5, max = 40, message = "Ingressa o nome completo")
    @NotBlank(message = "O nome é obligatorio")
    private String nome;

    @Column(name="cpf")
    @Size(min = 11, max = 14, message = "Informe um CPF válido. Ex: 000.000.000-00")
    @NotBlank(message = "Informe um CPF válido. Ex: 000.000.000-00")
    private String cpf;

    @Column(name="curso")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O curso não pode ser vazio")
    private Curso curso;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="matricula")
    private String matricula;

    @Column(name="turno")
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "naccimento")
    @Temporal(TemporalType.DATE)
    private LocalDate nascimento;

    @Column(name = "dataCadastro")
    @Temporal(TemporalType.DATE)
    private LocalDate dataCadastro;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Turno getTurno() {
        return turno;
    }
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    
    
}
