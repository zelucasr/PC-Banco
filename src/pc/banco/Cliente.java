/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.banco;

import java.util.ArrayList;

/**
 *
 * @author Zé
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private ArrayList<Cartao> cartoes;
    private ArrayList<Conta> contas;

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
    
}
