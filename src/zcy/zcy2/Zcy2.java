package zcy.zcy2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YangQi
 * @date 2020/7/21 8:39 下午
 */
public class Zcy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }
            Arrays.sort(ints);
            int count = 0;
            for (int i = 0; i < n-2; i++) {
                for (int j = i+1; j < n-1; j++) {
                    for (int k = j+1; k < n; k++) {
                        if (ints[i] + ints[j] > ints[k]){
                            count++;
                        }else {
                            break;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
