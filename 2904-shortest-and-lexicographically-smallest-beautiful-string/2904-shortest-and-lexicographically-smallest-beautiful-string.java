class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        ArrayList<Integer> ones = new ArrayList<>();

        // Store positions of all 1s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        // Not enough 1s
        if (ones.size() < k) {
            return "";
        }

        String ans = "";

        for (int i = 0; i + k - 1 < ones.size(); i++) {

            int start = ones.get(i);
            int end = ones.get(i + k - 1);

            String current = s.substring(start, end + 1);

            if (ans.equals("") ||
                current.length() < ans.length() ||
                (current.length() == ans.length() &&
                 current.compareTo(ans) < 0)) {

                ans = current;
            }
        }

        return ans;
    }
}