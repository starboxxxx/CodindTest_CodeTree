A_math, A_Eng = map(int, input().split())
B_math, B_Eng = map(int, input().split())

if A_math > B_math and A_Eng > B_Eng:
    print(1)
else:
    print(0)