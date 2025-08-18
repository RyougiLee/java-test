import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println("    *\n" +
                "   ***\n" +
                "  *****\n" +
                " *******\n" +
                " ");

    }

}
class SumOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println("The sum of the numbers is " + (first + second + third));
        System.out.println("The product of the numbers is " + (first * second * third));
        double avg = (double)(first + second + third)/3;
        System.out.println("The average of the numbers is " + avg);
        //The data type should be double to contain the decimals
    }
}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        Cat cat = new Cat("Whiskers");
        Cat cat2 = new Cat("Rex");

        // Call the meow method on the cat instance
        cat.meow();
        cat.meow();
        cat2.meow();
        cat.meow();
    }
}
