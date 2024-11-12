package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/12/24
 *  @see <a href="https://www.acmicpc.net/problem/2847" />
 *  @mem 14080 KB
 *  @time 108 ms
 *  @caution
 *  문제를 이해하기가 어려운 문제...
*/
public class Main_B_2847_게임을만든동준이 {

    static int N;
    static int [] scoreList;

    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        scoreList = new int[N];
        for(int i = 0; i < N; i++) scoreList[i] = scan.nextInt();
    }

    static void solution() {
        int result = 0;
        for(int i = N-2; i >= 0; i--) {
            int cur = scoreList[i]; // 현재 값
            int right = scoreList[i + 1]; // 다음 값
            while (right <= cur) {
                result++;
                cur--;
            }
            scoreList[i] = cur;
        }

        System.out.println(result);
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
