package Beakjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 1/13/25
 *  @see <a href="https://www.acmicpc.net/problem/2776" />
 *  @mem 289104 KB
 *  @time 1612 ms
 *  @caution 집합 자료형 알고리즘 문제
*/
public class Main_B_2776_암기왕 {

    static FastReader scan = new FastReader();
    static int M;
    static Set<Integer> map;


    static void solution() {
        StringBuilder sb = new StringBuilder();

        int T = scan.nextInt();
        for(int t = 0; t < T; t++) {
            map = new HashSet<>();
            int N = scan.nextInt();
            for (int i = 0; i < N; i++) {
                map.add(scan.nextInt());
            }
            M = scan.nextInt();
            for (int i = 0; i < M; i++) {
                int x = scan.nextInt();
                sb.append((map.contains(x))? 1 : 0).append("\n");
            }
        }

        System.out.println(sb);
    }

    // Main
    public static void main(String[] args) {
        solution();
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
