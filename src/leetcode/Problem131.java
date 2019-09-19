package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {
    // 22 / 22 test cases passed.
    //Status: Accepted
    //Runtime: 7 ms
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    tempList.add(s.substring(start, end + 1));
                    backtrack(result, tempList, s, end + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
