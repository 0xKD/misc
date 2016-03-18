# coding=utf-8

"""
Pass output of this code to dot:

$ python draw_heap.py > heap.dot
$ dot -Tpng heap.dot -o heap.png
"""


class Heap:
    """Heap implementation"""

    def __init__(self, arr):
        self.arr = arr

    def parent(self, child_index):
        return self.arr[child_index // 2]

    def left(self, parent_index):
        return self.arr[parent_index * 2]

    def right(self, parent_index):
        return self.arr[parent_index * 2 + 1]

    @staticmethod
    def max_heapify(arr, pos):
        if arr[pos] > arr[pos // 2]:
            arr[pos], arr[pos // 2] = arr[pos // 2], arr[pos]
            return Heap.max_heapify(arr, pos // 2)
        return arr

    @classmethod
    def heapify(cls, arr, max=True):
        """Create heap out of random array"""
        heap = [len(arr), arr[0]]
        for element in arr[1:]:
            heap.append(element)
            cls.max_heapify(heap, len(heap) - 1)
        return cls(heap)


class GraphvizHeap(Heap):
    """Draw dot graph from heap"""

    def get_node_children(self, pos):
        try:
            self.arr[pos * 2 + 1]
            return '\n'.join(['\t{} -> {};'.format(self.arr[pos], self.left(pos)),
                             '\t{} -> {};'.format(self.arr[pos], self.right(pos))])

        except IndexError:
            return ''

    def draw_dot_graph(self, pos=1):
        g = self.get_node_children(pos)
        if not g:
            return '*'
        return '\n'.join([g, self.draw_dot_graph(pos * 2),
                         self.draw_dot_graph(pos * 2 + 1)])

    def show_digraph(self):
        return 'digraph heap {{\n{0}\n}}'.format(
            self.draw_dot_graph().replace('\n*', ''))

if __name__ == "__main__":
    import random
    r = random.sample(range(1000), 11)
    h = GraphvizHeap.heapify(r)
    print(h.show_digraph())
