import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        // write your code with StringBuilder here
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < strings.length; i++){
            strings[i] = strings[i].replaceAll("\\d", "");
            resultString.append(strings[i]);
        }
        return resultString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}