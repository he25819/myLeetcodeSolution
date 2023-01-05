package nowcoder.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int lines = in.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < lines; i++) {
                int key = in.nextInt();
                Integer old = map.getOrDefault(key, 0);
                map.put(key, old + in.nextInt());
            }
            map.forEach((key, value) -> System.out.printf("%d %d\n", key, value));
        }
    }
}
