package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input x: ");
        double x = scanner.nextDouble();
        System.out.print("Input y: ");
        double y = scanner.nextDouble();
        System.out.println(getColor(x,y));
    }

    public static SimpleColor getColor(double x, double y) {
        HorizontalParabola L1 = new HorizontalParabola(-4, -3, 3);
        Rectangle P1 = new Rectangle(-2, 1, 3, 6);
        Rectangle P2 = new Rectangle(1, 2, -2, 3);
        Rectangle P3 = new Rectangle(-2, 1, -4, -2);
        Rectangle P4 = new Rectangle(-6, -2, -2, 3);
        if ((!P1.isPointOfRectangle(x, y)) && (!P2.isPointOfRectangle(x, y))
                && (!P3.isPointOfRectangle(x, y)) && (!P4.isPointOfRectangle(x, y))) {
            return SimpleColor.Orange;
        }
        if ((P3.isPointOfRectangle(x, y))) {
            return SimpleColor.Green;
        }
        if ((P2.isPointOfRectangle(x, y)) || (P4.isPointOfRectangle(x, y)) || (L1.isPointRightOfParabola(x,y))){
            return SimpleColor.Gray;
        }
        if ((P1.isPointOfRectangle(x, y)) || (!L1.isPointRightOfParabola(x,y))) {
            return SimpleColor.Blue;
        }
        return null;
    }

    enum SimpleColor {
        Orange,
        Blue,
        Gray,
        Green;
    }

    static class HorizontalParabola {
        public double x0;
        public double y0;
        public double a;

        public HorizontalParabola(double x0, double y0, double a) {
            this.x0 = x0;
            this.y0 = y0;
            this.a = a;
        }

        public boolean isPointRightOfParabola(double x, double y) {
            return x > a * Math.pow(y - y0, 2) + x0;
        }

    }

    static class Rectangle {
        public double x0;
        public double x1;
        public double y0;
        public double y1;

        public Rectangle(double x0, double x1, double y0, double y1) {
            this.x0 = x0;
            this.x1 = x1;
            this.y0 = y0;
            this.y1 = y1;
        }

        public boolean isPointOfRectangle(double x, double y) {
            return ((x >= x0) && (x <= x1) && (y >= y0) && (y <= y1));
        }
    }
}





