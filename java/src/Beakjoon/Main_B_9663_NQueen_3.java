package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_9663_NQueen_3 {

    static int N, ans;
    static int [] col;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        col = new int [N + 1];
    }

    static void rec_func(int row) {
        if(row >= N + 1) {
            ans++;
        } else {
            for(int i=1; i <= N; i++) {
                boolean possible = true;
                // (row, i) <- 새로 놓은 체스말
                for(int j=1; j<=row-1; j++) { // 미리 체스말을 더 놓을 수 있는지 확인한다.
                    // (j, col[j]) <- 기존에 놓여있는 체스말
                    if(attackable(row, i, j, col[j])) {
                        possible = false;
                        break;
                    }
                }
                if(possible) {
                    col[row] = i;
                    rec_func(row+1);
                    col[row] = 0;
                }
            }
        }
    }

    static boolean attackable(int row1, int col1, int row2, int col2) {
        if(col1 == col2) return true; // | 세로 검사
        if(row1 + col1 == row2 + col2) return true; // / 대각선 검사
        if(row1 - col1 == row2 - col2) return true; // \ 대간선 검사
        return false;
    }

    // Main
    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(ans);
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
