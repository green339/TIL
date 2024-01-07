import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] board=new int[N][M];
        int cheese=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                cheese+=board[i][j];
            }
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        boolean[][][] visited=new boolean[N][M][4];
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int ans=0;
        while(cheese>0){
            ans++;
            q.offer(new int[]{0,0});
            while(!q.isEmpty()){
                int[] xy=q.poll();
                for(int di=0;di<4;di++){
                    int nx=dx[di]+xy[0];
                    int ny=dy[di]+xy[1];
                    if(-1<nx&&nx<N&&-1<ny&&ny<M){
                        if(!visited[nx][ny][di]){
                            visited[nx][ny][di]=true;
                            if(board[nx][ny]==0) q.offer(new int[]{nx,ny});
                        }
                    }
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int cnt=0;
                    for(int k=0;k<4;k++){
                        if(board[i][j]==1&&visited[i][j][k]) cnt++;
                        visited[i][j][k] = false;
                    }
                    if(cnt>=2) {
                        board[i][j]=0;
                        cheese--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}