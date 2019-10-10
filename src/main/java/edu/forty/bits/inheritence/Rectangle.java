package com.stackoverflow.nullpointer.inheritence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rectangle extends Shape {

    private double x;
    private double y;

    public Rectangle() {
    }

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean draw() {
        boolean pass = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter X:");
            String xvalue = br.readLine();
            x = Double.parseDouble(xvalue);
            System.out.print("Enter Y:");
            String yvalue = br.readLine();
            y = Double.parseDouble(yvalue);
            if (x == y) {
                System.out.println("Square detected");
                Rectangle r = new Square(x);
                // I want to return Square not Rectangle
            }
            System.err.println("Enter succesful");
            pass = true;
        } catch (IOException ex) {
            pass = false;
            ex.printStackTrace();
        } catch (NumberFormatException e) {
            pass = false;
            System.err.println("Enter error. Please enter right format, go to 6. Help for more details");
        }
        return pass;
    }

    @Override
    public String area() {
        double area = x * y;
        return "I'm a rectangle, I have 4 right angles. My sides are " + x + ", " + y + ", " + x + ", " + y +
                " My area is " + area;
    }

    @Override
    public String perimeter() {
        double per = (x + y) * 2;
        return "I'm a rectangle, I have 4 right angles. My sides are " + x + ", " + y + ", " + x + ", " + y +
                " My perimeter is " + per;
    }

    @Override
    public String characteristic() {
        return "I'm a rectangle, I have 4 right angles. My sides are " + x + ", " + y + ", " + x + ", " + y;
    }
}