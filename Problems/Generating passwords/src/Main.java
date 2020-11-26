import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int d = n - a - b - c;
        String upperLetterStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetterStr = "abcdefghijklmnopqrstuvwxyz";
        String[] upperLetter = upperLetterStr.split("");
        String[] lowerLetter = lowerLetterStr.split("");
        String[] passwordGenerate = new String[n];
        int presentRandomNumber = 0;
        for (int i = 0; i < a; i++) {
            int randomNumber = (int) (Math.random() * 100);
            while (randomNumber >= 26 || randomNumber == presentRandomNumber) {
                randomNumber = (int) (Math.random() * 100);
            }
            passwordGenerate[i] = upperLetter[randomNumber];
            presentRandomNumber = randomNumber;
        }
        for (int i = a; i < b + a; i++) {
            int randomNumber = (int) (Math.random() * 100);
            while (randomNumber >= 26 || randomNumber == presentRandomNumber) {
                randomNumber = (int) (Math.random() * 100);
            }
            passwordGenerate[i] = lowerLetter[randomNumber];
            presentRandomNumber = randomNumber;
        }
        for (int i = b + a; i < c + b + a; i++) {
            int randomNumber = (int) (Math.random() * 10);
            while (randomNumber == presentRandomNumber) {
                randomNumber = (int) (Math.random() * 10);
            }
            passwordGenerate[i] = Integer.toString(randomNumber);
            presentRandomNumber = randomNumber;
        }
        for (int i = c + b + a; i < c + b + a +d; i++) {
            int randomNumber = (int) (Math.random() * 100);
            while (randomNumber >= 26 || randomNumber == presentRandomNumber) {
                randomNumber = (int) (Math.random() * 100);
            }
            passwordGenerate[i] = upperLetter[randomNumber];
            presentRandomNumber = randomNumber;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < passwordGenerate.length; i++){
            sb.append(passwordGenerate[i]);
        }
        String password = sb.toString();
        System.out.println(password);
    }
}