package nowcoder.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (!set.contains(str.charAt(i))) {
                    count++;
                    set.add(str.charAt(i));
                }
            }
            System.out.println(count);
        }
    }
}
