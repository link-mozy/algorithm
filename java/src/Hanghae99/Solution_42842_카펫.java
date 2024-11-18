package Hanghae99;

public class Solution_42842_카펫 {

    public static void main(String[] args) {
        solution(8, 1);
    }

    static boolean check(int z, int x, int y) {
        if(y - 2 < 0) return false;
        return z == (x * 2) + (y - 2) * 2;
    }

    static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;
        for(int i = 3; i <= brown; i++) {
            if( (total % i) == 0 && check(brown, i, total / i)) {
                int x = i;
                int y = total / i;
                if(x > y) {
                    answer[0] = x;
                    answer[1] = y;
                } else {
                    answer[0] = y;
                    answer[1] = x;
                }
                break;
            }
        }

        return answer;
    }
}
