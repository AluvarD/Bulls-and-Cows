package bullscows;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        int secretNumber = 1234;
        int turn = 1;
        do {
            System.out.println("Turn " + turn + ". Answer:");
            answer = scanner.nextInt();
            turn++;
        } while (checkAnswer(secretNumber, answer));
    }

    public static boolean checkAnswer(int secretNumber, int answer) {
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
