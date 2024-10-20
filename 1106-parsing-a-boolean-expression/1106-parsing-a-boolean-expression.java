class Solution {
    public boolean parseBoolExpr(String expression) {
        while (expression.length() > 1) {
            int subStart = Math.max(expression.lastIndexOf('!'), Math.max(expression.lastIndexOf('&'),expression.lastIndexOf('|')));
            int subEnd = expression.indexOf(')', subStart);
            String subExpr = expression.substring(subStart, subEnd + 1);
            char res = evaluateSubExpr(subExpr);
            expression = expression.substring(0, subStart) + res + expression.substring(subEnd + 1);
        }
        return expression.charAt(0) == 't';
    }
    private char evaluateSubExpr(String subExpr) {
        char operator = subExpr.charAt(0);
        String values = subExpr.substring(2, subExpr.length() - 1);
        if (operator == '!') {
            if (values.charAt(0) == 't') {
            return 'f';
            }else {
                return 't';
            }
        }
        if (operator == '&') {
            if (values.contains("f")) {
                return 'f';
            } else {
                return 't';
            }
        }
        if (operator == '|') {
            if (values.contains("t")) {
                return 't';
            } else {
                return 'f';
            }
        }
    return 'f';
    }
}