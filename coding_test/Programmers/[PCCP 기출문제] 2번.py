from collections import deque
def solution(land):
    def bfs(sx,sy,flag):
        group[flag]=set()
        group[flag].add(sy)
        q=deque([(sx,sy)])
        visited[sx][sy]=1
        res=0
        while q:
            x,y=q.popleft()
            res+=1
            for dx,dy in d:
                nx=dx+x
                ny=dy+y
                if -1<nx<n and -1<ny<m:
                    if land[nx][ny] and not visited[nx][ny]:
                        visited[nx][ny]=1
                        q.append((nx,ny))
                        group[flag].add(ny)
        cnt[flag]=res

    d=[(-1,0),(1,0),(0,-1),(0,1)]
    n=len(land)
    m=len(land[0])
    visited=[[0]*m for _ in range(n)]
    group=dict()
    cnt=dict()
    for i in range(n):
        for j in range(m):
            if land[i][j] and not visited[i][j]:
                bfs(i,j,i*m+j)
    row=[0]*m
    for k,v in group.items():
        for r in v:
            row[r]+=cnt[k]
    return max(row)
