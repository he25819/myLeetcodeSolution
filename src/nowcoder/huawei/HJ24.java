package nowcoder.huawei;

import java.util.Scanner;

public class HJ24 {
    // 124
    //16 103 132 23 211 75 155 82 32 48 79 183 13 91 51 172 109 102 189 121 12 120 116 133 79 120 116 208 47 110 65 187 69 143 140 173 203 35 184 49 245 50 179 63 204 34 218 11 205 100 90 19 145 203 203 215 72 108 58 198 95 116 125 235 156 133 220 236 125 29 235 170 130 165 155 54 127 128 204 62 59 226 233 245 46 3 14 108 37 94 52 97 159 190 143 67 24 204 39 222 245 233 11 80 166 39 224 12 38 13 85 21 47 25 180 219 140 201 11 42 110 209 77 136
    // 预期输出95
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();

            int[] T = new int[n];
            for (int i = 0; i < n; i++) {
                T[i] = in.nextInt();
            }

            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = 1;
            right[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                left[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (T[i] > T[j])
                        left[i] = Math.max(left[i], left[j] + 1);
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                right[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (T[i] > T[j])
                        right[i] = Math.max(right[i], right[j] + 1);
                }
            }

            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                maxLen = Math.max(left[i] + right[i], maxLen);
            }
            System.out.println(n - maxLen + 1);
        }
    }
}
