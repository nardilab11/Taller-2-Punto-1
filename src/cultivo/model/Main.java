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
 * @author Nicolás
 */
public class Main {
    public static void main(String[] args) {
        Cultivo ciudad = new Cultivo(10, 10);
        Monitor monitor1 = new Monitor("Epson",ciudad,0,0,Direction.EAST,5);
        ciudad.addMonitor(monitor1);
        Sembrador sembrador1 = new Sembrador(5,ciudad,0,0,Direction.EAST,5);
        ciudad.addSembrador(sembrador1);
        ciudad.realizarMonitoreo(100, 200);
    }
}
