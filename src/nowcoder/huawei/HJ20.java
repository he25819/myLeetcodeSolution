package nowcoder.huawei;

import java.util.Scanner;

public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        outer: while (in.hasNextLine()) {
            String str = in.nextLine();

            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }

            int a=0,b=0,c=0,d=0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                    a = 1;
                else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                    b = 1;
                else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    c = 1;
                else
                    d = 1;
            }
            if (a + b + c + d < 3) {
                System.out.println("NG");
                continue;
            }

            for (int i = 0; i < str.length() - 2; i++) {
                String s = str.substring(i, i + 3);
                String leftS = str.substring(0, i);
                String rightS = str.substring(i + 3);
                if (leftS.contains(s) || rightS.contains(s)) {
                    System.out.println("NG");
                    continue outer;
                }
            }
            System.out.println("OK");
        }
    }
}
