class Solution{
    public boolean isAlienSorted(String[] words, String order) {
        // 26 characters in the alphabel a-z
      int[] dict = new int[26];
      // inserting into dict array the order of each letter (New Alien dictionary)
      for (int i = 0; i < dict.length; i++) {
          int idx = order.charAt(i) - 'a';
          dict[idx] = i;
      }
      // Comparing via helper method the words in the array words[]
      for (int i = 0; i < words.length -1; i++) {
          if(compare(words[i], words[i +1], dict) > 0)return false;
      }

      return true;
  }

  private int compare(String word1, String word2, int[] dict)
  {
      // get the length of both words
      int L1 = word1.length();
      int L2 = word2.length();
      // determine which word is shorter, this will prevent going out of bounds in the for loop
      int min = Math.min(L1,L2);
      for (int i = 0; i < min; i++) {
          int c1 = word1.charAt(i) - 'a';
          int c2 = word2.charAt(i) - 'a';
          if(c1 != c2)
              return dict[c1] - dict[c2];
      }
      return L1 == min ? -1 : 1;
  }
}
