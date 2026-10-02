class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    public void backtrack(List<String> result, String s,
                          int open, int close, int n) {

        // If the string has 2*n brackets
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }

        // Add '('
        if (open < n) {
            backtrack(result, s + "(", open + 1, close, n);
        }

        // Add ')'
        if (close < open) {
            backtrack(result, s + ")", open, close + 1, n);
        }
    }
}