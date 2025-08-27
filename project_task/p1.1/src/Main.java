import java.awt.print.Book;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.lang.Thread;

//------------Task 1-------------
/*
Such as simulate traffic flow at an intersection. I can model how traffic lights, pedestrian crossings, or rush-hour congestion affect traffic flow without blocking real streets.
It’s safer (no risk of accidents) and cheaper (no need to build or test physical infrastructure before optimizing).
 */
//------------Task 2-------------
/*
Supermarket
1. Variability: Customer arrivals, Checkout times, Stock levels...
2. Complexity: Multiple departments, Queue management, Inventory management...
3. Interconnectedness: Stock & customers, Suppliers & store operations, Checkout speed & customer satisfaction...
 */
//------------Task 3 and 4-------------
class Customer{
    static int count =0 ;
    long startTime,endTime;
    int id;
    static LinkedList<Customer> cusQueue = new LinkedList<Customer>();

    public Customer(){
        count++;
        id = count;
    }
    public void setStartTime(long startTime){
        this.startTime = startTime;
    }
    public void setEndTime(long endTime){
        this.endTime = endTime;
    }
    public long calculateTime(){
        return endTime-startTime;
    }
    static void queue(Customer customer){
        cusQueue.addFirst(customer);
        customer.setStartTime(System.nanoTime());
    }
    static void dequeue(){
        cusQueue.getLast().setEndTime(System.nanoTime());
        System.out.println("time spent: "+cusQueue.getLast().calculateTime());
        cusQueue.removeLast();
    }
    public static void main(String[] args){
        Customer customer = new Customer();
        customer.setStartTime(System.nanoTime());
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        customer.setEndTime(System.nanoTime());
        System.out.println(customer.calculateTime());
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("queue[1]/dequeue[2]");
            String answer = sc.nextLine();
            if(answer.equals("1")){
                queue(new Customer());
                System.out.println("Added new customer to the queue");
            }
            else {
                dequeue();
                System.out.println("Dequeued customer from the queue");
            }
        }
    }
}
//------------Task 5 and 6-------------
class ServicePoint{

    static long sumServeTime;
    static int count = 0;

    static void calcAveServeTime(long time){
        sumServeTime += time;
        count++;
    }
    static long getAveServeTime(){
        return sumServeTime/count;
    }
    static void addToQueueue(Customer customer){
        Customer.queue(customer);
    }
    static void removeFromQueueue(){
        Customer.dequeue();
    }
    static void serve() throws InterruptedException {
        while(!Customer.cusQueue.isEmpty()){
            long random_time = (long)(Math.random() * 1000);
            Thread.sleep(random_time);
            removeFromQueueue();
            System.out.println("Service time: "+random_time);
            calcAveServeTime(random_time);
        }
    }
}
class CustomerGenerator{
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            ServicePoint.addToQueueue(new Customer());
        }
        ServicePoint.serve();
        System.out.println("Average Service time: "+ServicePoint.getAveServeTime());
    }
}