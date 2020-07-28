package zcy.zcy12;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author knowmoreCS
 * @create 2020-07-28 20:20
 * 左规则：当ratings B > ratings A时， B糖果比A糖果数量多
 * 右规则：当ratings A > ratings B时， A糖果比B糖果数量多
 * 相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
 */
public class Zcy12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().trim().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                left[i] = left[i-1] + 1;
            }
        }
        int count = left[n-1];
        for (int i = n-2; i >= 0; i--) {
            if(arr[i] > arr[i+1]){
                right[i] = right[i+1] + 1;
            }
            count += Math.max(left[i], right[i]);
        }
        System.out.println(count);
    }
}
