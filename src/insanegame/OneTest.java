package insanegame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * (55.9, 68.4, 80.8) (94.2, 24.7, 22.5) (12.5, 53.0, 59.9)
 */
public class OneTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] strings = nextLine.split("\\) \\(");
        String substring = strings[0].substring(1, strings[0].length() - 1);
        String[] split = substring.split(", ");
        List<Double> collect = Arrays.stream(split).map(Double::parseDouble).collect(Collectors.toList());
        Point x = new Point(collect.get(0), collect.get(1), collect.get(2));

        String[] split1 = strings[1].split(", ");
        List<Double> collect1 = Arrays.stream(split1).map(Double::parseDouble).collect(Collectors.toList());
        Point y = new Point(collect1.get(0), collect1.get(1), collect1.get(2));

        String substring3 = strings[2].substring(0, strings[0].length() - 2);
        String[] split3 = substring3.split(", ");
        List<Double> collect3 = Arrays.stream(split3).map(Double::parseDouble).collect(Collectors.toList());
        Point z = new Point(collect3.get(0), collect3.get(1), collect3.get(2));
        boolean ret =  fun(x, y, z);
        System.out.println(ret);
    }

    private static boolean fun(Point x, Point y, Point z) {
        double xyLength = getTwoPointLength(x, y);
        double xzLength = getTwoPointLength(x, z);
        double yzLength = getTwoPointLength(y, y);
        double min = Math.min(xyLength, Math.min(xzLength, yzLength));
        double max = Math.max(xyLength, Math.max(xzLength, yzLength));
        double v = max - min;
        int count = 0;
        if(xyLength > v)count++;
        if(yzLength > v)count++;
        if(xzLength > v)count++;
        return count != 2;
    }

    private static double getTwoPointLength(Point a, Point b) {
        return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y) + (a.z - b.z) * (a.z - b.z));
    }


    static class Point{
        double x;
        double y;
        double z;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }
}
