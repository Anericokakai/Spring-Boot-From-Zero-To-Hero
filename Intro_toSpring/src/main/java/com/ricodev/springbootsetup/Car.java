package com.ricodev.springbootsetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

//     CONSTRUCTOR DEPENDENCY INJECTION

    Engine engine;
    Fuel fuel;
   Speed speed;




@Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

   @Autowired
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
    @Autowired
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }




// Modify the speed which is wrong
    void modifySpeed(){
    Speed speed1=new Speed();
    speed1.setSpeed(2000);
    this.speed=speed1;
    }

    void  printCarStatus(){
    modifySpeed();
speed.printCarSpeed();

        System.out.println("<---car status--->\n".toUpperCase());

        if(engine==null||fuel==null){
            System.out.println("Car cannot run without fuel or engine".toUpperCase());

        return;}

        System.out.println("\nThe car has all the necessity to run".toUpperCase());
    }
}
