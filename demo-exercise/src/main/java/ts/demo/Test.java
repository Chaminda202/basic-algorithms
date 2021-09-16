package ts.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("A", 1954, "aaa"));
        bookList.add(new Book("B", 1954, "zzz"));
        bookList.add(new Book("A", 1955, "bbb"));
        bookList.add(new Book("A", 1955, "ccc"));
        bookList.add(new Book("B", 1955, "qqqq"));
        bookList.add(new Book("C", 1955, "lll"));

        // (old, new) -> old)
        TreeMap<String, Book> stringBookTreeMap = bookList.stream()
                .collect(
                        Collectors.toMap(Book::getName, Function.identity(), (o1, o2) -> o1, TreeMap::new));
        System.out.println("Old value : " + stringBookTreeMap);

        // (old, new) -> new)
        TreeMap<String, Book> stringBookTreeMap2 = bookList.stream()
                .collect(
                        Collectors.toMap(Book::getName, Function.identity(), (o1, o2) -> o2, TreeMap::new));
        System.out.println("New value : " + stringBookTreeMap2);
    }
}
