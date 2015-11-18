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
    private ArrayList<String> cartoes;
    private ArrayList<Conta> contas;

    public Cliente(String nome, String cpf)
    {
        this.nome = nome;
        this.cpf = cpf;
        cartoes = new ArrayList<>();
        contas = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void addConta(Conta conta)
    {
        this.contas.add(conta);
    }
    
    public void addCartao(String cartao)
    {
        this.cartoes.add(cartao);
    }
    
}
