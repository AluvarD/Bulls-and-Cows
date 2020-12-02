import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] seedMaxArr = new int[b - a + 1];
        for (int i = a; i <= b; i++) {
            Random generator = new Random(i);
            int[] generated = new int[n];
            for (int j = 0; j < n; j++) {
                generated[j] = generator.nextInt(k);
            }
            int currMax = Integer.MIN_VALUE;
            for (int value : generated) {
                if (value > currMax) {
                    currMax = value;
                }
            }
            seedMaxArr[i - a] = currMax;
        }
        int seed = -1;
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < seedMaxArr.length; i++) {
            if (seedMaxArr[i] < val) {
                seed = i + a;
                val = seedMaxArr[i];
            }
        }
        System.out.println(seed + "\n" + val);
    }
}