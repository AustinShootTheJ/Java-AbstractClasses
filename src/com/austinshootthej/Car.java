package com.austinshootthej;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Car extends Vehicle implements Driving{
    private int currentGear;
    private String model;
    private GearBox gearBox;
    private int currentSpeed;

    public Car( String model, int numberOfGears, double ratio) {
        this.currentGear = 0;
        this.currentSpeed = 0;
        this.model = model;
        this.gearBox = new GearBox(numberOfGears,ratio);
    }


    // Driving implementation


    @Override
    public void accelerate(int desiredSpeed) {
        getCurrentSpeed();
        System.out.println(" accelerating to " + desiredSpeed);

        if(desiredSpeed > currentSpeed)
        {
            if (currentSpeed == 0){
                shiftGearUp();
            }

            do{
                currentSpeed+=1;
                shiftGearUp();

            }while(currentSpeed != desiredSpeed);
        }


        System.out.println(" Reached " + currentSpeed);
    }

    @Override
    public void decelerate(int desiredSpeed) {
        getCurrentSpeed();
        System.out.println("Decelerating to " + desiredSpeed);
        if (desiredSpeed < currentSpeed)
        {
            if (currentSpeed == 0){
                System.out.println("Already in neutral");
            }
            do {
                currentSpeed-=1;
                shiftGearDown();

            }while (currentSpeed!= desiredSpeed);

        }

        System.out.println(" Reached " + currentSpeed);
    }

    public int getCurrentSpeed() {
        System.out.println("Current speed: " + this.currentSpeed);
        return currentSpeed;
    }


    // Abstract methods


    @Override
    public void shiftGearUp() {
    ListIterator<Gear> gearListIterator = gearBox.gears.listIterator();

        switch(currentSpeed){
            case 0:
                System.out.println("Shifting out of neutral into first" );


                this.currentGear = 0;
                currentGear = gearListIterator.next().getGearNumber()+ 1;
                gearListIterator.next();
                System.out.println(currentGear);
                break;

            case 15:
                System.out.println("Shifting into second at " + currentSpeed + " MPH");
                this.currentGear = 1;

                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                 currentGear = gearListIterator.next().getGearNumber()+ 1;
                System.out.println(currentGear);

                break;

            case 30:
                System.out.println("Shifting into third at " + currentSpeed + " MPH");
                this.currentGear = 2;
                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber()+ 1;
                System.out.println(currentGear);

                break;

            case 50:
                System.out.println("Shifting into fourth at " + currentSpeed + " MPH");
                this.currentGear = 3;
                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber()+ 1;
                System.out.println(currentGear);
                break;

            case 65:
                System.out.println("Shifting into fifth at "+ currentSpeed + " MPH");
                this.currentGear = 4;
                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber()+ 1;
                System.out.println(currentGear);
                break;

            case 75:
                System.out.println("Shifting into sixth Open er up!");
                this.currentGear = 5;
                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber() + 1;
                System.out.println(currentGear);
                break;

            default: break;
        }
    }

    @Override
    public void shiftGearDown() {

        ListIterator<Gear> gearListIterator = gearBox.gears.listIterator();

        switch(currentSpeed){
            case 0:
                System.out.println("Shifting out of first into neutral" );


                this.currentGear = 0;
                currentGear = gearListIterator.next().getGearNumber();
                gearListIterator.next();
                System.out.println(currentGear);
                break;

            case 15:
                System.out.println("Shifting into first at " + currentSpeed + " MPH");
                this.currentGear = 1;

                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber();
                System.out.println(currentGear);

                break;

            case 30:
                System.out.println("Shifting into second at " + currentSpeed + " MPH");
                this.currentGear = 2;
                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber();
                System.out.println(currentGear);

                break;

            case 50:
                System.out.println("Shifting into third at " + currentSpeed + " MPH");
                this.currentGear = 3;
                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber();
                System.out.println(currentGear);
                break;

            case 65:
                System.out.println("Shifting into fourth at "+ currentSpeed + " MPH");
                this.currentGear = 4;
                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber();
                System.out.println(currentGear);
                break;

            case 75:
                System.out.println("Shifting into fifth at " + currentSpeed + " MPH");
                this.currentGear = 5;
                if (gearListIterator.hasNext()){
                    for (int i = 0; i<currentGear; i++){
                        gearListIterator.next();
                    }

                }

                currentGear = gearListIterator.next().getGearNumber();
                System.out.println(currentGear);
                break;

            default: break;
        }
    }

    public void listGears(){
        this.gearBox.listGears();
 }


    private class GearBox{
        private int numberOfGears;
        private double ratio;
        private List<Gear> gears;

        private GearBox(int numberOfGears, double ratio) {
            this.numberOfGears = numberOfGears;
            this.ratio = ratio;
            this.gears = new ArrayList<Gear>();
            for(int i = 0; i<numberOfGears; i++){
                addGear(i);
            }
        }

        private void addGear(int gearNumber){
            Gear gear = new Gear(gearNumber);
            gears.add(gear);
        }

        private void listGears(){



            for(int i =0; i<gears.size(); i++){

                this.gears.get(i).getGearNumber();

            }


        }



    }

    private class Gear {
       private int gearNumber;

        private Gear(int gearNumber) {
            this.gearNumber = gearNumber;
        }

       /* private void getGearNumber() {
            int tempNumber = gearNumber + 1;
            System.out.println("Gear# " + tempNumber);
        }*/

        public int getGearNumber() {
            return gearNumber;
        }
    }



}
