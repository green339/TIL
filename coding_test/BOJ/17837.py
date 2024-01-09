import sys
from collections import defaultdict
input=sys.stdin.readline

def move(idx):
    x=mal_info[idx][0]
    y=mal_info[idx][1]
    nx=x+d[mal_info[idx][2]][0]
    ny=y+d[mal_info[idx][2]][1]
    if -1<nx<n and -1<ny<n:           
        if board[nx][ny]==2:
            mal_info[idx][2]=rev_d[mal_info[idx][2]]
            nx=x+d[mal_info[idx][2]][0]
            ny=y+d[mal_info[idx][2]][1]
    else:
        mal_info[idx][2]=rev_d[mal_info[idx][2]]
        nx=x+d[mal_info[idx][2]][0]
        ny=y+d[mal_info[idx][2]][1]
    if -1<nx<n and -1<ny<n:           
        if board[nx][ny]==2:
            return True
    else:
        return True
    todo=[]
    while mal[x][y][-1]!=idx:
        todo.append(mal[x][y].pop())
    todo.append(mal[x][y].pop())
    if board[nx][ny]==0:
        todo=todo[::-1]
    for t in todo:
        mal[nx][ny].append(t)
        mal_info[t][0]=nx
        mal_info[t][1]=ny
    if len(mal[nx][ny])>=4:
        return False
    return True
    
n,k=map(int,input().split())
mal=[[[] for _ in range(n)] for _ in range(n)]
mal_info=defaultdict(list) # 현재x,y,방향
board=[list(map(int,input().split())) for _ in range(n)]
d=[(0,1),(0,-1),(-1,0),(1,0)]
rev_d={0:1,1:0,2:3,3:2}
for i in range(k):
    a,b,c=map(int,input().split())
    mal[a-1][b-1].append(i)
    mal_info[i]=[a-1,b-1,c-1]

for t in range(1,1001):
    for i in range(k):
        if not move(i):
            break
    else:
        continue
    print(t)
    break
else:
    print(-1)