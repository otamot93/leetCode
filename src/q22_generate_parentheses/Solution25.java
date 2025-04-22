package q22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution25 {
    public List<String> generateParenthesis(int n) {
        List<String> res =new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        backtrace(res, temp, 0, 0, n);
        return res;
    }

    private void backtrace(List<String> res,StringBuilder tmp,int open ,int close,int n){
        if(tmp.length() == 2*n){
            res.add(tmp.toString());
            return;
        }
        if(open < n){
            tmp.append("(");
            backtrace(res, tmp, open+1, close, n);
            tmp.deleteCharAt(tmp.length()-1);
        }
        if(close < open){
            tmp.append(")");
            backtrace(res, tmp, open, close+1, n);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> parentheses = new Solution25().generateParenthesis(3);
        for(String parenthesis: parentheses){
            System.out.println(parenthesis);
        }
    }
}
