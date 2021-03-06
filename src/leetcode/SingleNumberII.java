package leetcode;

/**
 * count the ith bits;
 * 
 * solve this problem with help.
 * https://oj.leetcode.com/discuss/857/constant-space-solution
 * 
 * @author yanfeixiang
 * 
 */
public class SingleNumberII {
	public int singleNumber(int[] A) {
		int[] count = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int a : A) {
				if (((a >> i) & 1) == 1) {
					count[i]++;
				}
			}
			result |= ((count[i] % 3) << i);
		}
		return result;
	}
}
