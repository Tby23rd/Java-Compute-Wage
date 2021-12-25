package com.company;

import java.util.Scanner;

public class ComputeWage {
    private String name;
    private double gtotal;
    private int hours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGtotal() {
        return gtotal;
    }

    public void setGtotal(double gtotal) {
        this.gtotal = gtotal;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    public void AcceptData(){
        Scanner hey = new Scanner(System.in);
        System.out.println("Enter the name");
        boolean invalidInput = false;

        name = hey.nextLine();

        while(!invalidInput){
            System.out.println("Enter the hours");
            String input = hey.next();
            try{
                hours = Integer.parseInt(input);
                invalidInput= true;
            }catch (NumberFormatException e){
                System.out.println("You did not enter a valid number");
            }
        }
    }
    public double COmputeWage(){
        if(this.hours > 40){
            this.gtotal = (40*15) + (16.5 * (this.hours - 40));
        }else {
            this.gtotal = hours *15;
        }
        return this.gtotal;
    }
    public void Display(){
        System.out.println("The total wage of "+ this.name + " is " + gtotal);
    }
}
