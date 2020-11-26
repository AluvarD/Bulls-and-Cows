import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String[] str2 = str1.split("-");
        System.out.println(str2[1] + "/" + str2[2] + "/" +str2[0]);
    }
}