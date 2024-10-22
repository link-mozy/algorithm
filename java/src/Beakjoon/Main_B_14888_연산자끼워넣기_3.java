package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_14888_연산자끼워넣기_3 {

    static FastReader scan = new FastReader();

    static int N, max, min;
    static int[] nums, operators, orders;

    static int calculator(int number1, int operator, int number2) {
        if (operator == 1)      // +
            return number1 + number2;
        else if (operator == 2) // -
            return number1 - number2;
        else if (operator == 3) // *
            return number1 * number2;
        else                    // /
            return number1 / number2;
    }

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5]; // 0, 1:덧셈, 2:뺄셈, 3:곱셈, 4:나눗셈
        orders = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static void rec_fun(int k, int value) {
        if(k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for(int cand = 1; cand <= 4; cand++) {
                if(operators[cand] > 0) {
                    operators[cand]--;
                    rec_fun(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                }
            }
        }
    }

    // Main
    public static void main(String[] args) {
        input();
        rec_fun(1, nums[1]);
        System.out.println(max);
        System.out.println(min);
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
