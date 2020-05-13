package leetcode;

public class Problem6 {
    public static void main(String[] args) {
        System.out.println(new Problem6().convert("PAYPALISHIRING", 7));
    }



    // Runtime: 23 ms, faster than 17.28% of Java online submissions for ZigZag Conversion.
    //Memory Usage: 40.5 MB, less than 31.92% of Java online submissions for ZigZag Conversion.
    public String convert(String s, int numRows) {
        char[][] map = new char[numRows][s.length() * numRows / (2 * numRows - 1) + 1];
        char[] chars = s.toCharArray();

        boolean isDown = true;
        int i = 0, j = 0;
        int idx = 0;
        while (idx < chars.length) {
            map[i][j] = chars[idx++];
            if (isDown) {
                if (i < map.length - 1) {
                    i++;
                } else if (i > 0) {
                    i--;
                    j++;
                    isDown = false;
                } else {
                    j++;
                }
            } else {
                if (i == 0) {
                    i++;
                    isDown = true;
                } else if (i < map.length - 1) {
                    i--;
                    j++;
                } else {
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y] != Character.MIN_VALUE)
                    sb.append(map[x][y]);
            }
        }
        return sb.toString();
    }
}
