#!/usr/bin/env python3

# coding=utf-8


def get_wrapping_area(dimens):
    l, b, h = dimens
    areas = [(2 * l * b), (2 * b * h), (2 * h * l)]
    smallest_side = min(areas)
    return sum(areas) + smallest_side // 2


def split_line(line):
    return tuple(int(x) for x in line.split('x'))


if __name__ == '__main__':
    with open('input.txt', 'r') as f:
        surface = sum(get_wrapping_area(split_line(line)) for line in f)
        print(surface)
