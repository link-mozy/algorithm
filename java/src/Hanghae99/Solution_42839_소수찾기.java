package Hanghae99;

import java.util.HashSet;

public class Solution_42839_소수찾기 {

    public static void main(String[] args) {
        solution("011");
    }

    static public boolean check(String number) {
        int num = Integer.parseInt(number);
        if(num < 2) return false; // 0, 1 은 소수가 아니다.
        for(int i = 2; i < num; i++) {
            if((num % i) == 0) return false;
        }
        return true;
    }
    static public void dfs(String numbers, boolean [] visited, String number, int count) {
        if(number.equals("0")) return;    // 제외
        if(count == numbers.length()) {   // 탈출
            if(number.equals("")) return; // 제외
            if(!set.contains(number) && check(number)) {
                set.add(number);
                System.out.println(number);
            }
            return;
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            // 1. 숫자를 포함 시키는 경우
            dfs(numbers, visited, number + numbers.charAt(i), count + 1);
            // 2. 숫자를 포함 시키지 않는 경우
            dfs(numbers, visited, number, count + 1);
            visited[i] = false;
        }
    }
    static HashSet<String> set;
    static public int solution(String numbers) {
        set= new HashSet<>();
        boolean [] visited = new boolean[numbers.length()];
        for(int i = 0; i < numbers.length(); i++) {
            visited[i] = true;
            dfs(numbers, visited, ""+numbers.charAt(i), 1);
            visited[i] = false;
        }
        System.out.println(set.size());
        return set.size();
    }
}
