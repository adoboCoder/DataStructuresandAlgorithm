from pytz import country_timezones


class Solution:
    def is_anagram(s, t) -> bool:
        if len(s) != len(t):
            return False

        count_s = {}
        count_t = {}

        for i in range(len(s)):
            count_s[s[i]] = 1 + count_s.get(s[i], 0)
            count_t[t[i]] = 1 + count_t.get(t[i], 0)
        return count_s == count_t

    if __name__ == '__main__':
        print(is_anagram('fried', 'fired'))
        print(is_anagram('tests', 'test'))