package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/2/24
 *  @see <a href="https://www.acmicpc.net/problem/2805" />
 *  @mem 123236 KB
 *  @time 500 ms
 *  @caution 이진탐색
*/
public class Main_B_2805_나무자르기 {

    static int N;
    static long M [];
    static long H, maxM;

    static void input() {
        FastReader scan = new FastReader();
        maxM = 0;
        N = scan.nextInt();
        H = scan.nextLong();
        M = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            M[i] = scan.nextLong();
            maxM = Math.max(maxM, M[i]);
        }
    }

    static void solution() {
        long left = 0;
        long right = maxM;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if(geTotalLength(mid) >= H) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    static long geTotalLength(long high) {
        long length = 0;
        for(long m : M) {
            if(m > high) {
                length += (m - high);
            }
        }
        return length;
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
