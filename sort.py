#!/bin/bash/python
import random

def swap(to_sort, x, y):
	tmp = to_sort[x]
	to_sort[x] = to_sort[y]
	to_sort[y] = tmp

def partition(to_sort, start, end):
	pivot = start + (end - start)/2

	print "pivot {0} start {1} end {2}".format(pivot, start, end)
	swap(to_sort, pivot, end)
	for i in range(start, end):
		if to_sort[i] <= to_sort[end]:
			swap(to_sort, i, start)
			start += 1
	swap(to_sort, start, end)
	return start		

def quicksort(to_sort, start, end):
	if start < end:
		pivot = partition(to_sort, start, end)
		quicksort(to_sort, start, pivot - 1)
		quicksort(to_sort, pivot + 1, end)


if __name__ == '__main__':
	integers = []
	for i in range(0,10000):
		integers.append((random.randrange(0,100)))
	
	print integers
	sorted = quicksort(integers, 0, len(integers) - 1)
	print integers
	
	