package leetcode;

public class Problem849 {
    // 11ms
    // O(N)
    public int maxDistToClosest(int[] seats) {
        int result = 0;

        int zeros = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                zeros++;
                continue;
            } else if (zeros == i) {
                result = zeros;
            } else {
                result = Math.max(result, ++zeros / 2);
            }
            zeros = 0;
        }
        result = Math.max(result, zeros);
        return result;
    }
}
