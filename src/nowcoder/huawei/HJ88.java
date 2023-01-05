package nowcoder.huawei;

import java.util.Scanner;

public class HJ88 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String poker = "3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER";
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] hands = s.split("-");
            if (hands.length != 2) {
                continue;
            }
            String[] hand0 = hands[0].split(" ");
            String[] hand1 = hands[1].split(" ");
            if (hand0.length == 2 && hands[0].length() == 11)
                System.out.println(hands[0]);
            else if (hand1.length == 2 && hands[1].length() == 11)
                System.out.println(hands[1]);
            else {
                if (hand0.length != 4 && hand1.length == 4) {
                    String[] tempH = hand0;
                    hand0 = hand1;
                    hand1 = tempH;
                    String temp = hands[0];
                    hands[0] = hands[1];
                    hands[1] = temp;
                }
                if (hand0.length == 4) {
                    if (hand1.length == 4) {
                        System.out.println(poker.indexOf(hand0[0]) < poker.indexOf(hand1[0]) ? hands[1] : hands[0]);
                    } else {
                        System.out.println(hands[0]);
                    }
                } else if (hand0.length != hand1.length) {
                    System.out.println("ERROR");
                } else {
                    System.out.println(poker.indexOf(hand0[0]) < poker.indexOf(hand1[0]) ? hands[1] : hands[0]);
                }
            }
        }
    }
}
