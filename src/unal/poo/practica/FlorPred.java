/*
  Clase que permite chequear si un Thing es de un tipo especifico.
 */
package unal.poo.practica;

import becker.robots.IPredicate;
import becker.robots.Sim;

/**
 *
 * @author Fabian Giraldo
 */
public class FlorPred implements IPredicate
  { 
     public boolean isOK(Sim s)
     {  return s instanceof Flor;
     }
  }
