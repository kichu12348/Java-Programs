
class InvalidAgeEcxeption extends Exception {
    InvalidAgeEcxeption(String s) {
        super(s);
    }
}

public class CmdLineArg {
    public static void main(String[] args) {
        int age;
        try {
            age = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            age = 0;
        }
        try {
            if (age < 18) {
                throw new InvalidAgeEcxeption(age + " is an Invalid Age");
            } else {
                System.out.println("Valid Age");
            }
        } catch (InvalidAgeEcxeption e) {
            System.out.println(e.getMessage());
        } // prints the address of the object
    }
}
