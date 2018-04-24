/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IIterate;
import becker.robots.Thing;
import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class Monitor extends Drone{
    private String tipoCamara;

    public Monitor(String tipoCamara, Cultivo city, int x, int y, Direction direccion, int nThing) {
        super(city, x, y, direccion, nThing);
        this.tipoCamara = tipoCamara;
    }
    public Cultivo getCultivo(){
        return this.cultivo;
    }
    public int realizarMonitoreo(double humedad, double temp, int x, int y){ 
        int plantasN = 0;
        this.mirarEste();
        if(this.energia > (2*x)+(2*y))
        for(int i = 0; i < x; i++){
            this.move();
        IIterate<Thing> plantas1 = this.examineThings();
            while(plantas1.hasNext()){
                Thing _planta  = plantas1.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                    if(f.getTemperatura()>=temp || f.getHumedad()>= humedad){
                        f.cambiarColor();
                        plantasN++;
                    }
               }
            }
            
        
    
        for(int j = 0; j < y; j++){
            this.move();
        IIterate<Thing> plantas2 = this.examineThings();
            while(plantas2.hasNext()){
                Thing _planta  = plantas2.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                    if(f.getTemperatura()>=temp || f.getHumedad()>= humedad){
                        f.cambiarColor();
                        plantasN++;
                    }
               }
            }
            
        }
        for(i = x; i > 0; i--){
            this.move();
        IIterate<Thing> plantas3 = this.examineThings();
            while(plantas3.hasNext()){
                Thing _planta  = plantas3.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                    if(f.getTemperatura()>=temp || f.getHumedad()>= humedad){
                        f.cambiarColor();
                        plantasN++;
                    }
               }
            }
            
        }
        for(int j = y; j > 0; j--){
            this.move();
        IIterate<Thing> plantas4 = this.examineThings();
            while(plantas4.hasNext()){
                Thing _planta  = plantas4.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                    if(f.getTemperatura()>=temp || f.getHumedad()>= humedad){
                        f.cambiarColor();
                        plantasN++;
                    }
               }
            }
            
        }
        }
       return plantasN;
    }
    
    public int medirFertilizante(int cantFertilizante, int x, int y){
        int plantasF = 0;
      this.mirarEste();
        if(this.energia > (2*x)+(2*y))
        for(int i = 0; i < x; i++){
            this.move();
        IIterate<Thing> plantas1 = this.examineThings();
            while(plantas1.hasNext()){
                Thing _planta  = plantas1.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                    if(f.getCantFertilizante()<cantFertilizante){
                        this.ponerFertilizante(this.getStreet(), this.getAvenue(), cantFertilizante);
                        plantasF++;
                    }
               }
            }
        }
        for(int j = 0; j < y; j++){
            this.move();
        IIterate<Thing> plantas2 = this.examineThings();
            while(plantas2.hasNext()){
                Thing _planta  = plantas2.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                    if(f.getCantFertilizante()<cantFertilizante){
                        this.ponerFertilizante(this.getStreet(), this.getAvenue(), cantFertilizante);
                        plantasF++;
                    }
               }
            }   
        }
        for(int i = x; i > 0; i--){
            this.move();
        IIterate<Thing> plantas3 = this.examineThings();
            while(plantas3.hasNext()){
                Thing _planta  = plantas3.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                    if(f.getCantFertilizante()<cantFertilizante){
                        this.ponerFertilizante(this.getStreet(), this.getAvenue(), cantFertilizante);
                        plantasF++;
                    }
               }
            }
            
        }
        for(int j = y; j > 0; j--){
            this.move();
        IIterate<Thing> plantas4 = this.examineThings();
            while(plantas4.hasNext()){
                Thing _planta  = plantas4.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                    if(f.getCantFertilizante()<cantFertilizante){
                        this.ponerFertilizante(this.getStreet(), this.getAvenue(), cantFertilizante);
                        plantasF++;
                    }
               }
            }
            
        }
        
       return plantasF;  
      
    }
    public boolean ponerFertilizante(int x, int y, int cantidad){
        this.consumirEnergia(x, y);
        IIterate<Thing> plantas = this.examineThings();
            while(plantas.hasNext()){
                Thing _planta  = plantas.next();
                if(_planta instanceof Planta){
                   Planta f = (Planta)(_planta);
                       f.setCantFertilizante(cantidad);
                }
            }
      return true;
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
    
}
