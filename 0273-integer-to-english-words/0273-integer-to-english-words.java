public class Solution {

    // Arrays to hold number words
    private static final String[] words0To19 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] wordsTens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] wordsLargerNumbers = {
        "Hundred", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int index = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result = numberToWordsBelow1000(num % 1000) + (index == 0 ? "" : wordsLargerNumbers[index]) + " " + result;
            }
            num /= 1000;
            index++;
        }

        return result.trim();
    }

    // Helper function to handle numbers below 1000
    private String numberToWordsBelow1000(int n) {
        if (n == 0) return "";
        else if (n < 20) return words0To19[n] + " ";
        else if (n < 100) return wordsTens[n / 10] + " " + numberToWordsBelow1000(n % 10);
        else return words0To19[n / 100] + " Hundred " + numberToWordsBelow1000(n % 100);
    }
}
