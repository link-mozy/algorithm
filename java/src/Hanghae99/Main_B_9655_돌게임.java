package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/23/24
 *  @see <a href="https://www.acmicpc.net/problem/9655" />
 *  @mem 14380 KB
 *  @time 108 ms
 *  @caution DP 문제
 *  - 혼자서 점화식 유도를 못함...
*/
public class Main_B_9655_돌게임 {
    static int N;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
    }

    static void solution() {
        int [] dy = new int[1001];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 3;

        for(int i = 4; i <= 1000; i++) {
            dy[i] = Math.min(dy[i-1], dy[i-3]) + 1;
        }

        if(dy[N]%2 == 0) System.out.println("CY");
        else System.out.println("SK");
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
