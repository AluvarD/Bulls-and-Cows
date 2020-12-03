package bullscows;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long answer;
        int count;
        System.out.println("Please, enter the secret code's length:");
        while (true) {
            count = scanner.nextInt();
            if (count > 10) {
                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            } else {
                break;
            }
        }
        long generatedSecretNumber = generateSecretNumber(count);
        int turn = 1;
        do {
            System.out.println("Turn " + turn + ":");
            answer = scanner.nextLong();
            turn++;
        } while (checkAnswerForLong(generatedSecretNumber, answer, count));
    }

    public static long generateSecretNumber(int count){

        StringBuilder secretNumber = new StringBuilder();
        long number;
        while (secretNumber.length() < count) {
            Random random = new Random();
            StringBuilder randomGenerated = new StringBuilder(String.valueOf(random.nextLong()));
            randomGenerated.reverse();
            for (int i = 0; i < randomGenerated.length(); i++) {
                if (secretNumber.length() == 0) {
                    if (randomGenerated.charAt(i) != '0') {
                        secretNumber.append(randomGenerated.charAt(i));
                    }
                } else {
                    boolean isInclude = false;
                    for (int j = 0; j < secretNumber.length(); j++){
                        if (secretNumber.charAt(j) == randomGenerated.charAt(i)) {
                            isInclude = true;
                            break;
                        }
                    }
                    if (!isInclude) {
                        secretNumber.append(randomGenerated.charAt(i));
                    }
                }
                if (secretNumber.length() == count){
                    break;
                }
            }
        }
        String convert = secretNumber.toString();
        number = Long.parseLong(convert);
        return number;
    }

    public static boolean checkAnswerForLong(long secretNumber, long answer, int count) {
        String a = Long.toString(secretNumber);
        char[] checkSecretNumber = a.toCharArray();
        String b = Long.toString(answer);
        if (b.length() < count) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < count; i++) {
                temp.append(0);
            }
            b = temp.toString();
        }
        char[] checkAnswerNumber = b.toCharArray();
        int bull = 0;
        int cow = 0;
        if (secretNumber == answer) {
            System.out.println("Grade: " + a.length() + " bulls.");
            System.out.println("Congratulations! You guessed the secret code.");
            return false;
        } else {
            for (int i = 0; i < checkAnswerNumber.length; i++) {
                for (int j = 0; j < checkSecretNumber.length; j++) {
                    if (i == j && checkAnswerNumber[i] == checkSecretNumber[j]) {
                        bull++;
                    } else if (checkAnswerNumber[i] == checkSecretNumber[j]) {
                        cow++;
                    }
                }
            }
            if (bull == 0 && cow == 0){
                System.out.println("Grade: None.");
            } else {
                System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s).");
            }
            return true;
        }
    }
}
