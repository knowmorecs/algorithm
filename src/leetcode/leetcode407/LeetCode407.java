package leetcode.leetcode407;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author YangQi
 * @date 2020/7/25 2:16 下午
 */
public class LeetCode407 {
    static class Node {
        int value;
        int row;
        int col;

        public Node(int v, int r, int c) {
            this.value = v;
            this.row = r;
            this.col = c;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int row = heightMap.length;
        int col = heightMap[0].length;
        PriorityQueue<Node> heap = new PriorityQueue(new NodeComparator());
        boolean[][] isEnter = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            isEnter[0][i] = true;
            heap.add(new Node(heightMap[0][i], 0, i));
        }
        for (int i = 1; i < row; i++) {
            isEnter[i][col - 1] = true;
            heap.add(new Node(heightMap[i][col - 1], i, col - 1));
        }
        for (int i = col - 2; i >= 0; i--) {
            isEnter[row - 1][i] = true;
            heap.add(new Node(heightMap[row - 1][i], row - 1, i));
        }
        for (int i = 1; i < row - 1; i++) {
            isEnter[i][0] = true;
            heap.add(new Node(heightMap[i][0], i, 0));
        }
        //每个位置的水量，累加到water上去
        int water = 0;
        //在每个node弹出的时候，如果更大，则更新max的值，否则维持max的值不变
        int max = 0;
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            max = Math.max(max, cur.value);
            int r = cur.row;
            int c = cur.col;
            int value = 0;
            if (r > 0 && !isEnter[r - 1][c]) {
                value = heightMap[r - 1][c];
                water += Math.max(0, max - value);
                isEnter[r - 1][c] = true;
                heap.add(new Node(heightMap[r - 1][c], r - 1, c));
            }
            if (r < row - 1 && !isEnter[r + 1][c]) {
                value = heightMap[r + 1][c];
                water += Math.max(0, max - value);
                isEnter[r + 1][c] = true;
                heap.add(new Node(heightMap[r + 1][c], r + 1, c));
            }
            if (c > 0 && !isEnter[r][c - 1]) {
                value = heightMap[r][c - 1];
                water += Math.max(0, max - value);
                isEnter[r][c - 1] = true;
                heap.add(new Node(heightMap[r][c - 1], r, c - 1));
            }
            if (c < col - 1 && !isEnter[r][c + 1]) {
                value = heightMap[r][c + 1];
                water += Math.max(0, max - value);
                isEnter[r][c + 1] = true;
                heap.add(new Node(heightMap[r][c + 1], r, c + 1));
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        LeetCode407 leetCode407 = new LeetCode407();
        System.out.println(leetCode407.trapRainWater(arr));
    }
}