package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/10/24
 *  @see <a href="https://www.acmicpc.net/problem/14916" />
 *  @mem 14192 KB
 *  @time 100 ms
 *  @caution 그리디 알고리즘
 *  - 5원을 많이 사용 할 수록 이득
 *  - 5원을 사용하고 나머지를 2원으로 거스를수 있는지 확인.
 *  - 만약 5원, 2원으로 거스름을 만들수없다면, -1 리턴.
*/
public class Main_B_14916_거스름돈 {

    static int n;

    static void input() {
        FastReader scan = new FastReader();
        n = scan.nextInt();
    }

    static int solution() {
        for(int i = n / 5; -1 < i; i--) {
            if(n == i * 5) return i;
            int m = n - (5 * i);
            if(m % 2 == 0) return i + (m / 2);
        }
        return -1;
    }

    // Main
    public static void main(String[] args) {
        input();
        System.out.println(solution());
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
