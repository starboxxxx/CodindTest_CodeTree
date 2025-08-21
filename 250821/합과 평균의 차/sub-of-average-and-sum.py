a, b, c = map(int, input().split())

all_sum = a+b+c
average = int(all_sum/3)
minus = all_sum-average

print(all_sum)
print(average)
print(minus)