import sys
from functools import reduce


def get_pool(strategies):
    if not strategies:
        return set({})
    return reduce(lambda x, y: x | y, map(lambda x: x[0], strategies))


def get_strategies(size, w, enemy_table):
    strategies = []
    for i in range(1, size*2+1):
        if i % size != 0:
            strategies.append([set([i, i+1]), enemy_table[i]+enemy_table[i+1]])
        else:
            strategies.append([set([i, i-size+1]), enemy_table[i]+enemy_table[i-size+1]])
        if i <= size:
            strategies.append([set([i, i+size]), enemy_table[i]+enemy_table[i+size]])
    total = [[x, y] for x, y in strategies if y <= w]
    unique = []
    for l in total:
        except_total = [_l for _l in total if _l != l]
        except_pool = get_pool(except_total)
        if l[0] - except_pool == l[0]:
            unique.append(l)
    non_unique = [_l for _l in total if _l not in unique]
    return unique, non_unique


def get_results(*args, **kw):
    non_uni_cnt = 0

    def _func(queue, strategies):
        nonlocal non_uni_cnt
        if not strategies:
            non_uni_cnt += len(queue)
            return
        if not (strategies[0][0] - queue):
            non_uni_cnt += 1
            queue -= strategies[0][0]
            strategies = [_l for _l in strategies if not (_l[0] & strategies[0][0])]
            return _func(queue, strategies)
        strategies.pop(0)
        return _func(queue, strategies)
    _func(*args, **kw)
    return non_uni_cnt
        
trial = int(sys.stdin.readline().rstrip())
for _ in range(trial):
    size, w = map(int, sys.stdin.readline().rstrip().split())
    enemy_table = {}
    enemy_table.update({x+1: y for x, y in enumerate(map(int, sys.stdin.readline().rstrip().split()))})
    enemy_table.update({x+size+1: y for x, y in enumerate(map(int, sys.stdin.readline().rstrip().split()))})
    cell_queue = set([x for x in range(1, size * 2 + 1)])
    uni_strategies, non_uni_strategies = get_strategies(size, w, enemy_table)
    if not uni_strategies and not non_uni_strategies:
        print(len(cell_queue))
    else:
        results = []
        base = len(uni_strategies)
        non_uni_queue = cell_queue.copy() - get_pool(uni_strategies)
        if not non_uni_strategies:
            results.append(base)
        else:
            for l in range(len(non_uni_strategies)):
                strategies = non_uni_strategies[l:]+non_uni_strategies[:l]
                res = get_results(non_uni_queue.copy(), strategies) 
                results.append(base+res)
        print(min(results))
        