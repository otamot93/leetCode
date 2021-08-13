package q233;

public class Solution {
    public int countDigitOne(int n) {
        int num = n;
        // 每位上1个数
        int oneInBit = 1;
        int count = 0;
        while(num != 0){
            if(num <10 && num >1){
                //该位数所有1都已经存在
                count += oneInBit;
            }else if(num == 1){
                count += (n-oneInBit+1);
            }else{
                // 循环次数,比如125，先获取个数上出现1的次数，循环次数为12，位数为5，则个位出现1的次数为12
                int repeatCount = num/10;
                int lastNumber = num%10;
                count += repeatCount*oneInBit;
                if(lastNumber > 1){
                    count += oneInBit;
                }else if(lastNumber==1){
                    // 次位数
                    count += n%(oneInBit*10)-oneInBit+1;
                }

            }
            num /= 10;
            oneInBit*=10;


        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(13));
    }
}
