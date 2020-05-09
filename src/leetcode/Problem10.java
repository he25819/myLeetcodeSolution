package leetcode;

import java.util.regex.Pattern;

public class Problem10 {
    public static void main(String[] args) {
        System.out.println(new Problem10().isMatch2("aa", "a*"));
    }


    /* 测试用例
"aa"
"a"
"adg"
".*"
""
""
"aaaaaaaabbbbbbb"
"aa*a*a*a*.b*b.b*"
    */
    // 未完成
    public boolean isMatch(String s, String p) {
//        if (s == null || p == null)
//            return false;
//        char[] ss = s.toCharArray();
//        char[] ps = p.toCharArray();
//
//        int i = 0;
//        int j = 0;
//        while (i < s.length()) {
////            if (ps[j])
//        }
        return true;
    }



    // leetcode屏蔽了java.util.regex.Pattern
    public boolean isMatch2(String s, String p) {
        return Pattern.compile("^" + p + "$").matcher(s).matches();
    }
}