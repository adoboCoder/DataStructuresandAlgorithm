class Solution {
  public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int result = 0;
        int i = 0;
        for(; i + 1 < chars.length; i++) {
            if (map.get(chars[i]) >= map.get(chars[i + 1])) {
                result += map.get(chars[i]);
            } else {
                result -= map.get(chars[i]);
            }
        }
        result += map.get(chars[i]);
        return result;
    }
}

/* This solution utilizes a hashmap to store the Roman values, and iterates through the string input to calculate the values based on their
position of the string (determines whether to add or subtract the lookup values).

Time: O(n)
Space: O(n)

*/