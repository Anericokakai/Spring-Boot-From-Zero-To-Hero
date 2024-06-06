package com.ricodev.springbootsetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Speed {
    int carSpeed =80;

    public int getSpeed() {
        return carSpeed;
    }
    public void setSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }
    void printCarSpeed(){
        System.out.println("<----car speed--->".toUpperCase());
        System.out.println("\n Car average Speed:".toUpperCase() +carSpeed +" Km/hr\n".toUpperCase());

    }
}
