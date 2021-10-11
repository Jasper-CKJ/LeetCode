import java.util.Arrays;

/**
 * @author jasper
 * @create 2021-10-11 18:06
 */
public class ThreeSumClosest {
    /**
     * 暴力
     */
    public int threeSumClosest1(int[] nums, int target) {
        int sub = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs((nums[i] + nums[j] + nums[k] - target)) < sub) {
                        sum = nums[i] + nums[j] + nums[k];
                        sub = Math.abs(sum - target);
                    }
                }
            }
        }
        return sum;
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int sub = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int head = i + 1, tail = nums.length - 1;
            while (head < tail) {
                if (Math.abs((nums[head] + nums[tail] + nums[i] - target)) < sub) {
                    sum = nums[head] + nums[tail] + nums[i];
                    sub = Math.abs(sum - target);
                }
                if (nums[head] + nums[tail] + nums[i] > target) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return sum;
    }
}
