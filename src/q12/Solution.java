package q12;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String str = new Solution().intToRoman(300);
        System.out.println(str);
    }
    public String intToRoman(int num) {
        String[][] roma= {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        String result = "";
        result+=roma[3][(num/1000)%10];
        result+=roma[2][(num/100)%10];
        result+=roma[1][(num/10)%10];
        result+=roma[0][num%10];

        return result;
    }
}
