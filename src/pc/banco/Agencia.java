/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.banco;

import Patterns.Observador;
import java.util.ArrayList;

/**
 *
 * @author Zé
 */
public class Agencia implements Observador{
    
    private Integer id;
    private Banco banco;
    private ArrayList<Conta> contas;
    //private ArrayList<Depositos> operacoes; //TODO lista de operaçoes a serem realizadas ao final do dia (depositos)
    
    public Agencia(Banco banco){
        contas = new ArrayList();
        this.banco=banco;
    }
    
    /**
     * TODO
     */
    public void update()
    {
        //foreach(conta in operação)depositar valores
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void addConta(Conta conta){
        contas.add(conta);
    }
    
}
