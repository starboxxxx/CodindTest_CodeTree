num = int(input())
i = 1

for i in range(100):
    i = num + i
    if i > 100:
        break
    elif 100 >= i >= 90:
        print("A", end = " ")
    elif 90 > i >= 80:
        print("B", end = " ")
    elif 80 > i >= 70:
        print("C", end = " ")
    elif 70 > i >= 60:
        print("D", end = " ")
    elif i < 60:
        print("F", end = " ")