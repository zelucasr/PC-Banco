/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.banco;

/**
 *
 * @author Zé
 */
public class Terminal extends Thread {
    
    private Banco banco;
    private Cliente currentCliente;
    private Conta currentConta;
    
    public void run(){
        currentCliente = null;
        currentConta = null;
        //System.out.println("haha");
    }
    
    //Método para acessar o terminal com determinado cartao e operacao
    public boolean acessar(Cliente cliente, String agenciaID, String contaID, int op, double valor) throws InterruptedException{
        
        synchronized(this)
        {
            if(banco.getInstance().verificarAtendimento(cliente) > 0) 
            {
                System.out.println(this.getName() + ": " + cliente.getNome() + " tentou acessar novamente");
                return false;
            }
            else
            {
                setCurrentCliente(cliente);
                Agencia agencia = banco.getInstance().getAgencia(agenciaID);
                Conta conta = agencia.getConta(contaID);
                
                setCurrentConta(conta);
                System.out.println("Cliente atual: "+currentCliente.getNome()+" em "+this.getName());
            }
        }
        
        Thread.sleep(Regras.getRandMS());
        return true;
    }
    
    public synchronized void transferencia(Conta outraConta, Banco b, Agencia ag, double v)
    {
        //testar se é do mesmo banco
        if(currentConta.getBanco().getId()== outraConta.getBanco().getId()){
            
            //cliente quantidade (na conta)
            int cqtd = currentConta.getClientsQTD();
             
            //valor total transferido no dia
            double vtra = currentConta.getTransferenciaMAX(currentCliente);
            boolean tmax = Regras.testarTransfereciaMAX(vtra, cqtd);
            
            //saldo maior que valor
            boolean smqv = v <= currentConta.getSaldo();
            
            //testars se nao exede o valor maximo de transferencias diarias
            if(tmax && smqv)
            {
                currentConta.subtrair(v);
                
                //TODO adicionar a lista de depositos na agencia
                outraConta.adicionar(v); 
            }
            
        }//testars se nao exede o valor maximo de transferencias diarias para outros bancos
        else{
            currentConta.subtrair(v+Regras.getTransferenciaTAX());
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
