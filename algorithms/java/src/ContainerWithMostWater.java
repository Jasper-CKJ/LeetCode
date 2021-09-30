/**
 * @author jasper
 * @create 2021-09-30 17:06
 */
public class ContainerWithMostWater {
    /**
     * 暴力
     * 时间复杂度：O（n²）
     * 空间复杂度：O（1）
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                if (h * (j - i) > max) {
                    max = h * (j - i);
                }
            }
        }
        return max;
    }

    /**
     * 逻辑优化
     * 时间复杂度：O（n）。
     * 空间复杂度：O（1）。
     */
    public int maxArea2(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
