package Beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 12/26/24
 *  @see <a href="https://www.acmicpc.net/problem/11725" />
 *  @mem 77044 KB
 *  @time 640 ms
 *  @caution tree 문제
*/
public class Main_B_11725_트리의부모찾기 {
    static FastReader scan = new FastReader();
    static int n;
    static ArrayList<Integer> tree [];
    static int map [];
    static StringBuilder sb = new StringBuilder();

    static void input() {
        n = scan.nextInt();

        // 인접 리스트 구성하기
        tree = new ArrayList[n+1];
        map = new int[n+1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
    }

    // dfs(x, par) := 정점 x 의 부모가 per 였고, x의 children들을 찾아주는 함수
    static void dfs(int x, int par) {
        for (int y : tree[x]) {
            if (y == par) continue;
            map[y] = x;
            dfs(y, x);
        }
    }

    static void pro() {
        dfs(1, -1);
        for (int i = 2; i <= n; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.println(sb);
    }

    // Main
    public static void main(String[] args) {
        input();
        pro();
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
