A, B, C = map(int, input().split())



if A < B < C:
    print(B)
elif A < C < B:
    print(C)
elif B < A < C:
    print(A)
elif B < C < A:
    print(C)
elif C < A < B:
    print(A)
elif C < B < A:
    print(B)
