class Solution {
    public boolean uniformArray(int[] nums1) {

        int min = nums1[0];

        // Find the smallest element
        for (int num : nums1) {
            min = Math.min(min, num);
        }

        // If minimum is odd,
        // every other element can be made odd.
        if (min % 2 != 0) {
            return true;
        }

        // If minimum is even,
        // every element must already be even.
        for (int num : nums1) {
            if (num % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}