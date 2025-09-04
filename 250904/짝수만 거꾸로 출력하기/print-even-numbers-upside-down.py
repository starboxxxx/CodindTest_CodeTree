num = int(input())
nums = list(map(int, input().split()))


for i in nums[::-1]:
    if i % 2 == 0:
        print(i, end = " ")