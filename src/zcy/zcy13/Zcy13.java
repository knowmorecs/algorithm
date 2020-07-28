package zcy.zcy13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author knowmoreCS
 * @create 2020-07-28 20:50
 */
public class Zcy13 {
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
            }else if (arr[i] == arr[i-1]){
                left[i] = left[i-1];
            }
        }
        int count = left[n-1];
        for (int i = n-2; i >= 0; i--) {
            if(arr[i] > arr[i+1]){
                right[i] = right[i+1] + 1;
            }else if (arr[i] == arr[i+1]){
                right[i] = right[i+1];
            }
            count += Math.max(left[i], right[i]);
        }
        System.out.println(count);
    }
}
