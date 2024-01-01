def solution(bandage, health, attacks):
    last=0
    hp=health
    for t,damage in attacks:
        cur=t-last-1
        last=t
        hp=min(hp+cur*bandage[1]+(cur//bandage[0])*bandage[2],health)
        hp-=damage
        if hp<=0:
            return -1
    return hp