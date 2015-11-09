package com.example.paulo.inovacao;

/**
 * Created by Paulo on 27/10/2015.
 */
public class Contratante {
    private String nome, login, senha;

            public Contratante(String nome, String login){
                this.nome = nome;
                this.login = login;
            }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
