package CodePlus.competition5;

import java.util.*;

public class JianKongZhongXin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            Map<Integer, List<Integer>> pipes = new HashMap<>();
            int[][] inputPipes = new int[n][2];
            for (int i = 0; i < m; i++) {
                int a = in.nextInt(), b = in.nextInt();
                inputPipes[i][0] = a;
                inputPipes[i][1] = b;
                if (!pipes.containsKey(a))
                    pipes.put(a, new ArrayList<>());
                pipes.get(a).add(b);
                if (!pipes.containsKey(b))
                    pipes.put(b, new ArrayList<>());
                pipes.get(b).add(a);
            }

            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                List<Integer> destroyed = new ArrayList<>();
                int c = in.nextInt();
                List<Integer> inputMessages = new ArrayList<>();
                for (int j = 0; j < c; j++) {
                    int message = in.nextInt();
                    inputMessages.add(message > 0 ? inputPipes[message - 1][0] : inputPipes[-message - 1][1]);
                    if (message > 0 && !destroyed.contains(inputPipes[message - 1][1]))
                        destroyed.add(inputPipes[message - 1][1]);
                    else if (message < 0 && !destroyed.contains(inputPipes[-message - 1][0]))
                        destroyed.add(inputPipes[-message - 1][0]);
                }


                int out = 0;
                while (out < destroyed.size()) {
                    int destroyedCity = destroyed.get(out);
                    for (int linkedCity : pipes.get(destroyedCity)) {
                        if (!inputMessages.contains(linkedCity) && !destroyed.contains(linkedCity)) {
                            destroyed.add(linkedCity);
                        }
                    }
                    out++;
                }
                System.out.println(out);
            }
//        }
    }
}
