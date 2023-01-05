package nowcoder.huawei;

import java.util.Scanner;

public class HJ18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A=0,B=0,C=0,D=0,E=0;
        int ERR=0, PRI=0;
        outer: while (in.hasNextLine()) {
            String str = in.nextLine();
            if (str.length() == 0)
                continue;
            String[] split = str.split("~");
            if (split.length != 2) {
                ERR++;
                continue;
            }
            String[] ipSplit = split[0].split("\\.");
            String[] maskSplit = split[1].split("\\.");
            int[] ip = new int[4];
            int[] mask = new int[4];
            if (ipSplit.length != 4 || maskSplit.length != 4) {
                ERR++;
                continue;
            }
            for (int i = 0; i < 4; i++) {
                try {
                    ip[i] = Integer.parseInt(ipSplit[i]);
                } catch (Exception ex) {
                    ERR++;
                    continue outer;
                }
                if (ip[i] < 0 || ip[i] > 255) {
                    ERR++;
                    continue outer;
                }
            }
            // ip第一位为0,127时忽略
            if (ip[0] == 0 || ip[0] == 127) {
                continue;
            }
            // ip合法了

            int maskBit = 0;
            for (int i = 0; i < 4; i++) {
                try {
                    mask[i] = Integer.parseInt(maskSplit[i]);
                } catch (Exception ex) {
                    ERR++;
                    continue outer;
                }
                if (mask[i] < 0 || mask[i] > 255) {
                    ERR++;
                    continue outer;
                }
                maskBit <<= 8;
                maskBit |= mask[i];
            }
            if (maskBit == 0 || maskBit == -1) {
                //mask非法
                ERR++;
                continue;
            }
            for (int i = 1; i < 32; i++) {
                if (-maskBit == (1 << i)) {
                    break;
                }
                if (i == 31) {
                    ERR++;
                    continue outer;
                }
            }
            // mask合法了

            if ((ip[0] == 10) || (ip[0] == 172 && ip[1] >= 16 && ip[1] <= 31) || (ip[0] == 192 && ip[1] == 168))
                PRI++;

            if (ip[0] >= 1 && ip[0] <= 126)
                A++;
            else if (ip[0] >= 128 && ip[0] <= 191)
                B++;
            else if (ip[0] >= 192 && ip[0] <= 223)
                C++;
            else if (ip[0] >= 224 && ip[0] <= 239)
                D++;
            else if (ip[0] >= 240 && ip[0] <= 255)
                E++;
        }
        System.out.printf("%d %d %d %d %d %d %d", A,B,C,D,E,ERR,PRI);
    }
}
