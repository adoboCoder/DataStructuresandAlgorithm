class LCE_408ValidWordAbbreviation {
    public static boolean validWord(String word, String abbreviation) {
        int i = 0;
        int j = 0;

        while(i < word.length() && j < abbreviation.length()) {
            if(word.charAt(i) == abbreviation.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if(abbreviation.charAt(j) <= '0' || abbreviation.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while(j < abbreviation.length() && abbreviation.charAt(j) >= '0' && abbreviation.charAt(j) <= '9') {
                j++;
            }
            int num = Integer.valueOf(abbreviation.substring(start, j));
            i = i + num;
            }
        
        return i == word.length() && j == abbreviation.length();
    }
    public static void main(String[] args) {
        String word = "internationalization";
        String abbreviation = "i12iz4n";
        System.out.println(LCE_408ValidWordAbbreviation.validWord(word, abbreviation));
        word = "apple";
        abbreviation = "a2e";
        System.out.println(LCE_408ValidWordAbbreviation.validWord(word, abbreviation));
        
    }
}