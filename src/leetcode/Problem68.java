package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 10:31
 **/
public class Problem68 {
    public static void main(String[] args) {
//        System.out.println(new Problem68().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(new Problem68().fullJustify(new String[]{"The","important","thing","is","not","to","stop","questioning.","Curiosity","has","its","own","reason","for","existing."}, 17));
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Text Justification.
    //Memory Usage: 37.1 MB, less than 13.49% of Java online submissions for Text Justification.
    public List<String> fullJustify(String[] words, int maxWidth) {
        int l = 0, r = 0;
        int width = -1;
        StringBuilder sb = new StringBuilder();
        List<String> rst = new ArrayList<>();
        while (r < words.length) {
            width += words[r].length() + 1;
            if (width > maxWidth) {
                width = width - words[r].length() - 1;
                int extraSpace = maxWidth - width;
                sb.append(words[l]);
                for (int i = l + 1; i < r; i++) {
                    int baseSpace = extraSpace / (r - 1 - l);
                    sb.append(" ".repeat(1 + baseSpace + (extraSpace - baseSpace * (r - l - 1) >= (i - l) ? 1 : 0)));
                    sb.append(words[i]);
                }
                if (sb.length() < maxWidth)
                    sb.append(" ".repeat(maxWidth - sb.length()));
                rst.add(sb.toString());
                l = r--;
                sb.delete(0, sb.length());
                width = -1;
            }
            r++;
        }
        sb.append(words[l]);
        for (int i = l + 1; i < words.length; i++) {
            sb.append(' ').append(words[i]);
        }
        if (sb.length() < maxWidth)
            sb.append(" ".repeat(maxWidth - sb.length()));
        rst.add(sb.toString());
        return rst;
    }

}
