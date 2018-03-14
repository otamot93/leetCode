package q18;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = new int[8];
        numbers[0] = -1;
        numbers[1] =-5;
        numbers[2] = -5;
        numbers[3] = -3;
        numbers[4] = 2;
        numbers[5] = 5;
        numbers[6] = 0;
        numbers[7] = 4;
        List<List<Integer>> finalResult = new Solution().fourSum(numbers,-7);
        System.out.println(finalResult);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<4){
            return res;
        }
        //排序
        Arrays.sort(nums);

        for (int i = 0; i <nums.length-3 ; i++) {
            //如果循环到数值和上一个是一致得，就跳过，除非是第一个
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int tempTarget = target-nums[i];
            List<List<Integer>> tempList = this.threeSum(Arrays.copyOfRange(nums,i+1,nums.length),tempTarget);
            //循环加入最终结果
            Iterator<List<Integer>> iterable = tempList.iterator();
            while(iterable.hasNext()){
                List<Integer> temp =  iterable.next();
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums,int target){
        //先排序
//        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i <nums.length-2 ; i++) {//从第一个到倒数第三个
            int second = i+1;
            int third = nums.length-1;//最后一个
            if(i==0||(i>0 && nums[i] != nums[i-1])){//避免循环得下一个和上一个数字一样，除非是第一个数字
                while(second<third){
                    if(nums[i]+nums[second]+nums[third]==target){//相等
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
                    }else if(nums[second]+nums[third]<target-nums[i]){//比预期目标小，左指针变大
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
