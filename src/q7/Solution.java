package q7;

public class Solution {
    public static void main(String[] args) {
        int i = new Solution().reverse(-2147483648);
        System.out.println(i);
    }

    public int reverse(int x) {
        boolean isNegativeNumber = x<0;
        Long newNumber = isNegativeNumber?0-Long.valueOf(x):Long.valueOf(x);
        String target = new StringBuilder(String.valueOf(newNumber)).reverse().toString();
        if(Long.valueOf(target)>Integer.MAX_VALUE){
            return 0;
        }
        int number = Integer.valueOf(target);

        return isNegativeNumber?0-number:number;
    }
}
