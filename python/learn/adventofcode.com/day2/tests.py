#!/usr/bin/env python3

# coding=utf-8

from main import get_wrapping_area, split_line

import unittest


class TestCode(unittest.TestCase):
    def test_wrapping_area(self):
        self.assertEqual(get_wrapping_area((2, 3, 4)), 58)
        self.assertEqual(get_wrapping_area((1, 1, 10)), 43)

    def test_split_line(self):
        self.assertEqual(split_line('2x3x4'), (2, 3, 4))
        self.assertEqual(split_line('53x0x11'), (53, 0, 11))
        self.assertEqual(split_line('9x7x091'), (9, 7, 91))


if __name__ == '__main__':
    unittest.main()
