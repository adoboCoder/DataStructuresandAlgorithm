import java.util.*;
/*
1.
Suppose you have a library of books. Each book is represented as a list of strings (words in the book), 
and the library is an array of these lists of strings. Return a list of the words that occur in every book.
*/

class QualtricsPhoneScreen1 {
    public static List<String> commonWordInEveryBook(List<List<String>> books) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (List<String> book : books) {
            for (String word : book) {
                set.add(word);
            }
        }
        for (String word : set) {
            if (books.stream().allMatch(book -> book.contains(word))) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> books = new ArrayList<>();
        books.add(Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"));
        books.add(Arrays.asList("the", "fox", "jumps", "over", "the", "lazy", "dog"));
        books.add(Arrays.asList("the", "lazy", "dog"));
        books.add(Arrays.asList("the", "brown", "fox", "jumps", "over", "the", "lazy", "dog"));

        System.out.println(QualtricsPhoneScreen1.commonWordInEveryBook(books));
    }
}
