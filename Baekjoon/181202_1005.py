import sys
sys.setrecursionlimit(10**6)
trial = int(sys.stdin.readline().rstrip())

def get_total_time_table(n):
    if n not in rules:
        return time_table[n]
    if n not in table:
        table[n] = max([get_total_time_table(x) for x in rules[n]]) + time_table[n]
    return table[n]
        
for _ in range(trial):
    _, rules_no = map(int, sys.stdin.readline().rstrip().split())
    time_table = {_k+1: _v for _k, _v in enumerate(map(int, sys.stdin.readline().rstrip().split()))}
    table = {}
    rules = {}
    for _ in range(rules_no):
        sub, tar = map(int, sys.stdin.readline().rstrip().split())
        if tar not in rules:
            rules[tar] = []
        rules[tar].append(sub)
    print(get_total_time_table(int(sys.stdin.readline().rstrip())))  
