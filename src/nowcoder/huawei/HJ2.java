package nowcoder.huawei;

import java.util.Scanner;

public class HJ2 {
    // 通过全部用例
    //运行时间
    //33ms
    //占用内存
    //10840KB
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine().toLowerCase();
            char ch = in.nextLine().toLowerCase().charAt(0);

            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ch)
                    sum++;
            }
            System.out.println(sum);
        }
    }
}
