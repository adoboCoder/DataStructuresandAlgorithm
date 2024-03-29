class Solution{
    public String addStrings(String num1, String num2){
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
    
        while( i >= 0 || j >= 0 || carry != 0){
            if(i >= 0){
                carry = carry + num1.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                carry = carry + num2.charAt(j) - '0';
                j--;
            }

            sb.append(carry % 10);
            carry = carry / 10;
        }
        return sb.reverse().toString();
    }
}
/*
TC O(max(n1, n2))
SC O(max(n1, n2))
*/