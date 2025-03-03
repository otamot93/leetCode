package q11;

public class Solution {
    public static void main(String[] args) {
        int maxArea = new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(maxArea);
    }
    public int maxArea(int[] height) {
        if(height.length<2){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            max = Math.max(max,(height[left]>height[right]?height[right]:height[left])*(right-left));
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }

}
