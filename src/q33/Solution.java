package q33;

public class Solution {
    public static void main(String[] args) {
        int[] nums =  new int[]{4,5,6,7,0,1,2};
        int result = new Solution().search(new int[]{1},2);
        System.out.println(result);
    }
    public int search(int[] nums,int target){
        if(nums.length==0){
            return -1;
        }
        //target是否比数组第一个大
        if(target>=nums[0]){
            //正面循环
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]== target){
                    return i;
                }
                //判断下一个
                if(!(i<nums.length-1 && nums[i+1]>nums[i])){
                    break;
                }
            }
            return -1;
        }else if(target<=nums[nums.length-1]){//比最后一个小
            for (int i = nums.length-1; i >=0 ; i--) {
                if(nums[i]==target){
                    return i;
                }
                //判断下一个
                if(!(i>0 && nums[i-1]<nums[i])){
                    break;
                }
            }
            return -1;
        }else{
            return -1;
        }

    }
}
