# num1, num2 = map(int, input().split())

# nums = []
# nums.append(num1)
# nums.append(num2)
# for i in range(2, 10):
#     newNum = (nums[i-1] + nums[i-2]) % 10
#     nums.append(newNum)

# for i in range(10):
#     print(str(nums[i]), end=" ")








# nums = list(map(int, input().split()))


# for i in range(2,10):
#     val = (nums[i-1] + nums[i-2]) % 10
#     nums.append(val)


# for i in range(10):
#     print(nums[i], end = " ")








# nums = list(map(int, input().split()))

# for i in range(2,10):
#     nums.append((nums[i-2] + nums[i-1]) % 10)

# print(*nums)




nums = list(map(int, input().split()))

for i in range(2,10):
    nums.append((nums[i-2] + nums[i-1]) % 10)

for arr in nums:
    print(arr, end = " ")
