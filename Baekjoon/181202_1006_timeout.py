import sys


def get_strategies(size, w, enemy_table):
    strategies = []
    for i in range(1, size*2+1):
        if i % size != 0:
            strategies.append([set([i, i+1]), enemy_table[i]+enemy_table[i+1]])
        else:
            strategies.append([set([i, i-size+1]), enemy_table[i]+enemy_table[i-size+1]])
        if i <= size:
            strategies.append([set([i, i+size]), enemy_table[i]+enemy_table[i+size]])
    return [[x, y] for x, y in strategies if y <= w]


def get_results(queue, strategies):
    cnt = 0
    for strategy in strategies:
        if not (strategy[0] - queue):
            cnt += 1
            queue -= strategy[0]
    cnt += len(queue)
    return cnt


class Pentagon:
    def __init__(self, row_size, w, enemy_table):
        self.row_size = row_size
        self.cell_queue = set([x for x in range(1, self.row_size*2 + 1)])
        self.enemy_table = enemy_table
        self.strategies = get_strategies(self.row_size, w, self.enemy_table)
        

trial = int(sys.stdin.readline().rstrip())
for _ in range(trial):
    size, w = map(int, sys.stdin.readline().rstrip().split())
    enemy_table = {}
    enemy_table.update({x+1: y for x, y in enumerate(map(int, sys.stdin.readline().rstrip().split()))})
    enemy_table.update({x+size+1: y for x, y in enumerate(map(int, sys.stdin.readline().rstrip().split()))})
    pentagon = Pentagon(size, w, enemy_table)
    results = []
    if not pentagon.strategies:
        results.append(len(pentagon.cell_queue))
    else:
        for l in range(len(pentagon.strategies)):
            strategies = pentagon.strategies[l:]+pentagon.strategies[:l]
            res = get_results(pentagon.cell_queue.copy(), strategies) 
            results.append(res)
    print(min(results))       
