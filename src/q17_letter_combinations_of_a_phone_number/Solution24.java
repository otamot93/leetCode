package q17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

public class Solution24 {
    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits, 0);
    }

    private List<String> letterCombinations(String digits,int index){

        char[][] letters  = new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> result = new ArrayList<>();
        if(index > digits.length()-1){
            return result;
        }
        List<String> subResult = letterCombinations(digits,index+1);
        for(char letter: letters[Integer.parseInt(digits.charAt(index)+"")]){
            if(subResult.size() >0){
                for(String sub: subResult){
                    result.add(letter+sub);
                }
            }else{
                result.add(letter+"");
            }

        }
        return result;

    }

    public static void main(String[] args) {
        List<String> letters = new Solution24().letterCombinations("3");
        for(String letter: letters){
            System.out.println(letter);
        }
    }
}
