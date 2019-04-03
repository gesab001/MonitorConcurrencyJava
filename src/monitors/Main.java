/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 14400
 */
public class Main  {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Cars cars = new Cars(){};
        for (int i = 0; i<10; i++){
            RiderThread riderThread = new RiderThread(cars, i);
            riderThread.start();
        }
        
    }
}
