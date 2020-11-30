package bullscows;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        int secretNumber = 1234;
        int count;
        while (true) {
            count = scanner.nextInt();
            if (count > 10) {
                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            } else {
                break;
            }
        }
        long generatedSecretNumber = generateSecretNumber(count);
        System.out.println("The random secret number is " + generatedSecretNumber);
        int turn = 1;
        /*do {
            System.out.println("Turn " + turn + ". Answer:");
            answer = scanner.nextInt();
            turn++;
        } while (checkAnswerForInt(secretNumber, answer));*/
    }

    public static long generateSecretNumber(int count){

        StringBuilder secretNumber = new StringBuilder();
        long number;
        while (secretNumber.length() < count) {
            StringBuilder randomGenerated = new StringBuilder(String.valueOf(System.nanoTime()));
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

    public static boolean checkAnswerForInt(int secretNumber, int answer) {
        if (secretNumber == answer) {
            System.out.println("Grade: 4 bulls.");
            System.out.println("Congrats! The secret code is " + secretNumber + ".");
            return false;
        } else {
            String a = Integer.toString(secretNumber);
            char[] checkSecretNumber = a.toCharArray();
            String b = Integer.toString(answer);
            char[] checkAnswerNumber = b.toCharArray();
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
            if (bull == 0 && cow ==0){
                System.out.println("Grade: None. The secret code is " + secretNumber + "\n");
            } else {
                System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s). The secret code is " + secretNumber +"\n");
            }
            return true;
        }
    }
}
