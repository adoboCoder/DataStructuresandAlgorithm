class LCE_1189MaximumNumbersOfBalloons {
    public static int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        
        for(char c : text.toCharArray()){
            freq[c - 'a']++;
        }
        // balloon => b:2, a:1, l:2, o:2, n:1

        int min = freq[1];//for b
        min = Math.min(min, freq[0]);//for 'a'
        min = Math.min(min, freq[11] / 2);// for 'l' /2 
        min = Math.min(min, freq[14] / 2);//similarly for 'o' /2
        min = Math.min(min, freq[13]);//for 'n'
        return min;
    }
    public static void main(String[] args) {
        System.out.println(LCE_1189MaximumNumbersOfBalloons.maxNumberOfBalloons("nlaebolko"));
        System.out.println(LCE_1189MaximumNumbersOfBalloons.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(LCE_1189MaximumNumbersOfBalloons.maxNumberOfBalloons("leetcode"));
    }
}