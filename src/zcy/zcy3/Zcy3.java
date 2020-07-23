package zcy.zcy3;

import java.util.Scanner;

/**
 * @author YangQi
 * @date 2020/7/21 9:51 下午
 */
public class Zcy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //前一半从最后一个数开始以2递减
        for (int i = n - 1; i >= 0; i = i - 2) {
            System.out.print(arr[i] + " ");
        }
        //后一半根据整数个数的奇偶分别从A[1]和A[0]开始
        for (int i = n % 2; i <= n - 2; i = i + 2) {
            System.out.print(arr[i] + " ");
        }
    }
}
