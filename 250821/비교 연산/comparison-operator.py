A, B = map(int, input().split())



a = list()
a.append(A >=B)
a.append(A >B)
a.append(A <=B)
a.append(A < B)
a.append(A == B)
a.append(A !=B)

for i in range(6):
    if a[i] == True:
        print(1)

    else:
        print(0)