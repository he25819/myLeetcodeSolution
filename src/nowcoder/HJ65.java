package nowcoder;

import java.util.Scanner;

public class HJ65 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str0 = in.nextLine();
            String str1 = in.nextLine();
            if (str0.length() > str1.length()) {
                String s = str0;
                str0 = str1;
                str1 = s;
            }

            // 以i-1,j-1结尾的最长子串
            int[][] len = new int[str0.length() + 1][str1.length() + 1];
            int maxLen = 0;
            int idxI = 0;
            for (int i = 1; i <= str0.length(); i++) {
                for (int j = 1; j <= str1.length(); j++) {
                    if (str0.charAt(i - 1) == str1.charAt(j - 1)) {
                        len[i][j] = Math.max(len[i - 1][j - 1] + 1, 1);
                        if (len[i][j] > maxLen) {
                            maxLen = len[i][j];
                            idxI = i;
                        }
                    }
                }
            }
            System.out.println(str0.substring(idxI - maxLen, idxI));
        }
    }
}
