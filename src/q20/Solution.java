package q20;

public class Solution {
    public static void main(String[] args) {
        Boolean isValid = new Solution().isValid("]");
        System.out.println(isValid);
    }

    /**
     * https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
     * 智商压制
     * @param s
     * @return
     */
    public boolean isValid(String s){
        //声明一个暂存仓库，能满足后入先出简单点选用数组
        char [] array = new char[s.length()];
        int arrayLength = 0;
        for (int i = 0; i <s.length() ; i++) {
            char current = s.charAt(i);
            switch(current){
                case '[':{}
                case '(':{}
                case '{':{
                    array[arrayLength] = current;
                    arrayLength++;
                    break;
                }
                case ']':{
                    if(arrayLength==0){
                        return false;
                    }
                    if(array[arrayLength-1] == '['){
                        arrayLength--;
                    }else{
                        array[arrayLength] = current;
                        arrayLength++;
                        //继续加
                    }
                    break;
                }
                case ')':{
                    if(arrayLength==0){
                        return false;
                    }
                    if(array[arrayLength-1] == '('){
                        arrayLength--;
                    }else{
                        array[arrayLength] = current;
                        arrayLength++;
                        //继续加
                    }
                    break;
                }
                case '}':{
                    if(arrayLength==0){
                        return false;
                    }
                    if(array[arrayLength-1] == '{'){
                        arrayLength--;
                    }else{
                        array[arrayLength] = current;
                        arrayLength++;
                        //继续加
                    }
                    break;
                }
            }
        }
        return arrayLength == 0;
    }
}
