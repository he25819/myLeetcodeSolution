package CodePlus.competition5;

import java.util.Scanner;

public class BaoGao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += in.nextInt();
            }
            if (sum >= 0)
                System.out.println("Wo jue de OK");
            else
                System.out.println("Wo jue de bu tai xing");
        }
    }
}
