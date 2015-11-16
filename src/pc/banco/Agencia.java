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
public class Agencia {
    
    private Integer id;
    private Banco banco;
    private ArrayList<Conta> contas;
    
    public Agencia(Banco banco){
        contas = new ArrayList();
        this.banco=banco;
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
