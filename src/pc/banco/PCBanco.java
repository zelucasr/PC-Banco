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
public class PCBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Banco meuBanco = Banco.getInstance();
        
        Agencia agencia1 = new Agencia(meuBanco);
        agencia1.setId(1);
        
        Terminal terminal1 = new Terminal();
        terminal1.setName("Terminal 1");
        terminal1.start();
        Terminal terminal2 = new Terminal();
        terminal2.setName("Terminal 2");
        terminal2.start();
        
        Cliente cliente1 = new Cliente();
        Cartao cartao1 = new Cartao();
        Conta conta1 = new Conta();
        cliente1.setNome("João");
        cliente1.setCpf("017208195-38");
        cartao1.setNumeracao("123");
        conta1.addCliente(cliente1);
        conta1.setNumero("1");
        agencia1.addConta(conta1);
        
        while(true){//TODO fixar isso para uma conta
            terminal1.acessar(cartao1, cliente1, 1, 1);
        }
        
        
    }
    
}
