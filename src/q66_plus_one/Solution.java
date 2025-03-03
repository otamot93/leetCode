package q66_plus_one;

/**
 * @author ：hezc
 * @date ：Created in 2024/9/5 20:20
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean plusOne = true;
        int  i = digits.length-1;
        while(plusOne && i >=0){
            int result = digits[i]+1;
            digits[i] = result %10;
            plusOne = result == 10;
            i--;
        }
        if(plusOne){
            int[] newDigits = new int[digits.length+1];
            System.arraycopy(digits,0,newDigits,1,digits.length);
            newDigits[0] = 1;
            return newDigits;
        } else{
            return digits;
        }

    }
}
