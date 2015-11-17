/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.banco;

import Patterns.Observado;
import java.util.ArrayList;
/**
 *
 * @author Zé
 */
public class Banco extends Observado implements Runnable{
    
    private String nome;
    private int id;
    private ArrayList<Agencia> agencias;
    private ArrayList<Cliente> emAtendimento;
    private ArrayList<Cliente> cliente;
    private static Banco banco = new Banco();
    
    
    
    private Banco(){
        super();
        agencias = new ArrayList();
        emAtendimento = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(ArrayList<Agencia> agencias) {
        this.agencias = agencias;
    }

    public ArrayList<Cliente> getEmAtendimento() {
        return emAtendimento;
    }

    public void setEmAtendimento(ArrayList<Cliente> emAtendimento) {
        this.emAtendimento = emAtendimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public synchronized static Banco getInstance(){
        return banco;
    }
    
    /**
     * TODO
     */
    public void run()
    {
        
    }
    
}
