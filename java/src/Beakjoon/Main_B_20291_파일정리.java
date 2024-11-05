package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/5/24
 *  @see <a href="https://www.acmicpc.net/problem/20291" />
 *  @mem 61352 KB
 *  @time 736 ms
 *  @caution 정렬 특성 문제
*/
public class Main_B_20291_파일정리 {

    static FastReader scan = new FastReader();

    static int N;
    static String [] files;

    static void input() {
        N = scan.nextInt();
        files = new String[N];
        for(int i = 0; i < N; i++) {
            String file = scan.nextLine();
            files[i] = file.split("\\.")[1];
        }
    }

    static void solution() {
        // 정렬
        Arrays.sort(files);
        int currentCount = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < N; i++) {
            if(files[i-1].equals(files[i])) {
                currentCount++;
            } else {
                sb.append(files[i-1]).append(" ").append(currentCount).append("\n");
                currentCount = 1;
            }
            if(i == N-1) sb.append(files[i]).append(" ").append(currentCount).append("\n");
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
