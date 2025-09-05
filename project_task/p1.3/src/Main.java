import distributions.Normal;

import java.util.*;

//------------Task 1-------------
/*
First, determining the probability distribution of ages based on the real data and convert these percentages into a cumulative distribution, where each age corresponds to a range between 1 and 100. After that, I would generate random numbers between 0 and 1 and check which interval each random number falls into.The interval would determine the age assigned to that number.
 */
//------------Task 2-------------
class AgeDistribution {
    public static void main(String[] args) {
        final int REITERATIONS = 1000;
        final int MAXAGE = 25;

        int agedistribution[][] = {
                {10, 20},
                {50, 21},
                {80, 22},
                {95, 23},
                {100,MAXAGE},
        };

        int generatedAges[] = new int[MAXAGE+1];

        // Generate ages according to the distribution:
        for (int i = 1; i <= REITERATIONS; i++){
            int x = (int)(Math.random()*100)+1;
            int j = 0;
            while (x > agedistribution[j][0]) j++;
            generatedAges[agedistribution[j][1]]++;
        }

        // Output the result of the generation:
        System.out.println("Age  count     %-share");
        for (int age = 0; age <= MAXAGE; age++) {
            if (generatedAges[age] != 0) {
                String str = "%-4d %-8d %-8.2f\n";
                System.out.printf(str, age, generatedAges[age], ((double)generatedAges[age])/REITERATIONS*100 );
            }
        }
    }
}
//------------Task 3-------------
/*
Because the constructor of the class is declared private. Making the constructor private prevents other classes from instantiating new objects directly.
 */
//------------Task 4-------------
/*
The normal distribution appears in real life with heights or exam scores, the exponential distribution models waiting times like customers arriving, the uniform distribution is used when all outcomes are equally likely, and the Poisson distribution models counts of events in a fixed time, like cars passing a toll booth.
 */
//------------Task 5-------------
class Clock {
    private static Clock instance;
    private double time;

    private Clock() {
        this.time = 0.0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setTime(double newTime) {
        this.time = newTime;
    }

    public double getTime() {
        return this.time;
    }

    public void advance(double amount) {
        this.time += amount;
    }

    public static void main(String[] args) {
        Clock.getInstance().setTime(0.5);
        System.out.println("Time is " + Clock.getInstance().getTime());
    }
}
//------------Task 6-------------
enum EventType{
    arrived,
    exit
}
class Event implements Comparable<Event>{
    private Double eventTime;
    EventType type;

    public Event(Double eventTime, EventType type) {
        this.eventTime = eventTime;
        this.type = type;
    }

    public Double getTime(){
        return this.eventTime;
    }

    public Double getEventTime() {
        return eventTime;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }
    @Override
    public String toString() {
        return "Event{" +
                "time=" + eventTime +
                ", type=" + type +
                '}';
    }

}

class EventList{
    private PriorityQueue<Event> queue;
    public EventList() {
        queue = new PriorityQueue<>();
    }
    public void addEvent(Event e) {
        queue.add(e);
    }

    public Event getNextEvent() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public List<Event> getOrderedEvents() {
        List<Event> ordered = new ArrayList<>(queue);
        Collections.sort(ordered);
        return ordered;
    }
}

class ArrivalProcess{
    private Normal generator;
    private EventType type;

    public ArrivalProcess(Normal generator, EventType type) {
        this.generator = generator;
        this.type = type;
    }
    public void generateNextEvent(EventList eventList) {
        Clock clock = Clock.getInstance();

        double interval = generator.sample();

        clock.advance(interval);

        Event newEvent = new Event(clock.getTime(), type);

        eventList.addEvent(newEvent);
    }
}

class TestArrivalProcess {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        Normal generator = new Normal(100,100);

        ArrivalProcess arrivalProcess = new ArrivalProcess(generator, EventType.arrived);

        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateNextEvent(eventList);
        }

        eventList.getOrderedEvents().forEach(System.out::println);
    }
}

//------------Task 7-------------
class Customer{
    static int count =0 ;
    Double startTime,endTime;
    int id;
    static LinkedList<Customer> cusQueue = new LinkedList<Customer>();

    public Customer(){
        count++;
        id = count;
    }
    public void setStartTime(Double startTime){
        this.startTime = startTime;
    }
    public void setEndTime(Double endTime){
        this.endTime = endTime;
    }
    public Double calculateTime(){
        return endTime-startTime;
    }
    static void queue(Customer customer, Double startTime){
        cusQueue.addFirst(customer);
        customer.setStartTime(startTime);
    }
    static void dequeue(Double endTime){
        cusQueue.getLast().setEndTime(endTime);
        System.out.println("time spent: "+cusQueue.getLast().calculateTime());
        cusQueue.removeLast();
    }
    public static void main(String[] args){

    }
}

class ServicePoint{

    static long sumServeTime;
    static int count = 0;
    static Clock clock = Clock.getInstance();

    static void calcAveServeTime(long time){
        sumServeTime += time;
        count++;
    }
    static long getAveServeTime(){
        return sumServeTime/count;
    }
    static void addToQueueue(Customer customer, Double startTime){
        Customer.queue(customer,startTime);
    }
    static void removeFromQueueue(Double endTime){
        Customer.dequeue(endTime);
    }
    static void serve(Double endTime) throws InterruptedException {
        while(!Customer.cusQueue.isEmpty()){
            long random_time = (long)(Math.random() * 1000);
            removeFromQueueue(endTime + random_time);
            System.out.println("Service time: "+random_time);
            clock.advance(random_time);
            calcAveServeTime(random_time);
        }
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        EventList eventList = new EventList();
        Clock clock = Clock.getInstance();

        Normal generator = new Normal(100,100);

        ArrivalProcess arrivalProcess = new ArrivalProcess(generator, EventType.arrived);

        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateNextEvent(eventList);
        }

        eventList.getOrderedEvents().forEach(System.out::println);
        System.out.println("\nClock after last event: " + clock.getTime());
        for (Event e : eventList.getOrderedEvents()) {
            if (e.type == EventType.arrived) {
                Customer c = new Customer();
                ServicePoint.addToQueueue(c,e.getTime());
            }
        }

        // Move clock forward by 5
        clock.advance(5.0);
        double departureTime = clock.getTime();
        System.out.println("\nClock moved forward to: " + departureTime);

        // Serve all customers
        while (!Customer.cusQueue.isEmpty()) {
            ServicePoint.serve(departureTime);
        }
    }

}