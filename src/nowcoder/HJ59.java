package nowcoder;

import java.util.Scanner;

public class HJ59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (str.length() == 0)
                continue;
            int[] charCount = new int[255];
            for (int i = 0; i < str.length(); i++) {
                charCount[str.charAt(i)]++;
            }

            boolean found = false;
            for (int i = 0; i < str.length(); i++) {
                if (charCount[str.charAt(i)] == 1) {
                    System.out.println(str.charAt(i));
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println(-1);
        }
    }
}
