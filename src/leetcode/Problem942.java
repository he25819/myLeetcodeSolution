package leetcode;

public class Problem942 {

    //Runtime: 2 ms, faster than 95.21% of Java online submissions for DI String Match.
    //Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for DI String Match.
    public int[] diStringMatch(String S) {
        int[] result = new int[S.length() + 1];
        int min = 0, max = S.length();
        int i = 0;

        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (c == 'I')
                result[i++] = min++;
            else
                result[i++] = max--;
        }
        result[i] = min;
        return result;
    }
}
