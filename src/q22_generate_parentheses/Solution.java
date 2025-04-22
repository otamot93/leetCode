package q22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> parentheses = new Solution().generateParenthesis(3);
        for(String parenthesis: parentheses){
            System.out.println(parenthesis);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> finalResult = new ArrayList<>();
        getParenthesis(finalResult,n,n,"");
        return finalResult;
    }
    public void  getParenthesis(List<String>finalResult ,int left,int right,String temp){
        if(left ==0 && right == 0){
            finalResult.add(temp);
            return;
        }
        if(left>0){
            getParenthesis(finalResult,left-1,right,temp+"(");
        }
        if(right>left){
            getParenthesis(finalResult,left,right-1,temp+")");
        }
    }
}
