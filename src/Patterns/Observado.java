/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class Observado 
{
    ArrayList<Observador> observadores;
    
    public Observado()
    {
        observadores = new ArrayList<>();
    }
    
    
    public void addObservador(Observador o)
    {
        observadores.add(o);
    }
    
    public void delObservador(Observador o)
    {
        observadores.remove(o);
    }
    
    public void notificar()
    {
        for(Observador o : observadores)
            o.update();
    }
}
