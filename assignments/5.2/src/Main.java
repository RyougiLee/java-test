import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
//------------Task 1-------------

class Theater{
    static int tickets = 10;
    static synchronized boolean reserve(int num){
        if(num <= tickets){
            tickets-=num;
            return true;
        }
        return false;
    }
}

class Customer implements Runnable{
    int id;
    public Customer(int id){
        this.id = id;
    }
    public void run(){
        Random rand = new Random();
        int num = rand.nextInt(4)+1;
        if(Theater.reserve(num)){
            System.out.println("Customer " + this.id + " reserved " + num +" tickets.");
        }
        else{
            System.out.println("Customer " + this.id + " could not reserved " + num +" tickets.");
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 15; i++){
            new Thread(new Customer(i+1)).start();
        }
    }
}

//------------Task 2-------------
class MyArrayList{
    private ArrayList<Integer> list = new ArrayList<>();

    public void add(int num){
        synchronized (this){
            this.list.add(num);
        }
    }

    public void remove(int index){
        synchronized (this){
            this.list.remove(index);
        }
    }

    public int getLength(){
        synchronized (this){
            return this.list.size();
        }
    }
}
class test extends Thread{
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Thread> tasks = new LinkedList<>();
        MyArrayList myArrayList = new MyArrayList();
        for(int i=0;i<10;i++){
            int finalI = i;
            Thread t = new Thread(()->{myArrayList.add(finalI);});
            t.start();
            tasks.add(t);
        }
        for(Thread task:tasks){
            task.join();
        }
        System.out.println(myArrayList.getLength());
        for(int i=0;i<5;i++){
            int finalI = i;
            Thread t = new Thread(()->{myArrayList.remove(finalI);});
            t.start();
            tasks.add(t);
        }
        for(Thread task:tasks){
            task.join();
        }
        System.out.println(myArrayList.getLength());
    }
}