package q4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 总数是否是偶数
        boolean isEven = (nums1.length+nums2.length)%2==0;
        // 已计数数量
        int countedNumber = 0;
        // target
        int allCount = nums1.length+nums2.length;
        int target = allCount==1 ? 1:(int)(Math.ceil(allCount / 2.0));
        // 声明两个指针
        int i = 0,j=0;
        while(i<nums1.length || j<nums2.length){
            // 取第一个数组的情况
            int targetNumber;
            if((i<=(nums1.length-1) && j<= (nums2.length-1) && nums1[i]<=nums2[j])|| j==(nums2.length) ){
                targetNumber = nums1[i];
                i++;

            }else{
                targetNumber = nums2[j];
                j++;
            }
            countedNumber++;
            if(countedNumber==target){
                // 奇数偶数
                if(isEven){
                        int another;
                        //再取一个
                        if((i<=(nums1.length-1) && j<= (nums2.length-1) && nums1[i]<=nums2[j])|| j==(nums2.length) ){
                            return (nums1[i++]+targetNumber)/2.0;
                    }else{
                        return (nums2[j++]+targetNumber)/2.0;
                    }
                }else{
                    return targetNumber;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }
}
