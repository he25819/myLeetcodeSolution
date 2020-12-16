package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-12-01 13:32
 **/
public class Problem165 {

    /*
"1.01"
"1.001"
"1.0"
"1.0.0"
"0.1"
"1.1"
"1.0.1"
"1"
"7.5.2.4"
"7.5.3"
"1"
"1.0"
"0.0"
"0"
"1.0000001.1"
"1.1.1"
     */



    // Runtime: 1 ms, faster than 88.65% of Java online submissions for Compare Version Numbers.
    //Memory Usage: 36.9 MB, less than 86.20% of Java online submissions for Compare Version Numbers.
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int i = 0;
        while (i < split1.length && i < split2.length) {
            int n1 = Integer.parseInt(split1[i]);
            int n2 = Integer.parseInt(split2[i]);
            i++;

            if (n1 == n2)
                continue;
            if (n1 > n2)
                return 1;
            return -1;
        }
        while (i < split1.length) {
            int n1 = Integer.parseInt(split1[i++]);
            if (n1 > 0)
                return 1;
        }
        while (i < split2.length) {
            int n2 = Integer.parseInt(split2[i++]);
            if (n2 > 0)
                return -1;
        }
        return 0;
    }
}
