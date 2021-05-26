import java.util.*;

class LCE_824GoatLatin {
    public static String toGoatLatin(String S){
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e','i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        if(S == null || S.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");

        for(String word : S.split(" ")) {
            if(sb.length() != 0) {
                sb.append(" ");
            }

            char c = word.charAt(0);

            if(vowels.contains(c)) {
                sb.append(word);
            }
            else {
                sb.append(word.substring(1));
                sb.append(c);
            }

            sb.append("ma").append(suffix);
            suffix.append("a");
        }
        return sb.toString();
    }

    public static void main(String[] agrs) {
        System.out.println(LCE_824GoatLatin.toGoatLatin("I Speak Goat Latin"));
        
    }
}