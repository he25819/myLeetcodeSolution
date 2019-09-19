package leetcode;

public class Problem81 {
    // 275 / 275 test cases passed.
    //Status: Accepted
    //Runtime: 0 ms
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private boolean binarySearch(int[] nums, int target, int left, int right) {
        if (left > right)
            return false;
        int mid = (left + right) >> 1;
        if (target == nums[mid] || target == nums[left] || target == nums[right])
            return true;
        if (nums[left] >= nums[right]) {
            if (nums[mid] > nums[left]) {
                if (target > nums[left] && target < nums[mid])
                    return binarySearch(nums, target, left, mid - 1);
                else if (target < nums[right] || target > nums[mid])
                    return binarySearch(nums, target, mid + 1, right);
                else
                    return false;
            } else if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target < nums[right])
                    return binarySearch(nums, target, mid + 1, right);
                else if (target > nums[left] || target < nums[mid])
                    return binarySearch(nums, target, left, mid - 1);
                else
                    return false;
            } else
                return binarySearch(nums, target, left, mid - 1) || binarySearch(nums, target, mid + 1, right);
        } else {
            if (target > nums[left] && target < nums[mid])
                return binarySearch(nums, target, left, mid - 1);
            else if (target > nums[mid] && target < nums[right])
                return binarySearch(nums, target, mid + 1, right);
            else
                return false;
        }
    }

    // sample 0 ms submission
    // time complexity:O(logn)  space complexity:O(1)
    public boolean search2(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = (end - start)/2 + start;
            if(nums[mid] == target) return true;
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                end--;
                start++;
            }else if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        if(nums[start] == target) return true;
        if(nums[end] == target) return true;

        return false;
    }

    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search
    public boolean search3(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }

        return false;
    }
}
