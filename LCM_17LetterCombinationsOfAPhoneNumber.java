import java.util.*;

class LCM_17LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();

        // Check input and call DFS
        if (digits != null && digits.length() > 0) {
            String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
            dfs(digits, map, result, new StringBuilder(), 0);
        }
        return result;
    }

    private static void dfs(String digits, String[] map, ArrayList<String> result, StringBuilder sb, int index) {
        // base case for dfs to exit recursion
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(index));
        String letters = map[digit];

        // Adding each letter to the string we've built so far
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            sb.append(c);
            dfs(digits, map, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(LCM_17LetterCombinationsOfAPhoneNumber.letterCombinations("23"));
    }
}
/*
 * Time: O(n 4^n) because w maps to wxyz, and 7 maps to pqrs "9999"
 * Space: O(n)
 */