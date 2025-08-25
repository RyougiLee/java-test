import java.awt.*;
import java.util.ArrayList;

//------------Task 1 and 2-------------
class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;
    public Car(String typeName) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    double getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        gasolineLevel = 100;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }
}

class SportsCar extends Car {
    private double speed;
    public SportsCar(String typeName) {
        super(typeName);
    }

    public void accelerate() {
        if (super.getGasolineLevel() > 0)
            speed += 20;
        else
            speed = 0;
    }

    public void decelerate() {
        if (super.getGasolineLevel() > 0) {
            if (speed > 0)
                speed -=20;
        } else
            speed = 0;
    }

    double getSpeed() {
        return speed;
    }
}

class Bus extends Car {
    private int passengers;
    public Bus(String typeName) {
        super(typeName);
        this.passengers = 0;
    }
    public void passengerEnter(int passenger) {
        this.passengers += passenger;
    }
    public void passengerExit(int passenger) {
        this.passengers -= passenger;
    }
    public int getPassengers() {
        return passengers;
    }
}
class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla");
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        SportsCar mySportsCar = new SportsCar("Honda");
        mySportsCar.fillTank();
        for (int i = 0; i < 6; i++) {
            mySportsCar.accelerate();
            System.out.println(mySportsCar.getTypeName() + ": speed is " + mySportsCar.getSpeed() + " km/h");
        }

        Bus mybus = new Bus("322");
        mybus.passengerEnter(10);
        mybus.passengerExit(5);
        System.out.println(mybus.getTypeName() + ": passengers is " + mybus.getPassengers());
    }
}

//------------Task 3,4-------------

class Shape{
    private String color;
    public Shape(String color) {
        this.color = color;
    }
    public double calculateArea(){
        return 0;
    }
    public String getColor() {
        return color;
    }
}
class Circle extends Shape{
    public double radius;
    public Circle(double radius, String color){
        super(color);
        this.radius = radius;
    }
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
    @Override
    public String toString() {
        return "Area of Circle is " + this.calculateArea() + " with color " + super.getColor();
    }
}
class Rectangle extends Shape{
    public double width;
    public double height;
    public Rectangle(double width, double height, String color){
        super(color);
        this.width = width;
        this.height = height;
    }
    public double calculateArea(){
        return width * height;
    }
    @Override
    public String toString() {
        return "Area of Rectangle is " + this.calculateArea() + " with color " + super.getColor();
    }
}
class Triangle extends Shape{
    public double base;
    public double height;
    public Triangle(double base, double height,String color){
        super(color);
        this.base = base;
        this.height = height;
    }
    public double calculateArea(){
        return (base * height)/2;
    }
    @Override
    public String toString() {
        return "Area of Triangle is " + this.calculateArea() + " with color " + super.getColor();
    }
}
class ShapeCalculator{
    public static void main(String[] args)
    {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(5, "red"));
        shapes.add(new Triangle(4, 6, "blue"));
        shapes.add(new Rectangle(3, 8, "yellow"));
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}