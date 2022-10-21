class Solution:
    def containsDuplicate(nums) -> bool:
        if len(nums) == len(set(nums)):
            return False
        else:
            return True
    
    if __name__ == '__main__':
        nums = [1,2,3,1]
        print(containsDuplicate(nums))