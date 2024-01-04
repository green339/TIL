import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        String k= br.readLine();
        int n=k.length();
        int cur=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
            cur++;
            if(cur>=n){
                boolean flag=true;
                for(int j=1;j<=n;j++){
                    if(stack.get(cur-j)!=k.charAt(n-j)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    for(int j=0;j<n;j++){
                        cur--;
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(Character c:stack) sb.append(c);
        //StringBuilder에서 isEmpty는 15버전부터 가능
        if(sb.length()>0) System.out.println(sb);
        else System.out.println("FRULA");
        br.close();
    }
}