package q6;

public class Solution {
    public static void main(String[] args) {
        String str = new Solution().convert("abcdefghigk",4);
        System.out.println(str);
    }
    public String convert(String s, int numRows) {
//        char[] arr = s.toCharArray();
//        boolean flag = true;//正向
//        Map<Integer,String> map = new HashMap<>();
//        int count=1;//计数
//        for (int i = 0; i <arr.length ; i++) {
//            Integer key = count;
//            String old = map.getOrDefault(key,"");
//            map.put(key,old+arr[i]);
//            if(numRows>1){
//                if(flag){
//                    count++;
//                }else{
//                    count--;
//                }
//            }
//
//            if(count==numRows){
//                flag=false;
//            }
//            if(count== 1){
//                flag = true;
//            }
//        }
//        String result = "";
//        for(int i = 1;i<=numRows;i++){
//            String str = map.getOrDefault(i,"");
//            result+=str;
//        }
//        return result;

        int len = s.length();
        if (len == 0 || numRows < 2) return s;

        String ret = "";
        int lag = 2*numRows - 2; //循环周期
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += lag) {
                ret += s.charAt(j);

                //非首行和末行时还要加一个
                if (i > 0 && i < numRows-1) {
                    int t = j + lag - 2*i;
                    if (t < len) {
                        ret += s.charAt(t);
                    }
                }
            }
        }
        return ret;
    }
}
