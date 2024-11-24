package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/24/24
 *  @see <a href="https://www.acmicpc.net/problem/11722" />
 *  @mem 14416 KB
 *  @time 124 ms
 *  @caution DP 알고리즘
 *  - 점화식을 잘못 만듬...
 *  - 점화식 : 매번 앞에서 부터 나보다 작은 값들의 길이가 가장 큰 값을 가져와야한다.
*/
public class Main_B_11722_가장긴감소하는부분수열 {

    static int N;
    static int [] A;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void solution() {
        int max = 0;
        int [] dp = new int[N+1];
        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i] = 1;

            for(int j = 1; j < i; j++) {
                if(A[i] < A[j] && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
                else if(A[i] == A[j]) dp[i] = dp[j];
            }
        }

        for(int i = 1; i <= N; i++) max = Math.max(max, dp[i]);

        System.out.println(max);
    }

    // Main
    public static void main(String[] args) {

        input();
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
