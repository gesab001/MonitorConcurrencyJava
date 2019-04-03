/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 14400
 */
public class RiderThread extends Thread {
    Cars cars;
    int threadName;
    
    RiderThread (Cars cars, int threadName){
        this.cars = cars;
        this.threadName = threadName;
    }
    
    public synchronized void run(){
        try {
            int lengthOfRide = ThreadLocalRandom.current().nextInt(1000, 5000);
            cars.rideCar(threadName, lengthOfRide);
            Thread.sleep(lengthOfRide);
            cars.returnCar(threadName);
        } catch (InterruptedException ex) {
            Logger.getLogger(RiderThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
