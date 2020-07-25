package leetcode.leetcode42;

/**
 * @author YangQi
 * @date 2020/7/25 3:34 下午
 */
public class LeetCode42 {
    public int trap(int[] height) {
        if(height.length == 0 || height == null){
            return 0;
        }
        int left = 0;
        int right = height.length;
        int leftMax = height[0];
        int rightMax = height[right-1];
        int water = 0;
        left++;
        right--;
        while(left <= right){
            if(leftMax <= rightMax){
                leftMax = Math.max(leftMax, height[left]);
                water += Math.max(0, leftMax-height[left]);
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                water += Math.max(0, rightMax-height[right]);
                right--;
            }
        }
        return water;
    }
}
