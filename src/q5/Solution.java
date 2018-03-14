package q5;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String finalString = new Solution().longestPalindrome("abc");
        System.out.println(finalString);
    }
    public String longestPalindrome(String s){
        char[] arr = s.toCharArray();
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = arr.length-1; i<j; j--) {
                int tempX = i;
                int tempY = j;
                boolean wrong = false;
                while(tempX<=tempY){
                    if(arr[tempX] == arr[tempY]){
                        tempX++;
                        tempY--;
                    }else{
                        wrong = true;
                        break;
                    }
                }
                if(!wrong){//回文
                    if((j-i)>(maxY-maxX)){
                        maxX = i;
                        maxY = j;
                    }
                }
            }
        }
        return s.substring(maxX,maxY+1);
    }
}
