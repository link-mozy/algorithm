package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/25/24
 *  @see <a href="https://www.acmicpc.net/problem/9461" />
 *  @mem 14060 KB
 *  @time 100 ms
 *  @caution DP 알고리즘
 *  DP 배열의 자료형을 long 으로 해야한다.
*/
public class Main_B_9461_파도반수열 {
    static long [] P;

    static void dp() {
        P = new long[101];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;
        P[6] = 3;
        P[7] = 4;
        for(int i = 8; i <= 100; i++) {
            P[i] = P[i-1] + P[i-5];
        }
    }

    static void solution() {
        FastReader scan = new FastReader();
        StringBuilder sb = new StringBuilder();
        int N = scan.nextInt();
        for(int i = 0; i < N; i++) {
            sb.append(P[scan.nextInt()]).append("\n");
        }
        System.out.println(sb);
    }

    // Main
    public static void main(String[] args) {
        dp();
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
