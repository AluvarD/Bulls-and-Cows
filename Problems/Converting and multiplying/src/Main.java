import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String number;
        int result;
        while (true) {
            number = scanner.nextLine();
            if ("0".equals(number)) {
                break;
            } else {
                try {
                    result = Integer.parseInt(number) * 10;
                    System.out.println(result);
                } catch (Exception e) {
                    System.out.println("Invalid user input: " + number);
                }
            }

        }
    }
}