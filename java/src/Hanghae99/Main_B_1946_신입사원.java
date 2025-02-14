package Hanghae99;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_B_1946_신입사원 {

    static int T, N;
    static int [] employee;
    static FastReader scan = new FastReader();

    static void input(int n) {
        employee = new int [n];
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt(); // 서류 순위
            int y = scan.nextInt(); // 면접 순위
            employee[x-1] = y;
        }
    }

    static int getEmployeeNumber(int n) {
        int count = 1;
        int rating = employee[0];
        for (int i = 1; i < n; i++) {
            if (rating > employee[i]) {
                count++;
                rating = employee[i];
            }
        }
        return count;
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();

        T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            N = scan.nextInt();
            input(N);
            sb.append(getEmployeeNumber(N)).append("\n");
        }

        System.out.println(sb);
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
