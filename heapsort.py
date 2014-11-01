#!/bin/bash
import random

def swap(to_sort, x, y):
	tmp = to_sort[x]
	to_sort[x] = to_sort[y]
	to_sort[y] = tmp

def heapsort(to_sort):
	#convert to a heap
	for start in range(len(to_sort)-2/2, -1, -1):
		siftdown(to_sort, start, len(to_sort) - 1)

	for end in range(len(to_sort)-1, 0, -1):
		swap(to_sort, 0, end)
		siftdown(to_sort, 0, end - 1)

def siftdown(to_sort, start, end):
	root = start
	while True:
		child = root * 2 + 1
		if child > end: break
		if child + 1 <= end and to_sort[child] < to_sort[child + 1]:
			child += 1

		if to_sort[root] < to_sort[child]:
			swap(to_sort, root, child)
			root = child	
		else:
			break


if __name__ == '__main__':
	integers = []
	for i in range(0, 100):
		integers.append((random.randrange(0,100)))
	
	print integers
	heapsort(integers)
	print integers