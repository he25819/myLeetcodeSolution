package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class HJ45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();
            while (n-- > 0) {
                String str = in.nextLine().toLowerCase();
                int[] letterCount = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    letterCount[str.charAt(i) - 'a']++;
                }
                Arrays.sort(letterCount);
                int prettyScore = 0;
                for (int i = letterCount.length - 1; i >= 0; i--) {
                    if (letterCount[i] == 0)
                        break;
                    prettyScore += letterCount[i] * (i+1);
                }
                System.out.println(prettyScore);
            }
        }
    }
}
