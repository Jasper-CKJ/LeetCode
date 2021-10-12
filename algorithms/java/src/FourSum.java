import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jasper
 * @create 2021-10-12 11:22
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        //多加了层循环
        for (int j = 0; j < nums.length - 3; j++) {
            //防止重复的
            if (j == 0 || nums[j] != nums[j - 1]) {
                for (int i = j + 1; i < nums.length - 2; i++) {
                    //防止重复的，不再是 i == 0 ，因为 i 从 j + 1 开始
                    if (i == j + 1 || nums[i] != nums[i - 1]) {
                        int head = i + 1, tail = nums.length - 1, sum = target - nums[j] - nums[i];
                        while (head < tail) {
                            if (nums[head] + nums[tail] == sum) {
                                res.add(Arrays.asList(nums[j], nums[i], nums[head], nums[tail]));
                                while (head < tail && nums[head] == nums[head + 1]) {
                                    head++;
                                }
                                while (head < tail && nums[tail] == nums[tail - 1]) {
                                    tail--;
                                }
                                head++;
                                tail--;
                            } else if (nums[head] + nums[tail] < sum) {
                                head++;
                            } else {
                                tail--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
