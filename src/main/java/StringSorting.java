package main.java;

public class StringSorting {
    public static void main(String[] args) {
        String input = "readable content of a page when looking at its layout";
        String output = sortByWordCharacterLength(input);
        System.out.println(output);
    }

    private static String sortByWordCharacterLength(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        String[] words = input.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].length() > words[maxIndex].length()) {
                    maxIndex = j;
                }
            }
            String temp = words[maxIndex];
            words[maxIndex] = words[i];
            words[i] = temp;
        }
        return String.join(" ", words);
    }
}
