import java.util.ArrayList;
import java.util.List;

public class WordChecker {
    /** Initialized in the constructor and contains no null elements */
    private ArrayList<String> wordList;

    /**
     * Returns true if each element of wordList (except the first) contains the
     * previous
     * element as a substring and returns false otherwise, as described in part (a)
     * Precondition: wordList contains at least two elements.
     * Postcondition: wordList is unchanged.
     */
    public boolean isWordChain() {
        for (int i = 1; i < wordList.size(); i++) {
            if (!wordList.get(i).contains(wordList.get(i - 1)))
                return false;
        }
        return true;
    }

    /**
     * Returns an ArrayList<String> based on strings from wordList that start
     * with target, as described in part (b). Each element of the returned ArrayList
     * has had
     * the initial occurrence of target removed.
     * Postconditions: wordList is unchanged.
     * Items appear in the returned list in the same order as they appear in
     * wordList.
     */
    public ArrayList<String> createList(String target) {
        List<String> list = wordList.stream().filter(w -> w.startsWith(target)).map(w -> w.substring(target.length()))
                .toList();
        ArrayList<String> streamsAreCool = new ArrayList<>();
        for (String s : list)
            streamsAreCool.add(s);
        return streamsAreCool;
    }
    // There may be instance variables, constructors, and methods that are not
    // shown.

    public static void main(String args[]) {
        WordChecker chainTestOne = new WordChecker();
        chainTestOne.wordList = new ArrayList<>();
        chainTestOne.wordList.addAll(List.of("an", "band", "band", "abandon"));
        WordChecker chainTestTwo = new WordChecker();
        chainTestTwo.wordList = new ArrayList<>();
        chainTestTwo.wordList.addAll(List.of("to", "too", "stool", "tools"));
        System.out.println(chainTestOne.isWordChain());
        System.out.println(chainTestTwo.isWordChain());
        ArrayList<String> words = new ArrayList<>();
        words.addAll(List.of("catch", "bobcat", "catchacat", "cat", "at"));
        WordChecker createListTest = new WordChecker();
        createListTest.wordList = words;
        System.out.println(createListTest.createList("cat"));
        System.out.println(createListTest.createList("catch"));
        System.out.println(createListTest.createList("dog"));
    }
}
