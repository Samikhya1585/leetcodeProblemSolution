import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();

        int n = nums.length;

        // Generate every subarray of size k
        for (int i = 0; i <= n - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Count this window only once for each number
            for (int num : set) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;

        // Find largest number appearing in exactly one window
        for (int num : count.keySet()) {

            if (count.get(num) == 1) {
                ans = Math.max(ans, num);
            }
        }

        return ans;
    }
}