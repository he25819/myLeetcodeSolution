package nowcoder.huawei;

import java.util.Scanner;

public class HJ4 {
    // 提交结果：答案正确 运行时间：50ms 占用内存：10952KB 使用语言：Java
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int left = 8 - str.length() & 7;
            if (left > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                for (int i = 0; i < left; i++)
                    sb.append(0);
                str = sb.toString();
            }
            for (int i = 0; i < str.length(); i=i+8) {
                System.out.println(str.substring(i, i + 8));
            }
        }
    }
}
