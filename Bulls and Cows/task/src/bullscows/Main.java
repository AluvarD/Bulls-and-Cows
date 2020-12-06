package bullscows;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        int count;
        System.out.println("Please, enter the secret code's length:");
        int lengt;
        while (true) {
            count = scanner.nextInt();
            if (count > 36) {
                System.out.println("Error: can't generate a secret number with a length of 36 because there aren't enough unique digits.");
            } else {
                break;
            }
        }
        System.out.println("Input the number of possible symbols in the code:");
        lengt = scanner.nextInt();
        String generatedSecretNumber = generateSecretNumber(count, lengt);

        System.out.print("The secret is prepared: ");
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }

        if (lengt <= 10) {
            System.out.println(" (0-" + Character.forDigit(lengt - 1,16) + ").");
        } else {
            System.out.println(" (0-9, a-" + Character.forDigit(lengt -1 , 36) + ").");
        }

        int turn = 1;
        do {
            System.out.println("Turn " + turn + ":");
            answer = scanner.next();
            turn++;
        } while (checkAnswer(generatedSecretNumber, answer, count));
    }

    public static String generateSecretNumber(int count, int lengt){

        StringBuilder secretNumber = new StringBuilder();
        StringBuilder symbolsForSecret = new StringBuilder("0123456789");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String number;
        if (lengt > 10) {
            for (int i = 0; i < lengt - 10; i++) {
                symbolsForSecret.append(alphabet.charAt(i));
            }
        }
        while (secretNumber.length() < count) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomGenerated = random.nextInt(lengt);
                if (secretNumber.length() == 0 && randomGenerated != 0) {
                    secretNumber.append(symbolsForSecret.charAt(randomGenerated));
                } else {
                    boolean isInclude = false;
                    for (int j = 0; j < secretNumber.length(); j++) {
                        if (secretNumber.charAt(j) == symbolsForSecret.charAt(randomGenerated)) {
                            isInclude = true;
                            break;
                        }
                    }
                    if (!isInclude) {
                        secretNumber.append(symbolsForSecret.charAt(randomGenerated));
                    }
                }
                if (secretNumber.length() == count){
                    break;
                }
            }
        }
        number = secretNumber.toString();
        return number;
    }

    public static boolean checkAnswer(String secretNumber, String answer, int count) {
        char[] checkSecretNumber = secretNumber.toCharArray();
        char[] checkAnswerNumber = answer.toCharArray();
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < checkAnswerNumber.length; i++) {
            for (int j = 0; j < checkSecretNumber.length; j++) {
                if (i == j && checkAnswerNumber[i] == checkSecretNumber[j]) {
                    bull++;
                } else if (checkAnswerNumber[i] == checkSecretNumber[j]) {
                    cow++;
                }
            }
        }
        if (bull == count) {
            System.out.println("Grade: " + secretNumber.length() + " bulls.");
            System.out.println("Congratulations! You guessed the secret code.");
            return false;
        } else if (bull == 0 && cow == 0) {
            System.out.println("Grade: None.");
            return true;
        } else {
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s).");
            return true;
        }
    }
}
