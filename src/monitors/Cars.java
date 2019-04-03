/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 14400
 */
public class Cars {
    public static volatile int carsRunning = 0;

    public synchronized void rideCar(int threadName, int lengthOfRide){
        while(carsRunning>=3) try {
            wait();
            System.out.println(threadName + " Please wait in line");
            } catch (InterruptedException ex) {
                Logger.getLogger(Cars.class.getName()).log(Level.SEVERE, null, ex);
            }
        carsRunning = carsRunning + 1;
        System.out.println(threadName + " is riding for " + lengthOfRide);
        System.out.println(carsRunning + " car is/are running");
    }
    
    public synchronized void returnCar(int threadName){
        carsRunning = carsRunning  - 1;
        int carsAvailable = 3 - carsRunning;
        notifyAll();
        System.out.println(threadName + " is returning the car ");
        System.out.println("There is/are car/s " + carsAvailable + " available");

    }
}
