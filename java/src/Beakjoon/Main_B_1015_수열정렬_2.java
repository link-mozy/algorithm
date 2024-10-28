package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1015_수열정렬_2 {

    static class Elem implements Comparable<Elem> {
        /**
         * @param index A 배열의 index 위치를 기억하는 변수
         * @param num   A[index]의 원래
         */
        public int num, index;

        @Override
        public int compareTo(Elem other) {
            return num - other.num;
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new Elem[N];
        P = new int [N];
        for(int i=0; i<N; i++) {
            A[i] = new Elem();
            A[i].num = scan.nextInt();
            A[i].index = i;
        }
    }

    static void solution() {
        Arrays.sort(A);
        for(int i=0; i<N; i++)
            P[A[i].index] = i;
    }

    static void output() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
            sb.append(P[i]).append(" ");
        System.out.println(sb);
    }

    static int N;
    static int [] P;
    static Elem [] A;

    // Main
    public static void main(String[] args) {
        input();
        solution();
        output();
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
