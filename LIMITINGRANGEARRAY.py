
def LimitingArray(arr):
	
	if len(a) == 0:
		return -1
	for i in range(0, len(a)):
		pointer = arr[i]
		count = 1
		for j in range(1, len(a)):
			if arr[j] == pointer:
				count += 1
		if count > 1:
			return pointer
	return 0


a = [1,2,3,2,4]
print(a, end="\n")
print(LimitingArray(a))

