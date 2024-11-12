package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/11/24
 *  @see <a href="https://www.acmicpc.net/problem/13417" />
 *  @mem 103332 KB
 *  @time 420 ms
 *  @caution 그리디 알고리즘
*/
public class Main_B_13417_카드문자열 {

    static int N;
    static String [] cards;

    static FastReader scan = new FastReader();

    static String solution() {
        N = scan.nextInt();
        String cards = scan.next(); // 첫 카드 세팅

        for(int i = 1; i < N; i++) {
            String nextCard = scan.next();
            String firstCard = cards.substring(0, 1);
            if(nextCard.compareTo(firstCard) < 1) {
                cards = nextCard + cards;
            } else {
                cards = cards + nextCard;
            }
        }
        return cards;
    }
    
    // Main
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int T = scan.nextInt();
        for(int t = 0 ; t < T; t++) {
            sb.append(solution()).append("\n");
        }
        System.out.println(sb);
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
