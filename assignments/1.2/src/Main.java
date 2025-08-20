import java.util.Scanner;
import java.lang.Math;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Assignment_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Fahrenheit: ");
        double Fahrenheit = scanner.nextDouble();
        double Celcius = (Fahrenheit - 32) * 5 / 9;
        System.out.printf("Celcius: %.2f" , Celcius);
    }

}
class Assignment_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of first leg: ");
        double leg1 = scanner.nextDouble();
        System.out.print("Enter the length of second leg: ");
        double leg2 = scanner.nextDouble();
        double hypotenuse = Math.sqrt(leg1*leg1 + leg2*leg2);
        System.out.println("hypotenuse: " + hypotenuse);
    }
}

class Assignment_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double gram = scanner.nextDouble();
        double luoti = gram / 13.28;
        double luoti_f = luoti % 32;

        double naula = luoti / 32;
        double naula_f = naula % 20;

        double leiviska = naula / 20;

        System.out.print(gram +"grams is "+ (int)leiviska +" leiviska, "+ (int)naula_f+" naula, and ");
        System.out.printf("%.2f",luoti_f);
        System.out.print(" luoti");

    }
}