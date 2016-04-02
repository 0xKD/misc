#!/usr/bin/env python3

# coding=utf-8

from main import get_visited_houses
import unittest


class TestCode(unittest.TestCase):
	def test_visited_houses(self):
		self.assertEqual(get_visited_houses(">"), 2)
		self.assertEqual(get_visited_houses("^>v<"), 4)
		self.assertEqual(get_visited_houses("^v^v^v^v^v"), 2)


if __name__ == "__main__":
	unittest.main()
