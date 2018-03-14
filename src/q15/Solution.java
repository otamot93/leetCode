package q15;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = new int[3];
        numbers[0] = 0;
        numbers[1] = 0;
        numbers[2] = 0;

        List<List<Integer>> result = new Solution().threeSum(numbers);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i <nums.length-2 ; i++) {//从第一个到倒数第三个
            int second = i+1;
            int third = nums.length-1;//最后一个
            if(i==0||(i>0 && nums[i] != nums[i-1])){//避免循环得下一个和上一个数字一样，除非是第一个数字
                while(second<third){
                    if(nums[i]+nums[second]+nums[third]==0){//相等
                        List<Integer>  temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[second]);
                        temp.add(nums[third]);
                        res.add(temp);
                        while(second<third && nums[second+1]==nums[second] ){//下一个如何和second一样，就跳过去
                            second++;
                        }
                        while(second<third && nums[third-1]== nums[third]){//thrid得上一个和thrid一样得话，就跳过
                            third--;
                        }
                        second++;
                        third--;
                    }else if(nums[second]+nums[third]<0-nums[i]){//比预期目标小，左指针变大
                        second++;
                    }else{
                        third--;
                    }
                }
            }
        }
        return res;
    }
}
