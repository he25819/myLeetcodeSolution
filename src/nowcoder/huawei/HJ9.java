package nowcoder.huawei;

import java.util.Scanner;

public class HJ9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            String str = in.nextLine();
            String rst = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                if (!rst.contains(String.valueOf(str.charAt(i)))) {
                    rst += str.charAt(i);
                }
            }
            System.out.println(rst);
        }
    }
}
