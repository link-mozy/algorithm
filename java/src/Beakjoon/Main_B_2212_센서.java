package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/14/24
 *  @see <a href="https://www.acmicpc.net/problem/2212" />
 *  @mem 16908 KB
 *  @time 168 ms
 *  @caution 그리디 문제
 *  - 문제 해결 방법을 혼자서 찾지 못함...
 *  - 풀이 방법 : 센서간의 거리를 dif 배열로 만들고 정렬 후 N - K 까지의 배열 값을 더함.
 *  문제풀이 링크 : https://steady-coding.tistory.com/12
*/
public class Main_B_2212_센서 {

    static int N, K;
    static int [] sensors;
    static int [] dif;

    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        sensors = new int [N + 1];
        dif = new int [N];
        for(int i = 1; i <= N; i++) {
            sensors[i] = scan.nextInt();
        }
    }

    static int solution() {
        // 센서 정렬
        Arrays.sort(sensors, 1, N+1);
        // 센서들의 거리 값 구하기
        for(int i = 1; i <= N-1; i++) dif[i] = sensors[i+1] - sensors[i];
        // 거리값 정렬
        Arrays.sort(dif, 1, N);
        // 정답 구하기
        int result = 0;
        if(N <= K) return  result;
        for(int i = 1; i <= N - K; i++) {
            result += dif[i];
        }
        return result;
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
