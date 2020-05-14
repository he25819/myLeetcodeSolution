package leetcode;

public class Problem12 {
    public static void main(String[] args) {
        for (int i = 1; i < 4000; i++)
            System.out.println(i);
    }

    // Runtime: 4 ms, faster than 89.89% of Java online submissions for Integer to Roman.
    //Memory Usage: 39.3 MB, less than 20.00% of Java online submissions for Integer to Roman.
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int thousand = num / 1000;

        if (thousand == 3)
            sb.append("MMM");
        else if (thousand == 2)
            sb.append("MM");
        else if (thousand == 1)
            sb.append("M");

        int hundred = num / 100 % 10;
        if (hundred <= 3) {
            sb.append("C".repeat(hundred));
        } else if (hundred == 4) {
            sb.append("CD");
        } else if (hundred == 9) {
            sb.append("CM");
        } else {
            sb.append("D");
            sb.append("C".repeat(hundred - 5));
        }

        int ten = num / 10 % 10;
        if (ten <= 3) {
            sb.append("X".repeat(ten));
        } else if (ten == 4) {
            sb.append("XL");
        } else if (ten == 9) {
            sb.append("XC");
        } else {
            sb.append("L");
            sb.append("X".repeat(ten - 5));
        }

        int one = num % 10;
        if (one <= 3) {
            sb.append("I".repeat(one));
        } else if (one == 4) {
            sb.append("IV");
        } else if (one == 9) {
            sb.append("IX");
        } else {
            sb.append("V");
            sb.append("I".repeat(one - 5));
        }

        return sb.toString();
    }
}
