package leetcode;

public class Problem58 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
    //Memory Usage: 37.8 MB, less than 17.57% of Java online submissions for Length of Last Word.
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int len = 0;
        boolean startAWord = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (startAWord)
                    return len;
            } else {
                startAWord = true;
                len++;
            }
        }
        return len;
    }
}
