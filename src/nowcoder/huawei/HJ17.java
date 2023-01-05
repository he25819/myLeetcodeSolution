package nowcoder.huawei;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] cmds = str.split(";");

            int x = 0, y = 0;
            for (int i = 0; i < cmds.length; i++) {
                if (cmds[i] == null || cmds[i].length() < 2 || cmds[i].length() > 3)
                    continue;
                if (cmds[i].charAt(0) != 'W'
                        && cmds[i].charAt(0) != 'A'
                        && cmds[i].charAt(0) != 'S'
                        && cmds[i].charAt(0) != 'D')
                    continue;
                Integer step;
                try {
                    step = Integer.valueOf(cmds[i].substring(1));
                } catch (NumberFormatException ex) {
                    continue;
                }
                switch (cmds[i].charAt(0)) {
                    case 'W':
                        y += step;
                        break;
                    case 'A':
                        x -= step;
                        break;
                    case 'S':
                        y -= step;
                        break;
                    case 'D':
                        x += step;
                        break;
                }
            }
            System.out.printf("%d,%d\n", x, y);
        }
    }
}
