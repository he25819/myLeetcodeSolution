package leetcode;

public class Problem984 {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for String Without AAA or BBB.
    //Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for String Without AAA or BBB.
    public String strWithout3a3b(int A, int B) {
        if (A >= B)
            return strWithout3a3b(A, B, 'a', 'b');
        else
            return strWithout3a3b(B, A, 'b', 'a');
    }

    private String strWithout3a3b(int A, int B, char a, char b) {
        StringBuffer sb = new StringBuffer();
        int x = A - B;
        while (x > 2) {
            sb.append(a).append(a).append(b);
            x--;
            B--;
        }
        while (B > 0) {
            sb.append(a).append(b);
            B--;
        }
        for (int i = 0; i < x; i++)
            sb.append(a);
        return sb.toString();
    }
}
