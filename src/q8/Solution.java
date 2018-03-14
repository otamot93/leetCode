package q8;

public class Solution {
    public static void main(String[] args) {
        int x = new Solution().myAtoi("");
        System.out.println(x);
    }

    public int myAtoi(String str) {

        //去除空白字符串
        str = str.trim();
        if(str.length()<1){
            return 0;
        }
        //通过第一个字符判断是正数还是负数
        int i = 0;
        boolean positive = true;
        if(str.charAt(i) == '+'){
            i++;
        }else if(str.charAt(i)=='-'){
            i++;
            positive = false;
        }
        double temp = 0;//使用double，避免字符串数值太大超出范围
        //运算数值
        for (; i <str.length() ; i++) {
            if(str.charAt(i) - '0' >9 || str.charAt(i)-'0' < 0){//存在不是数字的，停止
                break;
            }
            if(positive){//正数
                temp = temp*10+(str.charAt(i)-'0');
                if(temp>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else{
                temp = temp*10-(str.charAt(i)-'0');
                if(temp < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int)temp;
    }
}
