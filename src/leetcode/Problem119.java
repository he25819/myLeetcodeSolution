package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem119 {
    public static void main(String[] args) {
        new Problem119().getRow(30);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < rowIndex; i++) {
            long before = result.get(result.size() - 1);
            before = before * (rowIndex - i) / (i + 1);
            result.add((int) before);
        }
        return result;
    }
    //no BigInteger class
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> result = new ArrayList<>();
//        if (rowIndex == 0) {
//            result.add(1);
//            return result;
//        } else if (rowIndex == 1) {
//            result.add(1);
//            result.add(1);
//            return result;
//        }
//        BigInteger[] factorials = new BigInteger[rowIndex + 1];
//        BigInteger a = BigInteger.valueOf(1);
//        for (int i = 1; i <= rowIndex; i++) {
//            a = a.multiply(BigInteger.valueOf(i));
//            factorials[i] = a;
//        }
//
//        result.add(1);
//
//        for (int i = 1; i < rowIndex; i++) {
//            //(rowIndex)Ci=(rowIndex)!/(i!*(rowIndex-i)!)
//            result.add(factorials[rowIndex].divide(factorials[i]).divide(factorials[rowIndex - i]).intValue());
//        }
//        result.add(1);
//        return result;
//    }
}
