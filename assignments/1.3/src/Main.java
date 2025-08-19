import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();

        double delta = b*b - 4*a*c;
        if(delta<0){
            System.out.print("No real roots");
        }
        else if(delta==0){
            double root = (-b + Math.sqrt(delta))/2*a;
            System.out.print("root: " + root);
        }
        else{
            double root1 = (-b + Math.sqrt(delta))/2*a;
            double root2 = (-b - Math.sqrt(delta))/2*a;
            System.out.println("root1: " + root1);
            System.out.println("root2: " + root2);
        }
        }
    }

class Binary{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String binary = scanner.nextLine();
        int decimal = 0;
        int j=0;
        for(int i = binary.length()-1; i>=0; i--){
            int number = binary.charAt(i) - '0';
            System.out.println(number);
            decimal += number * Math.pow (2,j);
            j+=1;
        }
        System.out.println(decimal);
    }
}

class Prime_number{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of starting number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the value of ending number: ");
        int num2 = scanner.nextInt();

        for (int i = num1; i<=num2; i++){
            Boolean isPrime = true;
            for (int j = 2; j<i && isPrime; j++){
                if (i % j == 0){
                    isPrime = false;
                }
            }
            if(isPrime){
                System.out.print(i + " ");
            }
        }
    }
}

class Exam{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        while (score <10) {
            score = 0;
            for (int i = 0; i < 10; i++) {
                int randomNum1 = (int) (Math.random() * 10) + 1;
                int randomNum2 = (int) (Math.random() * 10) + 1;
                int result = randomNum1 * randomNum2;
                System.out.print(randomNum1 + " * " + randomNum2 + " = ");
                int answer = scanner.nextInt();
                if (answer == result) {
                    score++;
                    System.out.println("correct, score: " + score);
                } else {
                    System.out.println("incorrect, score: " + score);
                }
            }
            if(score < 10){
                System.out.println("You score is less than 10!");
            }
            else{
                System.out.println("Congratulations, you score is 10!");
            }
        }
    }
}