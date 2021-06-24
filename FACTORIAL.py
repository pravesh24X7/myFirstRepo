
def func(n):
	if n == 1 or n == 0:
		return 1
	return n * func(n-1)

print(func(int(input())))


