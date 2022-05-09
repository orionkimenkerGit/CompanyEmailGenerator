package emailapp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        System.out.println("Create new employee email?\n1:Yes\n2:Quit");
        Scanner start = new Scanner(System.in);
        int choice = start.nextInt();
        if (choice == 1) {
            Email email = new Email();
            System.out.println(email.showInfo());
        }
        else {
            System.out.println("Goodbye");
        }
    }
}
