package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-13 18:22
 **/
public class Problem67 {
    public static void main(String[] args) {
        System.out.println(new Problem67().addBinary("11", "1"));
    }

    // Runtime: 2 ms, faster than 76.87% of Java online submissions for Add Binary.
    //Memory Usage: 37.5 MB, less than 6.33% of Java online submissions for Add Binary.
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a.length() < b.length()) {
            String c = a;
            a = b;
            b = c;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;

        int over = 0;
        while (j >= 0) {
            if (a.charAt(i) == b.charAt(j)) {
                sb.append(over);
                if (a.charAt(i) == '1')
                    over = 1;
                else
                    over = 0;
            } else {
                sb.append(1 - over);
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (a.charAt(i--) == '1') {
                sb.append(1 - over);
            } else {
                sb.append(over);
                over = 0;
            }
        }
        if (over == 1)
            sb.append('1');
        return sb.reverse().toString();
    }
}
