nums = [int(input()) for _ in range(10)]
cnt_3 = 0
cnt_5 = 0

for num in nums:
    if num % 3 == 0:
        cnt_3 += 1

for num in nums:
    if num % 5 == 0:
        cnt_5 += 1

print(cnt_3, cnt_5)