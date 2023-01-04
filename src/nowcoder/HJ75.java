package nowcoder;

import java.util.Scanner;

public class HJ75 {
    // HJ75 公共子串计算
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str0 = in.nextLine();
            String str1 = in.nextLine();

            int[][] len = new int[str0.length() + 1][str1.length() + 1];
            int maxLen = 0;
            for (int i = 1; i <= str0.length(); i++) {
                for (int j = 1; j <= str1.length(); j++) {
                    if (str0.charAt(i - 1) == str1.charAt(j - 1)) {
                        len[i][j] = Math.max(1, len[i - 1][j - 1] + 1);
                        maxLen = Math.max(maxLen, len[i][j]);
                    }
                }
            }
            System.out.println(maxLen);
        }
    }
}
