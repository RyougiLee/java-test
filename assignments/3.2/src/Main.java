
//------------Task 1 to 4-------------

interface Vehicle{
    void start();
    void stop();
    void getInfo();
    double calculateFuelEfficiency();
}
interface ElectricVehicle{
    void charge();
}
class Car extends AbstractVehicle{
    public Car() {
        super(2);
    }
    @Override
    public void start() {
        System.out.println("Car start");
    }
    @Override
    public void stop() {
        System.out.println("Car stop");
    }
    @Override
    public void getInfo() {
        System.out.println("This is a car");
    }
    @Override
    public void charge() {
        System.out.println("No need to charge");
    }
}
class Motorcycle extends AbstractVehicle{
    public Motorcycle() {
        super(3);
    }
    @Override
    public void start() {
        System.out.println("Motorcycle start");
    }
    @Override
    public void stop() {
        System.out.println("Motorcycle stop");
    }
    @Override
    public void getInfo() {
        System.out.println("This is a Motorcycle");
    }
    @Override
    public void charge() {
        System.out.println("No need to charge");
    }
}
class Bus extends AbstractVehicle{

    public Bus() {
        super(4);
    }
    @Override
    public void start() {
        System.out.println("Bus start");
    }
    @Override
    public void stop() {
        System.out.println("Bus stop");
    }
    @Override
    public void getInfo() {
        System.out.println("This is a bus");
    }
    @Override
    public void charge() {
        System.out.println("No need to charge");
    }
}
class ElectricCar extends AbstractVehicle{
    public ElectricCar() {
        super(5);
    }
    @Override
    public void start() {
        System.out.println("ElectricCar start");
    }
    @Override
    public void stop() {
        System.out.println("ElectricCar stop");
    }
    @Override
    public void getInfo() {
        System.out.println("This is a ElectricCar");
    }
    @Override
    public void charge() {
        System.out.println("Charging ElectricCar");
    }
}
class ElectricMotorcycle extends AbstractVehicle{
    public ElectricMotorcycle() {
        super(5.5);
    }
    @Override
    public void start() {
        System.out.println("ElectricMotorcycle start");
    }
    @Override
    public void stop() {
        System.out.println("ElectricMotorcycle stop");
    }
    @Override
    public void getInfo() {
        System.out.println("This is a ElectricMotorcycle");
    }
    @Override
    public void charge() {
        System.out.println("Charging ElectricMotorcycle");
    }
}

abstract class AbstractVehicle implements Vehicle,ElectricVehicle{
    public abstract void start();
    public abstract void stop();
    public abstract void getInfo();
    public abstract void charge();
    double fuelEfficiency;

    public AbstractVehicle(double fuelEfficiency){
        this.fuelEfficiency = fuelEfficiency;
    }

    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}
class VehicleDemo{
    public static void main(String[] args) {
        Car car = new Car();
        Motorcycle motorcycle = new Motorcycle();
        Bus bus = new Bus();
        ElectricCar electricCar = new ElectricCar();
        bus.start();
        bus.stop();
        bus.getInfo();
        car.start();
        car.stop();
        car.getInfo();
        motorcycle.start();
        motorcycle.stop();
        motorcycle.getInfo();
        motorcycle.charge();
        electricCar.charge();
        System.out.println(electricCar.calculateFuelEfficiency());
    }
}