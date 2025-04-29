package q162_find_peak_element;

/**
 * 二分
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;int right = nums.length-1;
        int ans = 0;

        while(left <= right){
            int mid = (left+right)/2;
            if(compare(nums,mid-1,mid) < 0 && compare(nums,mid,mid+1) > 0){
                ans = mid;
                break;
            }
            if(compare(nums,mid,mid+1) < 0){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }


        return ans;
    }

    // x > y 返回1
    private int compare(int[] nums, int x,int y){
        if(x < 0 || x > nums.length-1){
            return -1;
        }
        if(y < 0 || y> nums.length-1){
            return 1;
        }
        return nums[x] > nums[y] ? 1:-1;
        
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int peakIndex = new Solution().findPeakElement(nums);
        System.out.println(peakIndex);
    }


}
