public class Solution {
        private String[] lessThanTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", 
                                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        private String [] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords (int number){
        if (number == 0){
            return "Zero";
        }
        int i = 0;
        String words = "";

        while(number > 0){
            if(number % 1000 != 0){
                words = helper (number % 1000) + thousands[i] + " " + words;
            }
            number = number / 1000;
            i++;
        }
        return words. trim();
    }
    
    private String helper (int number){
        if (number == 0) return "";
        else if (number < 20 )
            return lessThanTwenty[number] + " ";
        else if(number < 100)
            return tens[number / 10] + " " + helper(number % 10 );
        else 
            return lessThanTwenty[number / 100] + " Hundred " + helper(number % 100);
        
    }
}