/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.banco;

import java.util.Random;

/**
 *
 * @author Zé
 */
public class Terminal extends Thread {
    
    private Cliente currentCliente;
    private Conta currentConta;
    
    public void run(){
        currentCliente = new Cliente();
        currentConta = new Conta();
        //System.out.println("haha");
    }
    
    //Método para acessar o terminal com determinado cartao e operacao
    public boolean acessar(Cartao cartao, Cliente cliente, int op, double valor) throws InterruptedException{
        setCurrentCliente(cliente);
        System.out.println("Cliente atual: "+currentCliente.getNome()+" em "+this.getName());
        
        switch(op){
            case 0:
                //saque();
                break;
            case 1:
                //deposito();
                break;
        }
        
        Random gerador = new Random();
        Thread.sleep(gerador.nextInt(10000));
        
        return true;
    }
    
    public void transferencia(Conta outraConta, Banco b, Agencia ag, double v){
        if(currentConta.getBanco().getId()==outraConta.getBanco().getId()){
            currentConta.subtrair(v);
            outraConta.adicionar(v);
        }
        else{
            currentConta.subtrair(v+10);//10 da regra de negócio
            outraConta.adicionar(v);
        }
    }
    
    //Docs?
    
    public void saque(double v){
        currentConta.subtrair(v);
        System.out.println("O cliente "+currentCliente.getNome()+" sacou R$"+v+" de sua conta");
    }
    
    public void deposito(double v){
        currentConta.adicionar(v);
        System.out.println("O cliente "+currentCliente.getNome()+" depositou R$"+v+" em sua conta");
    }
    
    /*
    * Métodos de get e set para Cliente e Conta que estão sendo utilizados
    * no momento no terminal.
    */

    public Cliente getCurrentCliente() {
        return currentCliente;
    }

    public void setCurrentCliente(Cliente currentCliente) {
        this.currentCliente = currentCliente;
    }

    public Conta getCurrentConta() {
        return currentConta;
    }

    public void setCurrentConta(Conta currentConta) {
        this.currentConta = currentConta;
    }
    
}
