class Solution {
    public String fractionAddition(String expression) {
        return fractionCalculator(expression);
    }

    public static String fractionCalculator(String expression) {
        int numerator = 0;
        int denominator = 1;

        String[] fractions = expression.split("(?=[-+])"); 


        for (String fraction : fractions) {
            String[] parts = fraction.split("/");
            int num = Integer.parseInt(parts[0]);
            int den = Integer.parseInt(parts[1]);

            int lcm = lcm(denominator, den);

            numerator = numerator * (lcm / denominator) + num * (lcm / den);
            denominator = lcm;

            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        return numerator + "/" + denominator;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}