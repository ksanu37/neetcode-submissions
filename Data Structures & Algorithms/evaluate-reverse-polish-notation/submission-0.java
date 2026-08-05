class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = Set.of("+", "-", "*", "/");
        Stack<Integer> st = new Stack<>();

        for(String s: tokens) {
            if(operators.contains(s)) {
                int num1 = st.pop();
                int num2 = st.pop();
                int res = calculate(num1, num2, s);
                st.push(res);
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }

    public int calculate(int num1, int num2, String operator) {
        if(operator.equals("+")) {
            return num2 + num1;
        }
         if(operator.equals("-")) {
            return num2 - num1;
        }
         if(operator.equals("*")) {
            return num2 * num1;
        }
        return num2 / num1;
    }
}
