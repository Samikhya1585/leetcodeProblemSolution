class Solution {
    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                low++;
                high++;
            } 
            else if (c == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;   // '*' can be ')'
                high++;  // '*' can be '('
            }

            // Too many closing brackets
            if (high < 0) {
                return false;
            }

            // Minimum cannot be negative
            if (low < 0) {
                low = 0;
            }
        }

        return low == 0;
    }
}