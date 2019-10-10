package edu.forty.bits.inheritence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Square extends Rectangle {

    private double x;

    public Square() {
    }


    public Square(double side) {
        super(side, side);
        this.x = side;
    }

    public Square square(double side) {
        this.x = side;
        return this;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public boolean draw() {
        boolean pass = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter X:");
            String xvalue = br.readLine();
            x = Double.parseDouble(xvalue);
            System.err.println("Enter succesful");
            pass = true;
        } catch (IOException ex) {
            pass = false;
            ex.printStackTrace();
        } catch (NumberFormatException e) {
            pass = false;
            System.err.println("Please enter right format, go to 6. Help for more details");
        }
        return pass;
    }

    @Override
    public String area() {
        double area = x * x;
        return "I'm a square, I have 4 right angles. My sides are " + x + ", " + x + ", " + x + ", " + x +
                ". My area is " + area;
    }

    @Override
    public String perimeter() {
        double per = x * 4;
        return "I'm a square, I have 4 right angles. My sides are " + x + ", " + x + ", " + x + ", " + x +
                ". My perimeter is " + per;
    }

    @Override
    public String characteristic() {
        return "I'm a square, I have 4 right angles. My sides are " + x + ", " + x + ", " + x + ", " + x;
    }
}