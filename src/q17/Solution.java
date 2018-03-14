package q17;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> finalResult = new Solution().letterCombinations("7");
        System.out.println(finalResult);
    }
    public List<String> letterCombinations(String digits) {
        String[] numbers = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> finalResult = new LinkedList<>();
        for (int i = 0; i < digits.length() ; i++) {
            List<String> temp = new LinkedList<>();
            int x = Integer.parseInt(digits.substring(i,i+1));
            if(finalResult.isEmpty()){//空的
                for (int j = 0; j <numbers[x].length() ; j++) {
                    temp.add(String.valueOf(numbers[x].charAt(j)));
                }
            }else{
                Iterator<String> iterator = finalResult.iterator();
                while(iterator.hasNext()){
                    String tempString = iterator.next();
                    for (int j = 0; j <numbers[x].length() ; j++) {
                        temp.add(tempString+String.valueOf(numbers[x].charAt(j)));
                    }
                }
            }
            finalResult = temp;
        }
        return finalResult;
    }
}
