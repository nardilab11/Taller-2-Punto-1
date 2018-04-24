/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Direction;

/**
 *
 * @author Estudiante
 */
public class Sembrador extends Drone{
    private int semillas;

    public Sembrador(int semillas, Cultivo city, int x, int y, Direction direccion, int nThing) {
        super(city, x, y, direccion, nThing);
        this.semillas = semillas;
    }

    @Override
    public void consumirEnergia(int x, int y) {
           if(2*this.medirDistancia(x,y)>this.energia){
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
            this.energia =- x+y;
      }
    }
    public boolean sembrar(Planta planta){
        this.putThing();
        this.semillas--;
      return true;
    }
    
    
}
