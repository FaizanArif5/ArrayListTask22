import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WordCount {

    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount = (WordCount) o;
        return count == wordCount.count && word.equals(wordCount.word);
    }

    @Override
    public int hashCode() {
        int result = word.hashCode();
        result = 31 * result + count;
        return result;
    }

    public static void main(String[] args) {
        String text = "The Indus Valley Civilisation, also known as the Indus Civilisation, was a Bronze Age civilisation in the northwestern regions of South Asia, lasting from 3300 BCE to 1300 BCE, and in its mature form 2600 BCE to 1900 BCE.";

        ArrayList<String> words = new ArrayList<>();
        String[] textSplit = text.split("\\s+");
        for (String word : textSplit) {
            words.add(word);
        }

        System.out.println("Total Words: " + words.size());

        String[] sentences = text.split("\\.");
        System.out.println("Total Sentences: " + sentences.length);

        HashSet<Character> uniqueCharacters = new HashSet<>();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                uniqueCharacters.add(Character.toLowerCase(ch));
            }
        }
        System.out.println("Unique Characters: " + uniqueCharacters.size());

        HashMap<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies:");
        for (String word : wordFrequency.keySet()) {
            System.out.println(word + ": " + wordFrequency.get(word));
        }
    }
}
