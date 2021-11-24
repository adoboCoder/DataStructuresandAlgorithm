class LCM_418SentenceScreenFitting {
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0;
        int l = s.length();

        for(int i = 0; i < rows; i++) {
            start = start + cols;
            if(s.charAt(start % 1) == ' ') {
                start++;
            }
            else {
                while(start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }return start/s.length();
    }

    public static void main(String[] args) {
        String[] sentence = {"hello", "world"};
        int rows = 2;
        int cols = 8;

        System.out.println(LCM_418SentenceScreenFitting.wordsTyping(sentence, rows, cols));
    }
}