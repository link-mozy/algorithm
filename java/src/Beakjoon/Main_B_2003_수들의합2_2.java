package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B_2003_수들의합2_2 {

    static int N, M;
    static int [] A;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int [N + 1];

        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken()); 
        
        solution();
    }

    private static void solution() {
        int R = 0, sum = 0, ans = 0;

        for(int L = 1; L <= N; L++) {
            sum -= A[L - 1];

            while(R + 1 <= N && sum < M) {
                R++;
                sum += A[R];
            }

            if(sum == M) ans++;
        }

        System.out.println(ans);
    }

    static String str = "10 5\n" +
            "1 2 3 4 2 5 3 1 1 2";
}
