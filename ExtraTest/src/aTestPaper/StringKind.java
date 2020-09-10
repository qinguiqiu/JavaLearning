package aTestPaper;

import java.util.Scanner;

public class StringKind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println((int)(kind(s)%(10e9+7)));
    }

    public static int kind(String s){
        int count = 0;
        
        for (int i = 0; i < s.length()-1; i++){
            if (s.charAt(i) == 'u'){
                if (s.charAt(i+1) == 'u'){
                    count += 1;
                }
            }else if (s.charAt(i) == 'n'){
                if (s.charAt(i+1) == 'n'){
                    count += 1;
                }
            }else if (s.charAt(i) == 'm' || s.charAt(i) == 'w'){
                return 0;
            }
        }
        if (s.charAt(s.length()-1) == 'm' || s.charAt(s.length()-1) == 'w'){
            return 0;
        }
        return (int)Math.pow(2, count);
    }
}
