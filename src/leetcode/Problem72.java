package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-15 17:59
 **/
public class Problem72 {
    public static void main(String[] args) {
        System.out.println(new Problem72().minDistance("horse", "ros"));
    }

    // Runtime: 5 ms, faster than 68.68% of Java online submissions for Edit Distance.
    //Memory Usage: 39.1 MB, less than 19.11% of Java online submissions for Edit Distance.
    public int minDistance(String word1, String word2) {
        int[][] minDist = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++)
            minDist[i][0] = i;
        for (int j = 1; j <= word2.length(); j++)
            minDist[0][j] = j;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                minDist[i][j] = Math.min(Math.min(
                        minDist[i][j - 1] + 1,
                        minDist[i - 1][j] + 1),
                        minDist[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)
                );
            }
        }
        return minDist[word1.length()][word2.length()];
    }
}
