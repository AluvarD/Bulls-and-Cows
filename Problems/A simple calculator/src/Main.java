import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long firstNumber = scanner.nextLong();
        char operator = scanner.next().charAt(0);
        long secondNumber = scanner.nextLong();
        long result;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                System.out.println(result);
                break;
            case '-':
                result = firstNumber - secondNumber;
                System.out.println(result);
                break;
            case '*':
                result = firstNumber * secondNumber;
                System.out.println(result);
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Division by 0!");
                    break;
                }
                result = firstNumber / secondNumber;
                System.out.println(result);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}