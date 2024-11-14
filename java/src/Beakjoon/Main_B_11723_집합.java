package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/13/24
 *  @see <a href="https://www.acmicpc.net/problem/11723" />
 *  @mem 307312 KB
 *  @time 1180 ms
 *  @caution 구현
*/
public class Main_B_11723_집합 {

    static int M;
    static boolean [] S;

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void solution() {
        S = new boolean [21];
        M = scan.nextInt();

        for(int i = 0; i < M; i++) {
            String line = scan.nextLine();
            if (line.equals("all")) {
                Arrays.fill(S, true);
            } else if (line.equals("empty")) {
                Arrays.fill(S, false);
            } else {
                // lines[0] : 명령어 , lines[1] : 값
                String [] lines = line.split(" ");
                command(lines[0], Integer.parseInt(lines[1]));
            }
        }

        System.out.println(sb);
    }

    static void command(String o, int num) {
        switch (o) {
            case "add" :
                S[num] = true;
                break;
            case "remove" :
                S[num] = false;
                break;
            case "check" :
                sb.append((S[num])?1:0).append("\n");
                break;
            case "toggle" :
                S[num] = (S[num])? false : true;
                break;
            default:
                break;
        }
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
