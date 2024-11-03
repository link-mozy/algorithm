package Hanghae99;
public class Solution_84512_모음사전 {

    public static void main(String[] args) {
        solution("EIO");
    }

    static String strList [] = {"A", "E", "I", "O", "U"};
    static String tartWord;
    static int result;
    static int count;

    static void dfs(String w) {
        count++;
        if(tartWord.equals(w)) {
            result = count;
            return;
        }
        // 정답을 찾았다면 더이상 재귀함수를 호출하지 않는다.
        if(result != -1) return;
        // 문자열의 길이가 5라면, 더이상 재귀함수를 호출하지 않는다.
        if(w.length() == 5) return;
        for(int i = 0; i < strList.length; i++) {
            // 글자 리스트에서 한글자를 가져와 받은 문자열에 붙인다.
            String newWord = w + strList[i];
            dfs(newWord);
        }
    }

    static public int solution(String word) {
        int answer = 0;
        count = -1;
        tartWord = word;
        result = -1;
        dfs("");
        answer = result;
        return answer;
    }
}
