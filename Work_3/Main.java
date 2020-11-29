package Work_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        wordList();

        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Vodkin","83252364");
        phonebook.add("Morozov","84345464");
        phonebook.add("Galanin","83254734");
        phonebook.add("Lissov","832335464");
        phonebook.add("Galanin","83236664");
        phonebook.add("Vodkin","832354546");
        phonebook.add("Morozov","832535674");

        System.out.println("phone Vodkin: " + phonebook.getPhone("Vodkin"));
        System.out.println("phone Morozov: " + phonebook.getPhone("Morozov"));
        System.out.println("phone Lissov: " + phonebook.getPhone("Lissov"));

    }

    public static void wordList() {
        String[] words = {"dog", "cat", "pet", "lock", "mock", "lock", "java", "hate", "kent", "java", "coffee", "dog", "beta", "cat", "java" , "coffee",  "hate"};
        HashMap<String, Integer> map = new LinkedHashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);

        System.out.println(map);
        System.out.println("");

    }
}
