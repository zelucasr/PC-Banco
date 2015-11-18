/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.banco;

import java.util.Random;

/**
 *
 * @author Alvaro
 */
public class Regras 
{
    private static int clientsQTD = 3;
    private static int retiradaQTD = 3;
    private static double transferenciaTAX = 10;
    private static double retiradaMAX = 2000;
    private static double transferenciaMAX = 5000;
    private static double transferenciaOutroMAX = 3000;
    private static int randMS = 5000;
    
    public static boolean testarClientsQTD(int qtd)
    {
        if(qtd <= clientsQTD) return true;
        else return false;
    }
    
    public static boolean testarRetiradaQTD(int qtd)
    {
        if(qtd <= retiradaQTD)return true;
        else return false;
    }
    
    public static boolean testarRetiradaMAX(double val, int qtd)
    {
        double temp = retiradaMAX;
        if(qtd == 2 ) temp *= 0.8;
        else if(qtd == 3) temp *= 0.7;
        
        if(val >= temp) return true;
        else return false;
    }
    
    public static boolean testarTransfereciaMAX(double val, int qtd)
    {
        if(val >= transferenciaMAX) return true;
        else return false;
    }
    
    public static boolean testarTransfereciaOutroMAX(double val, int qtd)
    {
        if(val >= transferenciaOutroMAX) return true;
        else return false;
    }
    
    public static double getTransferenciaTAX()
    {
        return transferenciaTAX;
    }
    
    public static int  getRandMS()
    {
        return new Random().nextInt(randMS);
    }
}
