package nowcoder.huawei;

import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (c >= 'a' && c < 'z')
                sb.append((char) (c + 1 + 'A' - 'a'));
            else if (c == 'z')
                sb.append('A');
            else if (c >= 'A' && c < 'Z')
                sb.append((char) (c + 1 + 'a' - 'A'));
            else if (c == 'Z')
                sb.append('a');
            else if (c >= '0' && c < '9')
                sb.append((char) (c + 1));
            else if (c == '9')
                sb.append('0');
        }
        System.out.println(sb.toString());

        sb.delete(0, sb.length());
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (c >= 'b' && c <= 'z')
                sb.append((char) (c - 1 + 'A' - 'a'));
            else if (c == 'a')
                sb.append('Z');
            else if (c > 'A' && c <= 'Z')
                sb.append((char) (c - 1 + 'a' - 'A'));
            else if (c == 'A')
                sb.append('z');
            else if (c > '0' && c <= '9')
                sb.append((char) (c - 1));
            else if (c == '0')
                sb.append('9');
        }
        System.out.println(sb.toString());
    }
}
