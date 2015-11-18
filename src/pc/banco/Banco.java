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
public class Banco extends Observado
{
    
    private String nome;
    private String id;
    private ArrayList<Agencia> agencias;
    private ArrayList<Cliente> emAtendimento;
    private ArrayList<Cliente> clientes;
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

    public Agencia getAgencia(String id) {
        for(Agencia agencia : agencias)
            if(agencia.getId().equals(id)) return agencia;
        
        return null;
    }

    /**
     * este metodo é usado pra verificar se o cliente esta na fila de clientes em atendimento
     * @param cliente o cliente a ser verificado
     * @return -1 caso o cliente nao esteja sendo atendido ou ou indice caso contrario
     */
    public synchronized int getEmAtendimento(Cliente cliente) {
        return clientes.indexOf(cliente);
    }

    /**
     * metodo usado para adicionar o cliente na lista de clientes sendo atendidos
     * @param cliente o cliente a ser adicionado
     */
    public synchronized void setEmAtendimento(Cliente cliente) {
        this.emAtendimento.add(cliente);
    }
    
    public synchronized static Banco getInstance()
    {
        return banco;
        
    }
    
    
    public void addCliente(Cliente cliente)
    {
        clientes.add(cliente);
    }
    
    /**
     * TODO
     */
    public void run()
    {
        
    }
    
}
