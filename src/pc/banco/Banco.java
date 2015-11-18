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
    private ArrayList<Cliente> clientes;
    private static Banco banco = new Banco();
    
    
    
    private Banco(){
        super();
        agencias = new ArrayList();
        emAtendimento = new ArrayList();
    }
    
    public synchronized int verificarAtendimento(Cliente cliente)
    {
        return clientes.indexOf(cliente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Agencia getAgencia(String id) {
        for(Agencia agencia : agencias)
            if(agencia.getId().equals(id)) return agencia;
        
        return null;
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
