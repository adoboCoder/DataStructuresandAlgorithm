class Solution{
    public int expressiveWords(String S, String[] words){
        if(S == null || words == null){
            return 0;
        }
        int result = 0;
        for(String word : words){
            if(isExpressive(word, S)){
                result++;
            }
        }
        return result;
    }

    public boolean isExpressive(String word, String S){
        if(word == null){
            return false;
        }

        int i = 0;
        int j = 0;

        while(i < S.length() && j < word.length()){
            if(S.charAt(i) == word.charAt(j)){
                int length1 = getRepeatedLegnth(S, i);
                int length2 = getRepeatedLegnth(word, j);
                if(length1 < 3 && length1 != length2 || length1 >= 3 && length1 < length2){
                    return false;
                }
                i = i + length1;
                j = j + length2;
            }
            else{
                return false;
            }
        }
        return i == S.length() && j == word.length();
    }

    public int getRepeatedLegnth(String str, int i){
        int j = i;
        while(j < str.length() && str.charAt(i) == str.charAt(j)){
            j++;
        }
        return j - i;
    }

}