import time

def leonardo(n):
	if n in (0, 1):
		return 1
	return leonardo(n - 1) + leonardo(n - 2)

cache = {}
def leonardo_ncache(n):
	"""Naive caching (memoization)"""
	if n in (0, 1):
		return 1
	if n not in cache:
		cache[n] = leonardo_ncache(n - 1) + leonardo_ncache(n - 2)
	return cache[n]


if __name__ == "__main__":
	for i in range(30):
		print leonardo(i)

	print '*' * 30
	for i in range(50):
		print leonardo_ncache(i)
