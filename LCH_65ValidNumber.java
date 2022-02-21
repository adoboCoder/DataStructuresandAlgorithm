class LCH_65ValidNumber {
    public static boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;

        for(int i = 0; i < s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen)
                    return false;
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen)
                    return false;
                numberSeen = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e')
                    return false;
            } else
                return false;
        }
        return numberSeen;
    }
    public static void main(String[] args) {
        String[] valid = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        for(String s : valid) {
            System.out.println(s + ": \t" + isNumber(s));
        }

        String[] invalid = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        for(String s : invalid) {
            System.out.println(s + ": \t" + isNumber(s));
        }
    }
}
/*

TC O(N)
SC O(1)
*/