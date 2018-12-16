import re
import sys


for _ in range(int(sys.stdin.readline().rstrip())):
    string = sys.stdin.readline().rstrip()
    if re.search(r"^(100+1+|01)+$", string):
        print("YES")
    else:
        print("NO")
