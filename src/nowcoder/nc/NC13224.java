package nowcoder.nc;

import java.util.Scanner;

public class NC13224 {
    // 7
    //5 -3 6 1 -1 -1 6
    //-6 1 4 -2 0 -1 0
    // Infinity!
    private static boolean infinity = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            for (int i = 0; i < n; i++)
                b[i] = in.nextInt();

            boolean[] visited = new boolean[n];
            boolean[] cycle = new boolean[n];
            StringBuilder sb = new StringBuilder();
            if (dfs(0, n, a, b, visited, cycle, sb)) {
                if (infinity)
                    System.out.println("Infinity!");
                else
                    System.out.println(sb.toString());
            } else
                System.out.println("No solution!");
        }
    }

    private static boolean dfs(int i, int n, int[] a, int[] b, boolean[] visited, boolean[] cycle, StringBuilder sb) {
        if (i < 0 || i >= n)
            return false;
        if (i == n - 1)
            return true;
        if (visited[i]) {
            cycle[i] = true;
            return false;
        }
        visited[i] = true;
        sb.append('a');
        if (dfs(i + a[i], n, a, b, visited, cycle, sb)) {
            if (cycle[i])
                infinity = true;
            return true;
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append('b');
        if (dfs(i + b[i], n, a, b, visited, cycle, sb)) {
            if (cycle[i])
                infinity = true;
            return true;
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 不知道为何注解掉这行才能AC
        //visited[i] = false;
        return false;
    }
}
