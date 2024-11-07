package Hanghae99;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/7/24
 *  @see <a href="https://www.acmicpc.net/problem/25195" />
 *  @mem 72908 KB
 *  @time 568 ms
 *  @caution bfs 문제
*/
public class Main_B_25195_YESoryes {
    static FastReader scan = new FastReader();
    static int N, M, S;
    static boolean isYes;
    static List<Integer>[] edges;
    static List<Integer> fanclub;

    static class Node {
        int num;
        boolean yes;

        public Node(int num, boolean yes) {
            this.num = num;
            this.yes = yes;
        }
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        isYes = false;
        edges = new ArrayList [N + 1];
        for (int i = 0; i <= N; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            edges[u].add(v); // 방향이 존재.
        }
        fanclub = new ArrayList<>();
        S = scan.nextInt();
        for (int i = 0; i < S; i++) fanclub.add(scan.nextInt());
    }

    static void bfs() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(1, fanclub.contains(1)));

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            int frontNum = front.num;
            // 끝점인가 확인
            if(edges[frontNum].size() == 0) {
                // 한경우라도 끝점까지 가는데 한번도 팬클럽을 만나지 않은 경우.
                if(!front.yes) {
                    System.out.println("yes");
                    return;
                }
            }
            for(int nextNum : edges[frontNum]) {
                Node nextNode = new Node(nextNum, front.yes || fanclub.contains(nextNum));
                queue.add(nextNode);
            }
        }
        System.out.println("Yes");
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
