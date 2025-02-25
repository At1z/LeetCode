class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(String token : tokens){
            if(isOperator(token)){
                int num2 = stack.pop();
                int num1 = stack.pop();
                
                stack.push(operation(num1, num2, token));
                System.out.println(operation(num1, num2, token));
            }else{
                
                stack.push(Integer.parseInt(token));
            }
        }
        res = stack.pop();
        return res;
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    } 
    
    public int operation(int num1, int num2, String token){
        if(token.equals("+")){
            return num1 + num2;
        }
        if(token.equals("-")){
            return num1 - num2;
        }
        if(token.equals("*")){
            return num1 * num2;
        }
        if(token.equals("/")){
            return num1 / num2;
        }
        
        return -1;
    }
}