package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 10/29/24
 *  @see <a href="https://www.acmicpc.net/problem/11561" />
 *  @mem 17760 KB
 *  @time 196 ms
 *  @caution 이진탐색, 등차수열
 *  혼자서 풀기 실패.
 *  이진탐색 조건으로 등차수열을 해야하는 것을 찾지 못함...(너무 어려움)
*/
public class Main_B_11561_징검다리 {

    static int T;
    static long [] N;

    static void input() {
        FastReader scan = new FastReader();
        T = scan.nextInt();
        N = new long[T];
        for (int i = 0; i < T; i++) {
            N[i] = scan.nextLong();
        }
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();
        long left, right;

        for(int t = 0; t < T; t++) {
            left = 0;
            right = 1_000_000_000L;
            long result = 0;

            while(left <= right) {
                long mid = (left + right) >>> 1;
                long sum = (mid * (mid + 1)) / 2;
                if(sum <= N[t]) {
                    result = Math.max(result, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
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
