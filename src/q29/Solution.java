package q29;

public class Solution {
    //@todo
    public static void main(String[] args) {
        int result = new Solution().divide(-2147483648,1);
        System.out.println(result);
    }

    public int divide(int dividend,int divisor) {
        boolean positive = (dividend < 0) == (divisor < 0);
        dividend = Math.abs(dividend);//取绝对值
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend > divisor) {
            int temp = divisor;
            int i = 1;
            while (dividend >= temp) {
                dividend -= temp;
                result += 1;
                i <<= i;
                temp <<= i;
            }
        }
        if(!positive){
            result = -result;
        }
        return Math.min(Math.max(-2147483648,result),2147483647);
    }
}
