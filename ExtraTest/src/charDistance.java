import java.util.Scanner;

public class charDistance {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String c = sc.nextLine();
        char ch = c.charAt(0);
        int[] res = getRes(s, ch);
        System.out.print("[");
        int i;
        for (i = 0; i < res.length-1; i++) {
            System.out.print(res[i]+",");
        }
        System.out.print(res[i]+"]");
    }

    public static int[] getRes(String S, char C){
        if (null == S || 0 == S.length()) {
            return null;
        }
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }
        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }
        return ans;
    }
}
