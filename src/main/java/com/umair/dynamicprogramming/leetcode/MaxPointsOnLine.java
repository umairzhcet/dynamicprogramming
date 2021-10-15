package com.umair.dynamicprogramming.leetcode;

import java.math.BigDecimal;
import java.util.*;

class MaxPointsOnLine {
    Map<BigDecimal,Integer> map=new HashMap<>();

    public static void main(String[] args) {
        MaxPointsOnLine sol=new MaxPointsOnLine();
        int[][] points={{9,-25},{-4,1},{-1,5},{-7,7}};
        sol.maxPoints(points);
    }
    public int maxPoints(int[][] points) {

        Point[] pointArray = new Point[points.length];
        for (int i=0; i<points.length; i++)  {
            pointArray[i]=new Point(points[i][0],points[i][1]);
        }

        return  maxPoints(pointArray);

    }

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;

        int n = points.length, max = 1;

        Map<String, Set<Point>> map = new HashMap<String, Set<Point>>();

        // sort the points by x to avoid -0.0 slope issue!
        Collections.sort(Arrays.asList(points), new Comparator<Point>() {
            public int compare(Point a, Point b) { return a.x - b.x; }
        });

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Point p1 = points[i];
                Point p2 = points[j];

                StringBuilder sb = new StringBuilder();

                if (p1.x == p2.x) {
                    sb.append("inf").append(p1.x);
                } else {
                    // y = k * x + d
                    double k = (double)(p1.y - p2.y) / (p1.x - p2.x);
                    double d = p1.y - k * p1.x;
                    sb.append("k").append(k).append("d").append(d);
                }

                String key = sb.toString();
                Set<Point> set = map.containsKey(key) ? map.get(key) : new HashSet<Point>();

                set.add(p1);
                set.add(p2);

                map.put(key, set);
                max = Math.max(max, set.size());
            }
        }

        return max;
    }
}
