package leetcode;

public class Problem38 {

    public static void main(String[] args) {
        System.out.println(new Problem38().countAndSay(5));
    }

    /**
     * Runtime: 1 ms, faster than 95.12% of Java online submissions for Count and Say.
     * Memory Usage: 36.9 MB, less than 51.34% of Java online submissions for Count and Say.
     */
    private static String[] res = new String[31];
    static {
        res[1] = "1";
        for (int i = 2; i <= 30; i++) {
            StringBuffer sb = new StringBuffer();
            int count = 0;
            char c = '^';
            for (char ch : res[i - 1].toCharArray()) {
                if (c == '^') {
                    c = ch;
                    count = 1;
                } else if (ch == c) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    count = 1;
                    c = ch;
                }
            }
            sb.append(count).append(c);

            res[i] = sb.toString();
        }
    }
    public String countAndSay(int n) {
        return res[n];
    }

}
