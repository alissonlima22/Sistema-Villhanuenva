/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Alisson
 */
public class AblUsuarios {
    private int mpvIdUsuarios;
    private String mpvNome; 
    private String mpvApelido;
    private String mpvCpf;
    private Date mpvDataNascimento;
    private int mpvNivel;
    private String mpvSenha;
    private String mpvAtivo;
    /**
     * @return the mpvIdUsuarios
     */
 public int getMpvIdUsuarios() {
        return this.mpvIdUsuarios;
    }

    public void setMpvIdUsuarios(int codigo) {
        this.mpvIdUsuarios = codigo;
    }

    public String getMpvNome() {
        return this.mpvNome;
    }

    public void setMpvNome(String nome) {
        this.mpvNome = nome;
    }

    public String getMpvApelido() {
        return this.mpvApelido;
    }

    public void setMpvApelido(String apelido) {
        this.mpvApelido = apelido;
    }

    public String getMpvCpf() {
        return this.mpvCpf;
    }

    public void setMpvCpf(String cpf) {
        this.mpvCpf = cpf;
    }

    // Data de nascimento do usuário
    public Date getMpvDataNascimento() {
        return this.mpvDataNascimento;
    }

    public void setMpvDataNascimento(Date nascimento) {
        this.mpvDataNascimento = nascimento;
    }

    public int getMpvNivel() {
        return this.mpvNivel;
    }

    public void setMpvNivel(int nivel) {
        this.mpvNivel = nivel;
    }

    public String getMpvSenha() {
        return this.mpvSenha;
    }

    public void setMpvSenha(String senha) {
        this.mpvSenha = senha;
    }

    public String getMpvAtivo() {
        return this.mpvAtivo;
    }

    public void setMpvAtivo(String status) {
        this.mpvAtivo = status;
    }

}