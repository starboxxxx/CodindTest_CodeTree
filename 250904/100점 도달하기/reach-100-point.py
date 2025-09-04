num = int(input())
i = 1

for i in range(100):
    i = num + i
    if i > 100:
        break
    elif i >= 90:
        print("A", end = " ")
    elif i >= 80:
        print("B", end = " ")
    elif i >= 70:
        print("C", end = " ")
    elif i >= 60:
        print("D", end = " ")
    elif i < 60:
        print("F", end = " ")