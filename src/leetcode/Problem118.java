package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Problem118 {
    public static void main(String[] args) {
        new Problem118().generate(3);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int lt, rt;
        for (int n = 1; n <= numRows; n++) {
            List<Integer> row = new ArrayList<>();
            if (n == 1) {
                row.add(1);
                result.add(row);
            } else if (n == 2) {
                row.add(1);
                row.add(1);
                result.add(row);
            } else {
                row.add(1);

                List<Integer> upperRow = result.get(n - 2);
                ListIterator<Integer> listIterator = upperRow.listIterator();
                rt = listIterator.next();
                while (listIterator.hasNext()) {
                    lt = rt;
                    rt = listIterator.next();
                    row.add(lt + rt);
                }

                row.add(1);
                result.add(row);
            }
        }
        return result;
    }
}
