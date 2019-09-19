package leetcode;

import java.util.Arrays;
import java.util.Random;

public class Problem4 {
    public static void test() {
        Random rdm = new Random();
        int m = rdm.nextInt(100000000) + 100000000;
        int n = rdm.nextInt(100000000) + 100000000;

        int[] nums1 = new int[m];
        int[] nums2 = new int[n];

        for (int i = 0; i < m; i++) {
            nums1[i] = rdm.nextInt(100000000);
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = rdm.nextInt(200000000);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Problem4 problem4 = new Problem4();
        long start = System.currentTimeMillis();
        double res0 = problem4.findMedianSortedArrays0(nums1, nums2);
        long end = System.currentTimeMillis();
        System.out.printf("median0=%.1f    %d ms\n", res0, end - start);

        start = System.currentTimeMillis();
        double res1 = problem4.findMedianSortedArrays1(nums1, nums2);
        end = System.currentTimeMillis();
        System.out.printf("median1=%.1f    %d ms\n", res1, end - start);

        start = System.currentTimeMillis();
        double res2 = problem4.findMedianSortedArrays2(nums1, nums2);
        end = System.currentTimeMillis();
        System.out.printf("median2=%.1f    %d ms\n", res2, end - start);

        start = System.currentTimeMillis();
        double res3 = problem4.findMedianSortedArrays3(nums1, nums2);
        end = System.currentTimeMillis();
        System.out.printf("median3=%.1f    %d ms\n", res3, end - start);

        start = System.currentTimeMillis();
        double res4 = problem4.findMedianSortedArrays4(nums1, nums2);
        end = System.currentTimeMillis();
        System.out.printf("median4=%.1f    %d ms\n", res4, end - start);

        System.out.println("-------------");
    }

    public static void main(String[] args) {
        double res4 = new Problem4().findMedianSortedArrays4(new int[]{4}, new int[]{1, 2, 3});
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    // 暴力解法，排序
    // brute force O((m+n)log(m+n))
    // Accepted 50ms
    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        System.arraycopy(nums1, 0, nums, 0, m);
        System.arraycopy(nums2, 0, nums, m, n);
        Arrays.sort(nums);

        int median = (m + n) / 2;
        if ((m + n) % 2 == 1) {
            return nums[median];
        } else {
            return ((double) nums[median] + nums[median - 1]) / 2;
        }
    }

    // Accepted 2084/2084 test cases passed.
    // 38ms
    // O(log(m))
    // quickselect with binarysearch
    // 不管奇数、偶数：返回第k1,k2小元素平均值。k1 = (m + n - 1) >>> 1; k2 = (m + n) >>> 1;
    // 类似快速排序，二分查找nums1的中位数m，把两个数组分为：小于中位数、等于中位数、大于中位数三组。
    // 若k1,k2落在small/large组则递归small/large组,k1,k2不变
    // 若k1,k2落在middle组，直接返回答案
    // 若k1,k2落在不同组，依次递归A组和B组，求得第k1,k2小值后求平均返回。
    // 可以优化，分为2组(不包括pivot)而不是3组，S1<=pivot S2>=pivot，这里不优化了，下面有更优的解法
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k1 = (m + n - 1) >>> 1;
        int k2 = (m + n) >>> 1;

        if (m == 0)
            return (nums2[k1] + nums2[k2]) / 2.0;
        else if (n == 0) {
            return (nums1[k1] + nums1[k2]) / 2.0;
        }
        if (nums1[m - 1] <= nums2[0]) {
            if (k1 == k2) {
                return m > k1 ? nums1[k1] : nums2[k1 - m];
            } else {
                return ((double) ((m > k1 ? nums1[k1] : nums2[k1 - m]) + (m > k2 ? nums1[k2] : nums2[k2 - m]))) / 2;
            }
        }
        if (nums1[0] >= nums2[n - 1]) {
            return findMedianSortedArrays1(nums2, nums1);
        }

        int[] medians = findKIdxSortedArrays(nums1, nums2, 0, m - 1, 0, n - 1, k1, k2);

        return ((double) medians[0] + medians[1]) / 2;
    }

    /**
     * find kth(index form 0) from nums1[start1,end1] & nums2[start2,end2]
     */
    private int[] findKIdxSortedArrays(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k1, int k2) {
        if (end1 < start1)
            return new int[]{nums2[start2 + k1], nums2[start2 + k2]};
        if (end2 < start2)
            return new int[]{nums1[start1 + k1], nums1[start1 + k2]};
        int center = (end1 - start1) / 2 + start1;
        int pivot = nums1[center];

        int lo1 = center, hi1 = center;
        while (lo1 > start1 && nums1[lo1 - 1] == nums1[lo1])
            lo1--;
        while (hi1 < end1 && nums1[hi1 + 1] == nums1[hi1])
            hi1++;
        int lo2 = Arrays.binarySearch(nums2, pivot), hi2 = lo2;
        if (lo2 < 0) {
            lo2 = -lo2 - 1;
            hi2 = lo2 - 1;
        } else {
            while (lo2 > start2 && nums2[lo2 - 1] == nums2[lo2])
                lo2--;
            while (hi2 < end2 && nums2[hi2 + 1] == nums2[hi2])
                hi2++;
        }

        int groupSmall = lo1 - start1 + lo2 - start2;
        int groupSmallAndMiddle = hi1 - start1 + hi2 - start2 + 2;
//        int groupMiddle = hi1 - lo1 + hi2 - lo2 + 2;
//        int groupLarge = end1 - hi1 + end2 - hi2;

        if (k2 < groupSmall) {
            return findKIdxSortedArrays(nums1, nums2, start1, lo1 - 1, start2, lo2 - 1, k1, k2);
        } else if (k1 >= groupSmallAndMiddle) {
            return findKIdxSortedArrays(nums1, nums2, hi1 + 1, end1, hi2 + 1, end2, k1 - groupSmallAndMiddle, k2 - groupSmallAndMiddle);
        } else if (k1 >= groupSmall && k2 < groupSmallAndMiddle) {
            return new int[]{pivot, pivot};
        } else if (k2 < groupSmallAndMiddle) {
            int tmp = findKIdxSortedArrays(nums1, nums2, start1, lo1 - 1, start2, lo2 - 1, k1, k1)[0];
            return new int[]{tmp, pivot};
        } else {
            int tmp = findKIdxSortedArrays(nums1, nums2, hi1 + 1, end1, hi2 + 1, end2, k2 - groupSmallAndMiddle, k2 - groupSmallAndMiddle)[0];
            return new int[]{pivot, tmp};
        }
    }

    // 32ms
    // Time complexity: O(log(min(m,n))).
    // m <= n
    // binary search index of nums1 in [0, m], j = (m+n+1)/2 - i;
    // B[j-1]<=A[i] and A[i-1]<=B[j] means we have found the object ii, so stop searching.
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays2(nums2, nums1);
        }

        int sum_IJ = (m + n + 1) >>> 1;
        int l = 0, r = m;
        int i, j;
        while (l <= r) {
            i = (l + r) >>> 1;
            j = sum_IJ - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                r = i - 1;
            } else if (i < m && nums1[i] < nums2[j - 1]) {
                l = i + 1;
            } else {
                int leftMax;
                if (i == 0)
                    leftMax = nums2[j - 1];
                else if (j == 0)
                    leftMax = nums1[i - 1];
                else
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                if (((m + n) & 1) == 1)
                    return leftMax;

                int rightMin;
                if (i == m)
                    rightMin = nums2[j];
                else if (j == n)
                    rightMin = nums1[i];
                else
                    rightMin = Math.min(nums1[i], nums2[j]);
                return (leftMax + rightMin) / 2.0;
            }
        }
        return -1;
    }

    // copy from https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/very-concise-ologminmn-iterative-solution-with-detailed-explanation
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) return findMedianSortedArrays3(nums2, nums1);
        if (n == 0) return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == m * 2 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = mid2 == n * 2 ? Double.MAX_VALUE : nums2[mid2 / 2];
            if (L1 > R2) left = mid2 + 1;
            else if (L2 > R1) right = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }

    // O(m+n)
    // Accepted 67ms    2084 / 2084 test cases passed.
    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k1 = (m + n - 1) >>> 1;
        int k2 = (m + n) >>> 1;

        if (m == 0)
            return (nums2[k1] + nums2[k2]) / 2.0;
        else if (n == 0)
            return (nums1[k1] + nums1[k2]) / 2.0;

        int i = 0, j = 0;
        int count = 0;
        while (count < k1 && i < m && j < n) {
            count++;
            if (nums1[i] < nums2[j])
                if (i < m)
                    i++;
                else
                    j++;
            else
                j++;
        }
        if (count < k1)
            if (i == m)
                j += k1 - count;
            else
                i += k1 - count;

        if ((m + n) % 2 == 1)
            if (i == m)
                return nums2[j];
            else if (j == n)
                return nums1[i];
            else
                return Math.min(nums1[i], nums2[j]);
        else if (i == m)
            return (nums2[j] + nums2[j + 1]) / 2.0;
        else if (j == n)
            return (nums1[i] + nums1[i + 1]) / 2.0;
        else {
            if (nums1[i] <= nums2[j]) {
                if (i < m - 1) return (nums1[i] + Math.min(nums1[i + 1], nums2[j])) / 2.0;
            } else {
                if (j < n - 1) return (Math.min(nums1[i], nums2[j + 1]) + nums2[j]) / 2.0;
            }
            return (nums1[i] + nums2[j]) / 2.0;
        }
    }
}