package nowcoder.huawei;

import java.util.*;

public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            boolean desc = in.nextInt() == 0;
            in.nextLine();

            List<AbstractMap.SimpleEntry<String, Integer>> list = new ArrayList<>();
            while (n-- > 0) {
                String str = in.nextLine();
                String[] split = str.split(" ");

                list.add(new AbstractMap.SimpleEntry<>(split[0], Integer.parseInt(split[1])));
            }
            Collections.sort(list, (entry0, entry1) -> desc ? entry1.getValue() - entry0.getValue() : entry0.getValue() - entry1.getValue());

            for (AbstractMap.SimpleEntry<String, Integer> entry : list) {
                System.out.printf("%s %d\n", entry.getKey(), entry.getValue());
            }
        }
    }
}
