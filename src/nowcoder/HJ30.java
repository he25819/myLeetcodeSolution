package nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<Character> even = new ArrayList<>();
        List<Character> odd = new ArrayList<>();
//        char[] even = new char[s.length() / 2];
//        char[] odd = new char[s.length() - even.length - 1];

        boolean isEven = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;
            if (isEven)
                even.add(s.charAt(i));
            else
                odd.add(s.charAt(i));
            isEven = !isEven;
        }
        Collections.sort(even);
        Collections.sort(odd);

        convert(even);
        convert(odd);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < even.size(); i++) {
            sb.append(even.get(i));
            if (i < odd.size())
                sb.append(odd.get(i));
        }
        System.out.println(sb.toString());
    }

    private static void convert(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            int n;
            if (c >= '0' && c <= '9')
                n = c - '0';
            else if (c >= 'a' && c <= 'f')
                n = c - 'a' + 10;
            else if (c >= 'A' && c <= 'F')
                n = c - 'A' + 10;
            else
                continue;

            int r = 0;
            for (int k = 0; k < 4; k++) {
                int remain = n % 2;
                n >>= 1;
                r = (r << 1) + remain;
            }
            if (r > 9) {
                list.set(i, (char) (r - 10 + 'A'));
            } else {
                list.set(i, (char) (r + '0'));
            }
        }
    }
}
