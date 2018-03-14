package q13;

public class Solution {
    public static void main(String[] args) {
        int x = new Solution().romanToInt("DCXXI");
        System.out.println(x);
    }
    public int romanToInt(String s){
        int finalResult = 0;
        for (int i = 0; i <s.length() ; i++) {
            switch (s.charAt(i)){
                case 'I':{
                    //如果i不是最后一个，需要考虑下后面一个数是否为V或者X
                    if(i!=s.length()-1 && (s.charAt(i+1)=='V'|| s.charAt(i+1)=='X')){
                        break;//交给下一个字符来处理
                    }
                    finalResult+=1;
                    break;
                }
                case 'V':{
                    finalResult +=5;
                    //判断如果i不是第一个，需要考虑前面的字符是否为I
                    if(i!=0 && (s.charAt(i-1)=='I')){
                        finalResult-=1;
                    }
                    break;
                }
                case 'X':{
                    //判断如果i不是第一个，需要考虑前面的字符是否为I
                    if(i!=0 && (s.charAt(i-1)=='I')){
                        finalResult-=1;
                    }
                    if(i!=s.length()-1 && (s.charAt(i+1)=='L'|| s.charAt(i+1)=='C')){
                        break;//交给下一个字符来处理
                    }
                    finalResult+=10;
                    break;

                }
                case 'L':{
                    finalResult +=50;
                    //判断如果i不是第一个，需要考虑前面的字符是否为X
                    if(i!=0 && (s.charAt(i-1)=='X')){
                        finalResult-=10;
                    }
                    break;
                }
                case 'C':{
                    //判断如果i不是第一个，需要考虑前面的字符是否为I
                    if(i!=0 && (s.charAt(i-1)=='X')){
                        finalResult-=10;
                    }
                    if(i!=s.length()-1 && (s.charAt(i+1)=='D'|| s.charAt(i+1)=='M')){
                        break;//交给下一个字符来处理
                    }
                    finalResult+=100;
                    break;
                }
                case 'D':{
                    finalResult +=500;
                    //判断如果i不是第一个，需要考虑前面的字符是否为X
                    if(i!=0 && (s.charAt(i-1)=='C')){
                        finalResult-=100;
                    }
                    break;
                }
                case 'M':{
                    finalResult +=1000;
                    //判断如果i不是第一个，需要考虑前面的字符是否为X
                    if(i!=0 && (s.charAt(i-1)=='C')){
                        finalResult-=100;
                    }
                    break;
                }
                default:{

                }
            }
        }
        return finalResult;
    }

}
