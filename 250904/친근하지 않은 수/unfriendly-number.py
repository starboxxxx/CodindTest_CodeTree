num = int(input())

count = 0

for i in range(1,num+1):
    if i % 2 == 0 or i % 3 == 0 or i % 5 == 0:
        continue
    else:
        count += 1

print(count)