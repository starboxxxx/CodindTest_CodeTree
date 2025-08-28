# arr = lsit(map(int, input().split()))
# new_arr =[]

# for i in range(2,10):
#     arr.append(arr[i-1]+arr[i-2])
#     new_arr = arr % 10

#     print(new_arr)

num1, num2 = map(int, input().split())

nums = [];
nums.append(num1)
nums.append(num2)
for i in range(2, 10):
    newNum = (nums[i-1] + nums[i-2]) % 10
    nums.append(newNum)

for i in range(10):
    print(str(nums[i]), end=" ")
