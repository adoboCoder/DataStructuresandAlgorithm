import java.util.*;

class LCM_299BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(char c : secret.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < secret.length(); i++) {
            char charSecret = secret.charAt(i);
            char charGuess = guess.charAt(i);

            if(charSecret == charGuess) {
                bulls++;
                if(map.containsKey(charSecret)) {
                    updateMap(map, charSecret);
                    cows++;
                }
            }
            else {
                if(map.containsKey(charGuess)) {
                    updateMap(map, charGuess);
                    cows++;
                }
            }
        }
        return bulls + "A" + (cows - bulls) + "B";
    }

    private static void updateMap(Map<Character, Integer> map, char c) {
        map.put(c, map.get(c) - 1);
        if(map.get(c) == 0) {
            map.remove(c);
        }
    }

    public static void main(String[] args) {
        System.out.println(LCM_299BullsAndCows.getHint("1807","7810"));
        System.out.println(LCM_299BullsAndCows.getHint("1123","0111"));
        System.out.println(LCM_299BullsAndCows.getHint("1","0"));
    }
}