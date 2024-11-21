package Hanghae99;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/21/24
 *  @see <a href="https://www.acmicpc.net/problem/2116" />
 *  @mem 26680 KB
 *  @time 252 ms
 *  @caution 완전 탐색
*/
public class Main_B_2116_주사위쌓기 {

    static class Block {
        int topNumber;
        int bottomNumber;
        int blockNumber;
        int sum;

        public Block(int blockNumber, int topNumber, int bottomNumber, int sum) {
            this.blockNumber = blockNumber;
            this.topNumber = topNumber;
            this.bottomNumber = bottomNumber;
            this.sum = sum;
        }
    }

    static int N;
    static int [][] diceList;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        diceList = new int[N+1][7];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= 6; j++) {
                diceList[i][j] = scan.nextInt();
            }
        }
    }

    static void solution() {
        LinkedList<Block> queue = new LinkedList<>();
        int max = 0;

        for(int i = 1; i <= 6; i++) {
            queue.add(new Block(1, i, disNumber(i), findMaxNumber(i, diceList[1])));
        }

        while (!queue.isEmpty()) {
            Block front = queue.poll();
            if(front.blockNumber == N) {
                max = Math.max(max, front.sum);
            } else {
                int blockNumber = front.blockNumber + 1;
                int preTopDiceNumber = diceList[front.blockNumber][front.topNumber];
                int bottomNumber = findBottomNumber(preTopDiceNumber, diceList[blockNumber]);
                int sum = front.sum + findMaxNumber(bottomNumber, diceList[blockNumber]);

                queue.add(new Block(
                        blockNumber,
                        disNumber(bottomNumber),
                        bottomNumber,
                        sum
                ));
            }
        }

        System.out.println(max);
    }

    static int findMaxNumber(int num1, int [] dice) {
        int result = -1;
        int num2 = disNumber(num1);

        for(int i = 1; i <= 6; i++) {
            if(i == num1 || i == num2) continue;
            result = Math.max(result, dice[i]);
        }
        return result;
    }

    /**
     *
     * @param num 아래 주사위의 윗 번호
     * @param dice 현재 주사위
     * @return 현재 주쉬에서 아래 번호
     */
    static int findBottomNumber(int num, int [] dice) {
        for (int i = 1; i <= 6; i++) {
            if(num == dice[i]) return i;
        }
        return 0;
    }

    static int disNumber(int num) {
        switch (num) {
            case 1:
                return 6;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 1;
            default:
                return 0;
        }
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
