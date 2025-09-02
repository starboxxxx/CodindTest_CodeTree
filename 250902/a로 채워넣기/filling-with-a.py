str1 = input()

list_str1 = list(str1)

list_str1[1] = "a"
list_str1[-2] = "a"

str1 = "".join(list_str1)

print(str1)
