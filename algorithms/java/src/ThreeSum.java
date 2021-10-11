import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.*;

/**
 * @author jasper
 * @create 2021-10-11 16:59
 */
public class ThreeSum {
    /**
     * 暴力
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if (!isInList(res, temp)) {
                            res.add(temp);
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isInList(List<List<Integer>> res, List<Integer> temp) {
        for (List<Integer> re : res) {
            if (isSame(re, temp)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSame(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 遍历数组，用 0 减去当前的数，作为 sum ，然后再找两个数使得和为 sum
     * 用两个指针，一个指向头，一个指向尾，去找这两个数字，这样的话，找另外两个数时间复杂度就会从 O（n²），降到 O（n）
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        // https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int head = i + 1, tail = nums.length - 1, sum = -nums[i];
                while (head < tail) {
                    if (nums[head] + nums[tail] == sum) {
                        res.add(Arrays.asList(nums[i], nums[head], nums[tail]));
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
        return res;
    }
}
