import sys
sys.setrecursionlimit(10 ** 9)
input=sys.stdin.readline

def post(s,e):
    if s>e:
        return
    mid=e+1 #루트보다 큰값이 존재하지 않을때
    for i in range(s+1,e+1):
        if board[i]>board[s]:
            mid=i
            break
    post(s+1,mid-1)
    post(mid,e)
    print(board[s])

board=[]
while True:
    try:
        board.append(int(input()))
    except:
        break
post(0,len(board)-1)