package nowcoder;

import java.util.Scanner;

public class HJ52 {
    // 同leetcode72
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str0 = in.nextLine();
            String str1 = in.nextLine();

            int[][] len = new int[str0.length() + 1][str1.length() + 1];
            for (int i = 1; i <= str0.length(); i++)
                len[i][0] = i;
            for (int j = 1; j <= str1.length(); j++)
                len[0][j] = j;

            for (int i = 1; i <= str0.length(); i++) {
                for (int j = 1; j <= str1.length(); j++) {
                    len[i][j] = Math.min(len[i - 1][j] + 1, len[i][j - 1] + 1);
                    if (str0.charAt(i - 1) == str1.charAt(j - 1))
                        len[i][j] = Math.min(len[i][j], len[i - 1][j - 1]);
                    else
                        len[i][j] = Math.min(len[i][j], len[i - 1][j - 1] + 1);
                }
            }
            System.out.println(len[str0.length()][str1.length()]);
        }
    }
}
