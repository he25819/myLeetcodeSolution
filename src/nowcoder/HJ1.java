package nowcoder;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(lastWordLength(s));
        }
    }

    // 通过全部用例
    //运行时间
    //38ms
    //占用内存
    //10916KB
    private static int lastWordLength(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                return str.length() - i - 1;
            }
        }
        return str.length();
    }
}
