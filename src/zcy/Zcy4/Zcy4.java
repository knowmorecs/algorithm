package zcy.Zcy4;

import java.util.Scanner;

/**
 * @author YangQi
 * @date 2020/7/23 8:24 下午
 */
public class Zcy4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int len1 = str1.length();
        int len2 = str2.length();
        boolean[][] flag = new boolean[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)){
                    flag[i][j] = true;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int len = 0;
                int n = i;
                int m = j;
                while (n < len1 && m < len2 && flag[n++][m++] == true){
                    len++;
                }
                if (len > max){
                    max = len;
                }
            }
        }
        System.out.println(max);
    }
}
