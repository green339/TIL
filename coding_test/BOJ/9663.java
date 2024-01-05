import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        boolean[] col=new boolean[N]; //같은 열에 있는지
        boolean[] down=new boolean[2*N]; // 같은 \대각선에 있는지
        boolean[] up=new boolean[2*N]; // 같은 /대각선에 있는지
        System.out.println(dfs(N,0, col,down,up));
        br.close();
    }
    public static int dfs(int N,int r,boolean[] col, boolean[] down, boolean[] up){
        if(r==N) return 1;
        int res=0;
        for(int c=0;c<N;c++){
            if(col[c]||down[r-c+N]||up[r+c]) continue;
            col[c]=true;
            down[r-c+N]=true;
            up[r+c]=true;
            res+=dfs(N,r+1,col,down,up);
            col[c]=false;
            down[r-c+N]=false;
            up[r+c]=false;
        }
        return res;
    }
}