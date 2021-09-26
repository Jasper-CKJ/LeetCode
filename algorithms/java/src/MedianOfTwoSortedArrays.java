/**
 * @author jasper
 * @create 2021-09-24 18:02
 */
public class MedianOfTwoSortedArrays {
    /**
     * 暴力，将两个数组有序合并
     * 时间复杂度：遍历全部数组，O（m + n）
     * 空间复杂度：开辟了一个数组，保存合并后的两个数组，O（m + n）
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums = new int[l1 + l2];
        int count = 0, i = 0, j = 0;
        while (count != (l1 + l2)) {
            if (i == l1) {
                while (j != l2) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == l2) {
                while (i != l1) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    /**
     * 第k小数
     * 时间复杂度：每进行一次循环，我们就减少 k / 2 个元素，所以时间复杂度是O（log（m + n））。
     * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，所以空间复杂度为 O（1）。
     */
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }
}
