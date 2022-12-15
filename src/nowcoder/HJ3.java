package nowcoder;

import java.util.Scanner;

public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = in.nextInt();
            boolean[] bucket = new boolean[501];
            for (int i = 0; i < count; i++) {
                bucket[in.nextInt()] = true;
            }
            for (int i = 1; i < bucket.length; i++) {
                if (bucket[i])
                    System.out.println(i);
            }
        }
    }
}
