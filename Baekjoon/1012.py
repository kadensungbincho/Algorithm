import sys


def move(x, y):
    return [x - y for x, y in zip(x, y)]


for _ in range(int(sys.stdin.readline().rstrip())):
    _w, _h, _n = map(int, sys.stdin.readline().rstrip().split())
    dots = []
    for _ in range(_n):
        dots.append(list(map(int, sys.stdin.readline().rstrip().split())))
    cnt = 0
    while dots:
        queue = []
        queue.append(dots.pop())
        while queue:
            dot = queue.pop()
            if move(dot, [1, 0]) in dots:
                dots.remove(move(dot, [1, 0]))
                queue.append(move(dot, [1, 0]))
            if move(dot, [-1, 0]) in dots:
                dots.remove(move(dot, [-1, 0]))
                queue.append(move(dot, [-1, 0]))
            if move(dot, [0, 1]) in dots:
                dots.remove(move(dot, [0, 1]))
                queue.append(move(dot, [0, 1]))
            if move(dot, [0, -1]) in dots:
                dots.remove(move(dot, [0, -1]))
                queue.append(move(dot, [0, -1]))
        cnt += 1
    print(cnt)
