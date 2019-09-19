package CodePlus.competition5;

import java.util.Scanner;

public class FaShi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] positions = new int[n][2];
            int firstFaShi = -1;
            int firstX = Integer.MAX_VALUE;
            int firstY = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                positions[i][0] = in.nextInt();
                positions[i][1] = in.nextInt();
                if (positions[i][0] < firstX) {
                    firstX = positions[i][0];
                    firstY = positions[i][1];
                    firstFaShi = i;
                } else if (positions[i][0] == firstX && positions[i][1] < firstY) {
                    firstX = positions[i][0];
                    firstY = positions[i][1];
                    firstFaShi = i;
                }
            }

            int thisFashi = firstFaShi;
            int thisX = firstX;
            int thisY = firstY;
            int nextFashi = -1;
            double distance;
            double gradient = Integer.MIN_VALUE;

            double out = 0;
            while (nextFashi != firstFaShi) {
                int largerMinFashi = -1;
                double largerMinGradient = Integer.MAX_VALUE;
                double distanceLargerMin = -1;
                int minFashi = -1;
                double minGradient = gradient;
                double distanceMin = -1;
                for (int i = 0; i < n; i++) {
                    if (thisFashi == i)
                        continue;

                    double tempGradient;
                    if (thisX == positions[i][0]) {
                        if (gradient == Integer.MAX_VALUE && thisY > positions[i][1])
                            continue;
                        tempGradient = thisY > positions[i][1] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    } else
                        tempGradient = (double) (positions[i][1] - thisY) / (positions[i][0] - thisX);

                    if (tempGradient - gradient > 0.00001 && largerMinGradient - tempGradient > 0.00001) {
                        largerMinGradient = tempGradient;
                        distanceLargerMin = Math.sqrt((positions[i][0] - thisX) * (positions[i][0] - thisX) + (positions[i][1] - thisY) * (positions[i][1] - thisY));
                        largerMinFashi = i;
                    } else if (Math.abs(tempGradient - largerMinGradient) < 0.00001) {
                        double tempDistance = Math.sqrt((positions[i][0] - thisX) * (positions[i][0] - thisX) + (positions[i][1] - thisY) * (positions[i][1] - thisY));
                        if (tempDistance - distanceLargerMin > 0.00001) {
                            largerMinGradient = tempGradient;
                            distanceLargerMin = tempDistance;
                            largerMinFashi = i;
                        }
                    } else if (largerMinFashi != -1) {
                        continue;
                    } else if (gradient - tempGradient > 0.00001 && minGradient - tempGradient > 0.00001) {
                        minGradient = tempGradient;
                        distanceMin = Math.sqrt((positions[i][0] - thisX) * (positions[i][0] - thisX) + (positions[i][1] - thisY) * (positions[i][1] - thisY));
                        minFashi = i;
                    } else if (Math.abs(tempGradient - minGradient) < 0.00001) {
                        double tempDistance = Math.sqrt((positions[i][0] - thisX) * (positions[i][0] - thisX) + (positions[i][1] - thisY) * (positions[i][1] - thisY));
                        if (tempDistance - distanceMin > 0.00001) {
                            minGradient = tempGradient;
                            distanceMin = tempDistance;
                            minFashi = i;
                        }
                    }
                }
                if (largerMinFashi != -1) {
                    nextFashi = largerMinFashi;
                    distance = distanceLargerMin;
                    gradient = largerMinGradient;
                } else {
                    nextFashi = minFashi;
                    distance = distanceMin;
                    gradient = minGradient;
                }
                out += Math.PI * distance / 2;
                thisX = positions[nextFashi][0];
                thisY = positions[nextFashi][1];
                thisFashi = nextFashi;
            }
            System.out.println(out);
        }
    }
}
