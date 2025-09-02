class Calculator{
    double sum = 0;
    public void reset(){
        sum = 0;
    }
    public void add(double num){
        if(num > 0){sum += num;}
        else{throw new IllegalArgumentException("Negative numbers are not allowed: " + num);}
    }
    public double getSum(){
        return sum;
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(5);
        calc.add(10);
        System.out.println("Sum: " + calc.getSum()); // Output: Sum: 15.0
        calc.reset();
        System.out.println("Sum after reset: " + calc.getSum()); // Output: Sum after reset: 0.0
        try {
            calc.add(-3); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}