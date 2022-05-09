package emailapp;

import java.util.Scanner;

public class Email {
    private final int defaultPasswordLength = 8;
    private final String department;
    private final String email;
    private String firstName;
    private String lastName;
    private String password;
    private int mailBoxCapacity = 500;
    private String alternateEmail;
    private String companySuffix;

    public Email() {
        AccountCreation();
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);
        System.out.println("Your default password is: " + this.password + "\nWould you like to change your password now?\n1:Yes\n2:No");
        Scanner newChoice = new Scanner(System.in);
        int passChoice = newChoice.nextInt();
        if (passChoice == 1) {
            setPass();
        } else {
            System.out.println("Okay, keeping default password");
        }

    }

    // Ask for the department
    private void AccountCreation() {
        System.out.println("Please enter the name of your company");
        Scanner company = new Scanner(System.in);
        this.companySuffix = company.next();
        System.out.println("Please enter your first name: ");
        Scanner first = new Scanner((System.in));
        String firstName = first.next();
        System.out.println("Please enter your last name: ");
        Scanner last = new Scanner((System.in));
        String lastName = last.next();
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email being created for: " + this.firstName + " " + this.lastName + " at company " + this.companySuffix + "\nIs this correct?\n1:Yes\n2:No");
        Scanner decision = new Scanner(System.in);
        int decisions = decision.nextInt();
        if (decisions != 1) {
            AccountCreation();
        }
    }

    private String setPass() {
        System.out.println("Please type in your new password");
        Scanner newPass = new Scanner(System.in);
        String newPassword = newPass.next();
        System.out.println("Your new password is " + newPassword + "\nIs this Correct?\n1:Yes\n2:No");
        Scanner confirmationDecision = new Scanner(System.in);
        int confirmation = confirmationDecision.nextInt();
        if (confirmation == 1) {
            this.password = newPassword;
            return "Confirmed: New password is\n" + this.password;
        } else {
            System.out.println("Lets try this again\nmonkey");
            setPass();
        }
        return this.password;
    }

    private String setDepartment() {
        System.out.println("Enter your department\n1:Sales\n2:Engineering\n3:Accounting\n4:Human Resources\n0:None of the above");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) {
            return "Sales";
        } else if (departmentChoice == 2) {
            return "Engineering";
        } else if (departmentChoice == 3) {
            return "Accounting";
        } else if (departmentChoice == 4) {
            return "Human Resources";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGIJKLMNOPQRSTUVWXYZ1234567890!@#$$%^^";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return this.mailBoxCapacity;
    }

    // Generate a random password
    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public String showInfo() {
        return "Email successfully created\nName: " + this.firstName + " " + this.lastName + "\nCompany email: " + this.email + "\nPassword: " + this.password + "\nMailbox storage capacity: " + this.mailBoxCapacity + "mb";
    }
}

