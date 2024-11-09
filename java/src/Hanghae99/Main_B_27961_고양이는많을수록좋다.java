package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/9/24
 *  @see <a href="https://www.acmicpc.net/problem/27961" />
 *  @mem 14128 KB
 *  @time 108 ms
 *  @caution 그리디 알고리즘
 *  - 복제 마법을 사용하는게 가장 이득.
 *  - 하지만, 중간에 짝수로 맞추어 곱셈을 사용하도록 해야함.
 *  - 짝수로 맞추는 과정에서 기존의 값을 1 증가 시키기 때문에 횟수는 결국 증가.
 *  혼자 풀기 실패...
 *  Nahwasa님의 문제 풀이 참고 : <a href="https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-27961-%EA%B3%A0%EC%96%91%EC%9D%B4%EB%8A%94-%EB%A7%8E%EC%9D%84%EC%88%98%EB%A1%9D-%EC%A2%8B%EB%8B%A4-java" />
*/
public class Main_B_27961_고양이는많을수록좋다 {

    static FastReader scan = new FastReader();

    static long N;

    static void solution() {
        // 입력 부분
        N = scan.nextLong();
        long count = 0;
        // 솔루션 부분
        while (3 < N) {
            count++;
            // ((N % 2) == 1? 1: 0)를 더하면 결국 count를 한번더 하게 된다.
            N = (N / 2) + ((N % 2) == 1? 1: 0);
        }
        // 출력 부분
        System.out.println(count + N);
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
