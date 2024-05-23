package q50_pow;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/20 10:35
 * @description：pow
 * @version: 1.0.0
 */
public class Solution {
    public double myPow(double x, int n) {
        double result = 1.0; // 初始化结果为1.0

        // 处理负指数的情况
        boolean isNegative = (n < 0);
        long num = n;
        if (isNegative) {
            num = -num; // 将n转换为正数
        }

        // 快速幂算法
        while (num > 0) {
            // 如果n是奇数，就将x乘到结果中
            if ((num & 1) == 1) {
                result *= x;
            }
            // 将x平方
            x *= x;
            // 将n除以2，去掉最低位
            num >>= 1;
        }

        // 如果原始指数是负数，返回结果的倒数
        return isNegative ? 1.0 / result : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double v = solution.myPow(2.0, -2147483648);
        System.out.println(v);

    }
}
