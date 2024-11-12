package Beakjoon;

import java.io.*;
import java.util.*;

public class Main_B_10816_숫자카드2_틀림 {

    static class Card {
        int idx;
        int num;
        int count;

        public Card(int idx, int num, int count) {
            this.idx = idx;
            this.num = num;
            this.count = count;
        }
    }

    static int N, M;
    static int [] nList;
    static int [] mList;
    static List<Card> cardList;

    static void input() {
        FastReader scan = new FastReader();
        cardList = new ArrayList<>();
        N = scan.nextInt();
        nList = new int[N + 1];
        for (int i = 1; i <= N; i++) nList[i] = scan.nextInt();
        M = scan.nextInt();
        mList = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            mList[i] = scan.nextInt();
            cardList.add(new Card(i, mList[i], 0));
        }
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(nList, 1, N+1);
        Collections.sort(cardList, (o1, o2) -> o1.num - o2.num);

        int left = 1;
        int cardCount = 0;
        for(int i = 0; i < M; i++) {
            Card card = cardList.get(i);
            left = left + cardCount;
            cardCount = binarySearch(card.num, left);
            card.count = cardCount;
            cardList.set(i, card);
        }

        Collections.sort(cardList, (o1, o2) -> o1.idx - o2.idx);
        for(Card card : cardList) sb.append(card.count).append(" ");
        System.out.println(sb);
    }

    static int binarySearch(int number, int left) {
        int right = N;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(nList[mid] < number) {
                left = mid + 1;
            } else if (nList[mid] == number) {
                return getCount(mid);
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    static int getCount(int idx) {
        int count = 1;
        // 오른쪽 비교
        for(int i = idx + 1; i <= N && nList[idx] == nList[i]; i++) count++;
        // 왼쪽 비교
        for(int i = idx - 1; 0 < i && nList[idx] == nList[i]; i--) count++;
        return count;
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
