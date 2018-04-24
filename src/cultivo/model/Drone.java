/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @author Estudiante
 */
public abstract class Drone extends Robot{
    protected String icono;
    protected int energia;
    protected Cultivo cultivo;

    public Drone(Cultivo cultivo, int x, int y, Direction direccion, int nThing) {
        super(cultivo, x, y, direccion, nThing);
        this.energia = nThing;
    }
    
    public int medirDistancia(int x, int y){
       return Math.abs(this.getStreet()-x)+Math.abs(this.getAvenue()-y);
    }
    
    public void mirarSur(){
        if(this.getDirection()==Direction.NORTH){
            this.turnLeft();
            this.turnLeft();
        }
        if(this.getDirection()==Direction.WEST){
            this.turnLeft();
        }
        if(this.getDirection()==Direction.EAST){
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
        }
    }
    
    public void mirarNorte(){
        if(this.getDirection()==Direction.SOUTH){
            this.turnLeft();
            this.turnLeft();
        }
        if(this.getDirection()==Direction.EAST){
            this.turnLeft();
        }
        if(this.getDirection()==Direction.WEST){
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
        }
    }
    
    public void mirarEste(){
        if(this.getDirection()==Direction.WEST){
            this.turnLeft();
            this.turnLeft();
        }
        if(this.getDirection()==Direction.SOUTH){
            this.turnLeft();
        }
        if(this.getDirection()==Direction.NORTH){
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
        }
    }
    
    public void mirarOeste(){
        if(this.getDirection()==Direction.EAST){
            this.turnLeft();
            this.turnLeft();
        }
        if(this.getDirection()==Direction.NORTH){
            this.turnLeft();
        }
        if(this.getDirection()==Direction.SOUTH){
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
        }
    }
    public abstract void consumirEnergia(int x, int y);
    
    public  void cargarEnergia(int cantidad){
      if(cantidad > 0)
        this.energia +=cantidad; 
    }
    public boolean irZonaCarga(int x, int y){
        if(this.medirDistancia(x, y)>=this.energia){
            if(this.getStreet()>=y){
                this.mirarNorte();
                for(int i = 0; i < this.getStreet()-y; i++){
                    this.move();
                }
            }if(this.getStreet()<y){
                this.mirarSur();
                for(int i = 0; i < y-this.getStreet(); i++){
                    this.move();
                }
            }if(this.getAvenue()>=x){
                this.mirarOeste();
                for(int i = 0; i < this.getStreet()-x; i++){
                    this.move();
                }
            }if(this.getAvenue()<x){
                this.mirarEste();
                for(int i = 0; i < x-this.getStreet(); i++){
                    this.move();
                }
            }
            this.energia -= this.medirDistancia(x, y);
            do{
            this.pickThing();
            }while(this.canPickThing());
            return true;
        }else{
      return false;
        }
    }
    
}
