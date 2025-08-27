//task_1//
class TelevisionViewer {
    public static void main(String[] args) {
        Television myTV = new Television();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                if (myTV.getChannel() % 4 == 0)
                    tired = true;
            }

            myTV.pressOnOff();

            System.out.println("Falling asleep");
        }
    }
}

class Television {
    private int channel;
    private boolean on=false;
    public void setChannel(int channel) {
        this.channel = channel;
    }
    public boolean isOn() {
        if(this.on){
            this.on = false;
        }
        else{
            this.on = true;
        }
        return on;
    }
    public void pressOnOff() {
        this.isOn();
    }
    public int getChannel() {
        if(this.channel > 10){
            this.channel = 1;
        }
        return this.channel;
    }
}
//task_2//
class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double gasolineCapacity=0;

    public Car(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
    }

    public Car(String typeName, double speed,double gasolineCapacity) {
        this.typeName = typeName;
        this.speed = speed;
        this.gasolineCapacity = gasolineCapacity;

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
        if (gasolineCapacity > 0){
            gasolineLevel = gasolineCapacity;
        }
        else{
        gasolineLevel = 100;}
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }
}
class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla");
        myCar.fillTank();
        Car myCar2 = new  Car("Honda", 0, 500);

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}
//task_3//
class CoffeeMaker{
    private boolean on = false;
    private String type;
    private int time;

    public void power() {
        if (on) {
            on = false;
            System.out.println("CoffeeMaker is off");
        }
        else{
            on = true;
            System.out.println("CoffeeMaker is on");
        }
    }
    public void setType(String type) {
        if(on) {
            if (type == "espresso" || type == "normal") {
                this.type = type;
                System.out.println("CoffeeMaker type is " + type);
            } else {
                System.out.println("Wrong type");
            }
        }
        else{
            System.out.println("CoffeeMaker type is now OFF");
        }
    }
    public void setTime(int time) {
        if(on){
            if(time >=10 && time <=80){
                this.time = time;
                System.out.println("CoffeeMaker time is " + time + "s");
            }
            else{
                System.out.println("Wrong time");
            }
        }
    }
}
class CoffeeMakerDriver{
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.power();
        coffeeMaker.setType("espresso");
        coffeeMaker.setTime(50);
        coffeeMaker.power();
    }
}
//task_4//
class Car2 {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double targetSpeed;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car2(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
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

    private int max_cruise_speed = 150;
    private int min_cruise_speed = 30;

    void setCruiseSpeed(double speed) {
        this.targetSpeed = speed;
    }

    boolean turnCruiseControlOn(){
        if(this.targetSpeed < max_cruise_speed && this.targetSpeed > min_cruise_speed){
            if(speed < targetSpeed){
                while(speed<targetSpeed){
                    accelerate();
                }
                if(speed == targetSpeed){
                    return  true;
                }
                else{
                    return  false;
                }
            }
            else{
                while (speed>targetSpeed){
                    decelerate(10);
                }
                if(speed == targetSpeed){
                    return  true;
                }
                else{
                    return  false;
                }
            }
        }
        else{
            return  false;
        }
    }
}
class CarDriver2 {
    public static void main(String[] args) {
        Car2 myCar;

        myCar = new Car2("Toyota Corolla");
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }


        myCar.setCruiseSpeed(100);
        if(myCar.turnCruiseControlOn()){
            System.out.println("Cruise successfully turned on");
        }
        else{
            System.out.println("Cruise failed turned on");
        }
        System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
    }
}