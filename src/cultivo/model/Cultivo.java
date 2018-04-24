/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Thing;
import java.util.ArrayList;
import cultivo.model.Sembrador;
import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class Cultivo extends City {
    private int ancho;
    private int alto;
    private ArrayList<Planta> plantas;
    private ArrayList<Panel> paneles;
    private Drone[] drones ; 
    private Sembrador sembrador;
    private Monitor monitor;
    
    public Cultivo(int ancho, int alto) {
        this.alto=alto;
        this.ancho = ancho;
        this.plantas = new ArrayList<>();
        this.paneles = new ArrayList<>();
        this.drones = new Drone[2];
        this.drones[1] = sembrador;
        this.drones[2] = monitor;
    }
    
    public boolean realizarMonitoreo(double humedad, double temp){
       for(int i = 0; i < ancho; i++){
           for(int j = 0; j < alto; j++){
               monitor.consumirEnergia(i, j);
               monitor.realizarMonitoreo(humedad, temp, 1, 1);
           }
       }
        return true;
    }
    public boolean medirFertilizante(int cantFertilizante){
      for(int i = 0; i < ancho; i++){
           for(int j = 0; j < alto; j++){
               monitor.medirFertilizante(cantFertilizante, i, j);
           }
       }
        return true;
    }
    
    public boolean ponerFertilizante(int x, int y, int cantidad){
      return false;
    }
    public boolean sembrar(double humedad, double temperatura, int fertilizante, int x, int y){
        Planta planta = new Planta(humedad, temperatura, fertilizante, this, x, y);
        sembrador.sembrar(planta);
        return true;
    }
    
    public boolean addPanel(Panel panel){
      paneles.add(panel);
        return true;
    }
    
    public boolean addSembrador(Sembrador sembradordron){
        this.sembrador = sembradordron;
        return true;
    }
    
    public boolean addMonitor(Monitor monitordron){
        this.monitor = monitordron;
        return true;
    }
    public boolean addPlanta(Planta planta){
        plantas.add(planta);
       return true;
    }

    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(ArrayList<Planta> plantas) {
        this.plantas = plantas;
    
    }

    public Sembrador getSembrador() {
        return sembrador;
    }
    
}
