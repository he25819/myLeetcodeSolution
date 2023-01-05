package nowcoder.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine().trim();
            if (str.length() == 0)
                continue;

            boolean beforeNum = false;
            int maxLen = 0;
            int leftIndex = 0;
            List<int[]> rst = new ArrayList<>();
            for (int i = 0; i <= str.length(); i++) {
                if (i != str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    if (!beforeNum) {
                        beforeNum = true;
                        leftIndex = i;
                    }
                } else {
                    if (beforeNum) {
                        beforeNum = false;
                        if (maxLen < i - leftIndex) {
                            maxLen = i - leftIndex;
                            rst.clear();
                            rst.add(new int[]{leftIndex, i});
                        } else if (maxLen == i - leftIndex) {
                            rst.add(new int[]{leftIndex, i});
                        } else {

                        }
                    }
                }
            }
            for (int[] idxs : rst) {
                System.out.print(str.substring(idxs[0], idxs[1]));
            }
            System.out.printf(",%d\n", maxLen);
        }
    }
}
