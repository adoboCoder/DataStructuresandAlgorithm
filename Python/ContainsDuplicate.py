class Solution:
    def contains_duplicate(nums) -> bool:
        if len(nums) == len(set(nums)):
            return False
        else:
            return True
    
    if __name__ == '__main__':
        nums = [1,2,3,1]
        print(contains_duplicate(nums))

