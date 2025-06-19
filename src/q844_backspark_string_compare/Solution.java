package q844_backspark_string_compare;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int sIndex = validIndex(sArray);
        int tIndex = validIndex(tArray);
        if(sIndex != tIndex){
            return false;
        }

        for(int i = 0;i<= sIndex;i++){
            if(sArray[i] != tArray[i]){
                return false;
            }
        }
        return true;
        
    }

    int validIndex(char[] s){
        int sSlow = 0;
        int sFast = 0;
        while(sFast < s.length){
            if(s[sFast] == '#'){
                sSlow--;
                if(sSlow < 0 ){
                    sSlow =0;
                }
            }else{
                s[sSlow] = s[sFast];
                sSlow++;
            }
     
            sFast++;
        }
        return --sSlow;
    }

    // void swap(char[] s,int i,int j){
    //     char tmp = s[i];
    //     s[i] = s[j];
    //     s[j] = tmp;
    // }

    public static void main(String[] args) {
        Deque a = new ArrayDeque<>();
        a.pee
        boolean result = new Solution().backspaceCompare("a#c", "b");
        System.out.println(result);
    }
}
