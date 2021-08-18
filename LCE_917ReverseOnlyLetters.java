class LCE_917ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] characters = s.toCharArray();
        
        while(i < j){
            while(i < j && !Character.isLetter(s.charAt(i))){
                i++;
            }
            while(j > i && !Character.isLetter(s.charAt(j))){
                j--;
            }
            
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
            i++;
            j--;
            
        }
        return new String(characters);
    }
    public static void main(String[] args) {
        System.out.println(LCE917_ReverseOnlyLetters.reverseOnlyLetters("ab-cd"));
    }
}
