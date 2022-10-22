from typing import List

class Solution:
    def two_sum(nums: List[int], target: int)->List[int]:
        mymap = {}
        for i, n in enumerate(nums):
            diff = target - n
            if diff in mymap:
                return [mymap[diff], i]
            mymap[n] = i

    if __name__ == '__main__':
        nums = [2, 7, 11, 15]
        target = 9
        print(two_sum(nums, target))

