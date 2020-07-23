package zcy.Zcy5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YangQi
 * @date 2020/7/23 9:01 下午
 */
public class Zcy5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[length];
        //numsCopy是nums变一次
        int[] numsCopy = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
            numsCopy[i] = nums[i];
        }
        int[][] dp = new int[2][length];
        //dp[0][i]表示i位置不改变一次的最长递增子串的长度，dp[1][i]表示i位置改变一次最长递增子串的长度
        dp[0][0] = 1;
        dp[1][0] = 1;
        int maxLength = 1;
        //以下为核心部分
        for (int i = 1; i < length; i++) {
            //不改变一次时最长递增子串的长度
            if (nums[i] > nums[i-1]){
                dp[0][i] = dp[0][i-1] + 1;
            }else {
                dp[0][i] = 1;
            }
            //改变一次最长递增子串的长度
            if (nums[i] > numsCopy[i-1]){
                //满足关系则dp[1][i-1] + 1
                dp[1][i] = dp[1][i-1] + 1;
            }else {
                //不满足关系则“从头开始”
                dp[1][i] = dp[0][i-1] + 1;
                //变成大1的数
                numsCopy[i] = nums[i-1] + 1;
            }
            maxLength = Math.max(maxLength, dp[1][i]);
        }
        System.out.println(maxLength);
    }
}
