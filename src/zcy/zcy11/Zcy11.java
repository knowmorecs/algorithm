package zcy.zcy11;

import java.util.Scanner;

/**
 * @author knowmoreCS
 * @create 2020-07-28 19:27
 */
public class Zcy11{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().trim().split(" ");
        double[] arr = new double[n];
        for(int i = 0; i < n; ++i){
            arr[i] = Double.parseDouble(str[i]);
        }
        double res = arr[0];
        double max = arr[0];
        double min = arr[0];
        for(int i = 1; i < n; i++){
            double curMax = max * arr[i];
            double curMin = min * arr[i];
            max = Math.max(Math.max(curMax, curMin), arr[i]);
            min = Math.min(Math.min(curMin, curMax), arr[i]);
            res = Math.max(res, max);
        }
        System.out.println(String.format("%.2f", res));
    }
}
