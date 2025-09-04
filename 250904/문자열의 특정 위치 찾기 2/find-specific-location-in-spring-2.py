fruits = ["apple", "banana", "grape", "blueberry", "orange"]

str_1 = str(input())

cnt = 0

for i in range(len(fruits)):
    if fruits[i][2] == str_1:
        print(fruits[i])
        cnt += 1
    elif fruits[i][3] == str_1:
        print(fruits[i])
        cnt += 1
print(cnt)