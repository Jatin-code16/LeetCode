import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0, max = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int l = 0;

        for (int r = 0; r < n; r++) {
            sum += nums[r];
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);

            // Keep the window size exactly at k
            if (r - l + 1 > k) {
                sum -= nums[l];
                mpp.put(nums[l], mpp.get(nums[l]) - 1);
                if (mpp.get(nums[l]) == 0) {
                    mpp.remove(nums[l]);
                }
                l++;
            }

            // If the window size is k and all elements are unique
            if (r - l + 1 == k && mpp.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}