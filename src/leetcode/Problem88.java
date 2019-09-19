package leetcode;

public class Problem88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2, 5, 6};
        new Problem88().merge(nums1, 3, nums2, 3);
    }

    //88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int index = 0;
        int i = 0, j = 0;
        int lt, rt;

        while (i < m && j < n) {
            lt = nums1[i];
            rt = nums2[j];
            if (lt < rt) {
                i++;
                result[index++] = lt;
            } else {
                j++;
                result[index++] = rt;
            }
        }
        while (i < m) {
            result[index++] = nums1[i++];
        }
        while (j < n) {
            result[index++] = nums2[j++];
        }
        System.arraycopy(result, 0, nums1, 0, m + n);
    }
}
