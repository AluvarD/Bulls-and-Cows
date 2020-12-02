import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Random random = new Random(a + b);
        if (a < b) {
            int range = b - a + 1;
            int sum = 0;
            int randomNumber;
            for (int i = 0; i < n; i++) {
                randomNumber = random.nextInt(range) + a;
                sum = sum + randomNumber;
            }
            System.out.println(sum);
        } else if (a > b) {
            int range = a - b + 1;
            int sum = 0;
            int randomNumber;
            for (int i = 0; i < n; i++) {
                randomNumber = random.nextInt(range) + b;
                sum = sum + randomNumber;
            }
            System.out.println(sum);
        }
    }
}