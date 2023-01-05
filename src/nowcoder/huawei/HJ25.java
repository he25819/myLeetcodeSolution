package nowcoder.huawei;

import java.util.*;

public class HJ25 {
    // 提交结果：答案正确 运行时间：193ms 占用内存：17796KB 使用语言：Java 用例通过率：100.00%
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int iCount = in.nextInt();
            String[] I = new String[iCount];
            for (int i = 0; i < iCount; i++)
                I[i] = String.valueOf(in.nextInt());
            int rCount = in.nextInt();
            Set<Integer> R = new HashSet<>();
            for (int i = 0; i < rCount; i++)
                R.add(in.nextInt());

            Map<Integer, List<Integer>> rst = new TreeMap<>();
            for (int r : R) {
                for (int i = 0; i < I.length; i++) {
                    if (I[i].contains(String.valueOf(r))) {
                        rst.putIfAbsent(r, new ArrayList<>());
                        List<Integer> list = rst.get(r);
                        list.add(i);
                    }
                }
            }
            System.out.print(rst.keySet().size() * 2 + rst.values().stream().mapToInt(List::size).sum() * 2);
            for (Map.Entry<Integer, List<Integer>> entry : rst.entrySet()) {
                System.out.printf(" %d", entry.getKey());
                System.out.printf(" %d", entry.getValue().size());
                for (int idx : entry.getValue()) {
                    System.out.printf(" %d", idx);
                    System.out.printf(" %s", I[idx]);
                }
            }
        }
    }
}
