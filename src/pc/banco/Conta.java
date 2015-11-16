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
public class Conta {
    
    private Banco banco;
    private String numero;
    private ArrayList<Cliente> clients;
    private ArrayList<Cartao> cartoes;
    private Boolean solidario;
    private double saldo;
    
    public Conta(){
        clients = new ArrayList();
        setSaldo(0);
        setSolidario(false);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Boolean getSolidario() {
        return solidario;
    }

    public void setSolidario(Boolean solidario) {
        this.solidario = solidario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void addCliente(Cliente alguem){
        if(clients.size()<3){
            clients.add(alguem);
            if(clients.size()>1){
                setSolidario(true);
            }
        }
        else{
            System.out.println("A conta já possui 3 clientes associados");
        }
    }

    public void subtrair(double v) {
        this.setSaldo(this.getSaldo()-v);
    }
    
    public void adicionar(double v){
        this.setSaldo(this.getSaldo()+v);
    }

    public Banco getBanco() {
        return banco.getInstance();
    }
    
}
