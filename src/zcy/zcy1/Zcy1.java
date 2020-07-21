package zcy.zcy1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author YangQi
 * @date 2020/7/21 7:29 下午
 */
public class Zcy1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            List<String> list = new LinkedList<>();
            W: for (int i = 0; i < n; i++) {
                String t = scanner.next();
                for (String s : list){
                    if (s.contains(t) && s.length() == t.length()*2){
                        continue W;
                    }
                }
                list.add(t + t);
            }
            System.out.println(list.size());
        }
    }
}
