package q28;

public class Solution {
    public static void main(String[] args) {
        int result = new Solution().strStr("2issipi1","issipi");
        System.out.println(result);
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(haystack.length() == 0){
            return -1;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }

        int i = 0;
        while(i <= (haystack.length()-needle.length())){
            int j = 0;
            while(j < needle.length()){
                if(haystack.charAt(i+j) == needle.charAt(j)){
                    j++;
                }else{
                    break;
                }
            }
            if(j == (needle.length())){
                return i;
            }
            i++;
        }
        return -1;
//        byte[] hByte = haystack.getBytes();
//        byte[] nByte = needle.getBytes();
//        for (int i = 0; i <hByte.length ; i++) {
//            if(hByte.length-i <nByte.length){//剩下字符串比目标串要短
//                break;
//            }
//            if(hByte[i] == nByte[0]){//第一个字相同，则继续比较
//                int j = 1;
//                for(j = 1;j<nByte.length;j++){
//                    if((i+j)> hByte.length-1){
//                        break;
//                    }
//                    if(hByte[i+j] != nByte[j]){
//                        break;
//                    }
//                }
//                if(j == nByte.length){
//                    return i;
//                }
//            }
//        }

        //找不到
//        return -1;
    }
}
