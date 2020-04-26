package tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> retOut = new ArrayList<>();
        int k = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Point> ACollection = new ArrayList<>();
            List<Point> BCollection = new ArrayList<>();
            for (int j = 0; j < 2 * n; j++) {
                String[] pointXy = scanner.nextLine().split(" ");
                int x = Integer.parseInt(pointXy[0]);
                int y = Integer.parseInt(pointXy[1]);
                if(j < n){
                    ACollection.add(new Point(x, y));
                }else{
                    BCollection.add(new Point(x, y));
                }
            }
            double distance = getMinDistance(ACollection, BCollection);
            retOut.add(distance);
        }
        for (Double d: retOut){
            System.out.println(String.format("%.3f", d));
        }
    }

    private static double getMinDistance(List<Point> aCollection, List<Point> bCollection) {
        double ret = Double.MAX_VALUE;
        for(Point aPoint: aCollection){
            for(Point bPoint: bCollection){
                double distance = getDistanceByPoint(aPoint, bPoint);
                ret = Math.min(distance, ret);
            }
        }
        return ret;
    }

    private static double getDistanceByPoint(Point aPoint, Point bPoint) {
        return Math.sqrt((aPoint.x - bPoint.x) * (aPoint.x - bPoint.x) + (aPoint.y - bPoint.y) * (aPoint.y - bPoint.y));
    }


    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}