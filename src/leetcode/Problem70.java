package leetcode;

public class Problem70 {
    public static void main(String[] args) {
        Problem70 p = new Problem70();
        long t1, t2;

        t1 = System.currentTimeMillis();
        System.out.println(p.climbStairs(70));
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);


        t1 = System.currentTimeMillis();
        System.out.println(p.climbStairs2(70));
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

        t1 = System.currentTimeMillis();
        System.out.println(p.climbStairs3(70));
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    //Memory Usage: 36.3 MB, less than 19.29% of Java online submissions for Climbing Stairs.
    public int climbStairs(int n) {
        if (n <= 3)
            return n;
        return climbStairs(n - 3) + climbStairs(n - 2)* 2;
    }


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    //Memory Usage: 36.5 MB, less than 6.51% of Java online submissions for Climbing Stairs.
    public int climbStairs2(int n) {
        if (n <= 3)
            return n > 0 ? n : 1;
        return climbStairs(n - 3) * 3 + climbStairs(n - 4)* 2;
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    //Memory Usage: 36.1 MB, less than 54.66% of Java online submissions for Climbing Stairs.
    public int climbStairs3(int n) {
        if (n <= 3)
            return n;
        int a = 1, b = 2;
        while (n-- > 2) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
