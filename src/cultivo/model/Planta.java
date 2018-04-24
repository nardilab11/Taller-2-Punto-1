/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Thing;

/**
 *
 * @author Estudiante
 */
public class Planta extends Thing{
    private double humedad;
    private double temperatura;
    private int cantFertilizante;
    private String color;

    public Planta(double humedad, double temperatura, int cantFertilizante, City city, int i, int i1) {
        super(city, i, i1);
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.cantFertilizante = cantFertilizante;
        this.color = "Verde";
    }
    
    public void adicionarFertilizante(int cantidad){
        this.cantFertilizante += cantidad;
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    public void cambiarColor(){
       this.color = "Amarillo";
    }

    public double getHumedad() {
        return humedad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getCantFertilizante() {
        return cantFertilizante;
    }

    public void setCantFertilizante(int cantFertilizante) {
        this.cantFertilizante = cantFertilizante;
    }
    
}
