#!/usr/bin/env python3

# coding=utf-8


class Point():
	def __init__(self, x=0, y=0):
		self.x = x
		self.y = y

	def add(self, x, y):
		self.x += x
		self.y += y

	def __str__(self):
		return '{}.{}'.format(self.x, self.y)


def get_visited_houses(route):
	current = Point(0, 0)
	visited = {str(current)}
	direction_map = {
		'>': (1, 0),
		'<': (-1, 0),
		'^': (0, 1),
		'v': (0, -1),
	}
	for direction in route:
		current.add(*direction_map[direction])
		visited.add(str(current))
	return len(visited)


if __name__ == "__main__":
	with open("input.txt", "r") as f:
		input_str = f.readline().strip()
		print(get_visited_houses(input_str))
