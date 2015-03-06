package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.struct.Point;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * @author yanfeixiang
 * 
 */
public class MaxPointsonaLine {
	public int maxPoints(Point[] points) {
		if (points.length <= 2) {
			return points.length;
		}
		Map<Double, Set<Point>> map = new HashMap<Double, Set<Point>>();
		int samePoint = 0;
		int max = 1;
		int xLine = 0;
		for (Point p1 : points) {
			map.clear();
			samePoint = 0;
			xLine = 0;
			for (Point p2 : points) {
				if (p1 == p2)
					continue;
				double x = (long) p1.x - (long) p2.x;
				double y = (long) p1.y - (long) p2.y;
				if (x == 0 && y == 0) {

					samePoint++;
				} else {
					if (y == 0) {
						xLine++;
					} else {
						double rate = x / y;
						if (map.containsKey(rate)) {

						} else {
							Set<Point> set = new HashSet<Point>();
							map.put(rate, set);
						}
						map.get(rate).add(p1);
						map.get(rate).add(p2);
					}

				}

			}
			max = Math.max(max, samePoint + 1);
			max = Math.max(max, xLine + 1);
			for (Map.Entry<Double, Set<Point>> en : map.entrySet()) {
//				System.out.println(en.getKey() + " " + en.getValue().size());
				max = Math.max(max, en.getValue().size() + samePoint);
			}
//			System.out.println("%%");
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new MaxPointsonaLine().maxPoints(new Point[] {
				new Point(29, 87), new Point(145, 227), new Point(400, 84),
				new Point(800, 179), new Point(60, 950), new Point(560, 122),
				new Point(-6, 5), new Point(-87, -53), new Point(-64, -118),
				new Point(-204, -388), new Point(720, 160),
				new Point(-232, -228), new Point(-72, -135),
				new Point(-102, -163), new Point(-68, -88),
				new Point(-116, -95), new Point(-34, -13), new Point(170, 437),
				new Point(40, 103), new Point(0, -38), new Point(-10, -7),
				new Point(-36, -114), new Point(238, 587),
				new Point(-340, -140), new Point(-7, 2), new Point(36, 586),
				new Point(60, 950), new Point(-42, -597), new Point(-4, -6),
				new Point(0, 18), new Point(36, 586), new Point(18, 0),
				new Point(-720, -182), new Point(240, 46), new Point(5, -6),
				new Point(261, 367), new Point(-203, -193), new Point(240, 46),
				new Point(400, 84), new Point(72, 114), new Point(0, 62),
				new Point(-42, -597), new Point(-170, -76),
				new Point(-174, -158), new Point(68, 212),
				new Point(-480, -125), new Point(5, -6), new Point(0, -38),
				new Point(174, 262), new Point(34, 137), new Point(-232, -187),
				new Point(-232, -228), new Point(232, 332),
				new Point(-64, -118), new Point(-240, -68),
				new Point(272, 662), new Point(-40, -67), new Point(203, 158),
				new Point(-203, -164), new Point(272, 662), new Point(56, 137),
				new Point(4, -1), new Point(-18, -233), new Point(240, 46),
				new Point(-3, 2), new Point(640, 141), new Point(-480, -125),
				new Point(-29, 17), new Point(-64, -118), new Point(800, 179),
				new Point(-56, -101), new Point(36, 586), new Point(-64, -118),
				new Point(-87, -53), new Point(-29, 17), new Point(320, 65),
				new Point(7, 5), new Point(40, 103), new Point(136, 362),
				new Point(-320, -87), new Point(-5, 5), new Point(-340, -688),
				new Point(-232, -228), new Point(9, 1), new Point(-27, -95),
				new Point(7, -5), new Point(58, 122), new Point(48, 120),
				new Point(8, 35), new Point(-272, -538), new Point(34, 137),
				new Point(-800, -201), new Point(-68, -88), new Point(29, 87),
				new Point(160, 27), new Point(72, 171), new Point(261, 367),
				new Point(-56, -101), new Point(-9, -2), new Point(0, 52),
				new Point(-6, -7), new Point(170, 437), new Point(-261, -210),
				new Point(-48, -84), new Point(-63, -171), new Point(-24, -33),
				new Point(-68, -88), new Point(-204, -388), new Point(40, 103),
				new Point(34, 137), new Point(-204, -388),
				new Point(-400, -106) }));
	}
}
