import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double p = ((double) a + (double) b + (double) c) / 2;
        double s = Math.sqrt(p * (p - (double) a) * (p - (double) b) * (p - (double) c));
        System.out.println(s);
    }
}