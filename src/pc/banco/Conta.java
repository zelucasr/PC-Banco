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
public class Conta implements Observador{
    
    private Banco banco;
    private String numero;
    private ArrayList<Cliente> clients;
    private ArrayList<Cartao> cartoes;
    
    //listas a baixo precisam ser zeradas ao final do dia
    private ArrayList<Integer> retiradaQTD;
    private ArrayList<Double> retiradaMAX;
    private ArrayList<Double> transferenciaMAX;
    private ArrayList<Double> transferenciaOutroMAX;
    
    private Boolean solidario;//TODO remover
    private double saldo;
    
    public Conta(){
        clients = new ArrayList();
        setSaldo(0);
        setSolidario(false);
    }

    /**
     * zera todos os valores ao final do dia
     */
    public void update()
    {
        for(int rqtd : retiradaQTD) rqtd = 0;
        for(double rmax : retiradaMAX) rmax = 0;
        for(double tmax : transferenciaMAX) tmax = 0;
        for(double omax : transferenciaOutroMAX) omax = 0;
    }
    
    /**
     * 
     * @param cliente usado para achar o indice do cliente
     * @return o valor do indice do cliente
     */
    private int getIndex(Cliente c){ return clients.indexOf(c);}
    
    /**
     * 
     * @param cliente usado para achar o indice do cliente
     * @return a quantidade retiradas efetuadas no dia do cliente
     */
    public int getRetiradaQTD(Cliente cliente)
    {
        return retiradaQTD.get(getIndex(cliente));
    }
    
    /**
     * 
     * @param cliente usado para achar o indice do cliente
     * @return o valor retirado no dia do cliente
     */
    public double getRetiradaMAX(Cliente cliente)
    {
        return retiradaMAX.get(getIndex(cliente));
    }
    
    /**
     * 
     * @param cliente usado para achar o indice do cliente
     * @return o valor transferido para outros bancos por dia do cliente
     */
    public double getTransferenciaMAX(Cliente cliente)
    {
        return transferenciaMAX.get(getIndex(cliente));
    }
    
    /**
     * 
     * @param cliente usado para achar o indice do cliente
     * @return o valor transferido para outros bancos por dia do cliente
     */
    public double getTransferenciaOutroMAX(Cliente cliente)
    {
        return transferenciaOutroMAX.get(getIndex(cliente));
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
                setSolidario(true);//TODO remover
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
    
    public int getClientsQTD()
    {
        return clients.size();
    }
    
    
 
}
