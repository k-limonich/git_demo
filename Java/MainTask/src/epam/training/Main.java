package epam.training;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        int choice = in.nextInt();
        switch(choice) {
            case 1:

        }
    }
    public static void menu() {
        System.out.println("Main task program");
        System.out.println("Choose an option:");
        System.out.println("1 - Greet user");
        System.out.println("2 - Display CLI args in reverse order");
        System.out.println("3 - Display fixed number of random integers");
        System.out.println("4 - Add/multiply two integers, entered as CLI args");
        System.out.println("5 - Display month by corresponding number");
        System.out.println("?");
    }
    public static void greetUser(String name) {
        System.out.println("Hello, " + name);
    }
    public static void displayArgsInReverse(String[] args) {

    }
}
