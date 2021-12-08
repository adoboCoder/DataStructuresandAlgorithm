import java.util.*;

class LCH_843GuessTheWord {
    int WORD_LENGTH = 6;
    int GUESSES = 10;
    public void findSecretWord(String[] wordlist, Master master) {
        int matches = 0;
        Random r = new Random();
        
        for(int i = 0; i < GUESSES && matches < WORD_LENGTH; i++) {
            String randomWord = wordlist[r.nextInt(wordlist.length)];
            matches = master.guess(randomWord);
            
            List<String> matchedWords = new ArrayList<>();
            for(String word : wordlist) {
                if(match(word, randomWord) == matches) {
                    matchedWords.add(word);
                }
            }
            wordlist = matchedWords.toArray(new String[matchedWords.size()]);
        }
    }
    private int match(String s1, String s2) {
        int match = 0;
        
        for(int i = 0; i < WORD_LENGTH; i++) {
            if(s1.charAt(i) == s2.charAt(i)) match++;
        }
        return match;
    }
}