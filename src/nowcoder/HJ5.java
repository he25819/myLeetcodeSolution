package nowcoder;

import java.util.Scanner;

public class HJ5 {
    // 提交结果：答案正确 运行时间：73ms 占用内存：10768KB 使用语言：Java
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine().toUpperCase();
            int rst = 0;
            for (int i = 2; i < str.length(); i++) {
                rst <<= 4;
                char c = str.charAt(i);
                int a;
                if (c >= '0' && c <= '9')
                    a = c - '0';
                else
                    a = c - 'A' + 10;
                rst |= a;
            }
            System.out.println(rst);
        }
    }
}
