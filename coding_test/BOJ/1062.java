import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K,answer,visited,words[];
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        words=new int[N];
        for(int i=0;i<N;i++) {
            int tmp=0;
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                tmp|=1<<(s.charAt(j)-'a');
            }
            words[i]=tmp;
        }

        answer=0;
        K-=5;// 반드시 읽어야하는 글자
        if(K>=0){
            visited|=1;
            visited|=1<<('n'-'a');
            visited|=1<<('t'-'a');
            visited|=1<<('i'-'a');
            visited|=1<<('c'-'a');
            comb(0,0);
        }
        System.out.println(answer);
    }
    static void comb(int depth,int start){
        if(depth==K){
            int cnt=0;
            for(int w:words){
                if((w&visited)==w) cnt++;
            }
            if(cnt>answer) answer=cnt;
        }
        for(int i=start;i<26;i++){
            if((visited&(1<<i))==0) {
                visited^=1<<i;
                comb(depth+1,i+1);
                visited^=1<<i;
            }
        }
    }
}