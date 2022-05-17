package leetcode;

public class Problem13 {
    public static void main(String[] args) {
        System.out.println(new Problem13().romanToInt("MC"));
    }


    // 写的不好，虽然AC了
    // Runtime: 3 ms, faster than 100.00% of Java online submissions for Roman to Integer.
    //Memory Usage: 39.9 MB, less than 5.48% of Java online submissions for Roman to Integer.
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();
        int i = 0;
        int sum = 0;

        while (i < chars.length) {
            int value = 0;
            boolean isCheck = true;
            boolean isPlusPlus = false;
            switch (chars[i]) {
                case 'V':
                    value = 5;
                    isCheck = false;
                    i++;
                    break;
                case 'L':
                    value = 50;
                    isCheck = false;
                    i++;
                    break;
                case 'D':
                    value = 500;
                    isCheck = false;
                    i++;
                    break;
                case 'M':
                    value = 1000;
                    isCheck = false;
                    i++;
                    break;
                case 'I':
                    value = 1;
                    isPlusPlus = true;
                    break;
                case 'X':
                    value = 10;
                    isPlusPlus = true;
                    break;
                case 'C':
                    value = 100;
                    isPlusPlus = true;
                    break;
            }
            if (isCheck && i + 1 < chars.length) {
                int j = i + 1;
                if (chars[i] == 'I') {
                    if (chars[j] == 'V') {
                        i += 2;
                        value = 4;
                        isPlusPlus = false;
                    } else if (chars[j] == 'X') {
                        i += 2;
                        value = 9;
                        isPlusPlus = false;
                    }
                } else if (chars[i] == 'X') {
                    if (chars[j] == 'L') {
                        i += 2;
                        value = 40;
                        isPlusPlus = false;
                    } else if (chars[j] == 'C') {
                        i += 2;
                        value = 90;
                        isPlusPlus = false;
                    }
                } else if (chars[i] == 'C') {
                    if (chars[j] == 'D') {
                        i += 2;
                        value = 400;
                        isPlusPlus = false;
                    } else if (chars[j] == 'M') {
                        i += 2;
                        value = 900;
                        isPlusPlus = false;
                    }
                }
            }
            if (isPlusPlus)
                i++;
            sum += value;
        }

        return sum;
    }
}
