import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;

//------------Task 1-------------
class PrintOddNumber extends Thread{
    int num;
    public PrintOddNumber(int num){
        this.num = num;
    }
    @Override
    public void run(){
        for(int i=1;i<=num;i++){
            if(i%2!=0){
                System.out.println("Odd Thread:"+i);
            }
        }
    }
}

class PrintEvenNumber extends Thread{
    int num;
    public PrintEvenNumber(int num){
        this.num = num;
    }
    @Override
    public void run(){
        for(int i=1;i<=num;i++){
            if(i%2==0){
                System.out.println("Even Thread:"+i);
            }
        }
    }
}

class PrintNumberTest{
    public static void main(String[] args) throws InterruptedException {
        Thread odd = new PrintOddNumber(20);
        Thread even = new PrintEvenNumber(20);
        odd.start();
        even.start();
        even.join();
        System.out.println("Printing complete.");
    }
}

//------------Task 2-------------
class Test{
    public static void main(String[] args) {
        Random r= new Random();
        int arrayLength = 100000;
        long totalSum = 0;
        int threads = Runtime.getRuntime().availableProcessors();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i=0;i<arrayLength;i++){
            nums.add(r.nextInt(100));
        }

        int dividedSize = arrayLength/threads;
        LinkedList<CalcuSum> tasks = new LinkedList<>();
        for(int j=0;j<arrayLength;j+=dividedSize){
            tasks.add(new CalcuSum(j,j+dividedSize,nums));
            tasks.getLast().start();
        }

        for(CalcuSum task:tasks){
            try {
                task.join();
                totalSum+=task.getSum();
            } catch (InterruptedException e) {}
        }

        System.out.println(totalSum);

    }
}
class CalcuSum extends Thread{
    int start,end;
    ArrayList<Integer> nums;
    long sum =0;

    public CalcuSum(int start, int end, ArrayList<Integer> nums){
        this.nums = nums;
        this.start = start;
        this.end = end;
    }
    public void run(){
        for(int i=start;i<end;i++){
            sum+=nums.get(i);
        }
    }

    public long getSum(){
        return sum;
    }
}