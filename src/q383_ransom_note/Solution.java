package q383_ransom_note;

import java.util.HashMap;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/11 17:01
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i=0;i<ransomNote.length();i++) {
            if(hashMap.containsKey(ransomNote.charAt(i))){
                hashMap.put(ransomNote.charAt(i),hashMap.get(ransomNote.charAt(i))+1);
            }else{
                hashMap.put(ransomNote.charAt(i),1);
            }
        }

        // 遍历magazine清除
        for (int i=0;i < magazine.length();i++){
            char c = magazine.charAt(i);
            if(hashMap.containsKey(c)){
                int count = hashMap.get(c);
                if(--count == 0){
                    hashMap.remove(c);
                }else{
                    hashMap.put(c,count);
                }
            }

        }

        return hashMap.size()  == 0;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "c";
        boolean canConstruct = new Solution().canConstruct(ransomNote,magazine);
        System.out.println(canConstruct);
    }
}
