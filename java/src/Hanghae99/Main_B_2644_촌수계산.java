package Hanghae99;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/4/24
 *  @see <a href="https://www.acmicpc.net/problem/2644" />
 *  @mem 14156 KB
 *  @time 104 ms
 *  @caution bfs 문제
*/
public class Main_B_2644_촌수계산 {

    static int N, M, num1, num2;
    static List<Integer> map [];
    static class Node {
        int num;
        int from;
        int count;

        public Node(int num, int from, int count) {
            this.num = num;
            this.from = from;
            this.count = count;
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        num1 = scan.nextInt();
        num2 = scan.nextInt();
        M = scan.nextInt();
        map = new ArrayList [N + 1];
        for (int i = 0; i <= N; i++) map[i] = new ArrayList<>();
        int x, y;
        for (int i = 0; i < M; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            map[x].add(y);
            map[y].add(x);
        }
    }

    static void bfs() {
        LinkedList<Node> queue = new LinkedList<>();
        int result = -1;

        queue.add(new Node(num1, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.num == num2) { // 탈출 조건
                result = node.count;
                break;
            }
            for(int next : map[node.num]) {
                if(node.from != next) {
                    queue.add(new Node(next, node.num, node.count+1));
                }
            }
        }
        System.out.println(result);
    }

    // Main
    public static void main(String[] args) {
        input();
        bfs();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
