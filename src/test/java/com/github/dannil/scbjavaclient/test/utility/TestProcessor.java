package com.github.dannil.scbjavaclient.test.utility;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.github.dannil.scbjavaclient.test.TestConstants;
import com.hypertino.inflector.English;

public class TestProcessor {

    public static boolean isJumbled(List<String> methodParameters, List<String> apiParameters) {
        // Sort method parameters according to API parameters
        List<String> sortedMethodParameters = Sorter.sortAccordingTo(methodParameters, apiParameters);

        Iterator<String> methodIterator = methodParameters.iterator();
        Iterator<String> sortedMethodIterator = sortedMethodParameters.iterator();
        while (methodIterator.hasNext() && sortedMethodIterator.hasNext()) {
            String methodParameter = methodIterator.next();
            String sortedMethodParameter = sortedMethodIterator.next();
            if (!Objects.equals(methodParameter, sortedMethodParameter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMissing(List<String> methodParameters, List<String> apiParameters) {
        // Easy test: check if the lists are of the same size
        // If not, they obviously doesn't contain the same parameters
        if (methodParameters.size() != apiParameters.size()) {
            return true;
        }

        Iterator<String> methodIterator = methodParameters.iterator();
        Iterator<String> apiIterator = apiParameters.iterator();
        while (methodIterator.hasNext() && apiIterator.hasNext()) {
            String methodParameter = methodIterator.next();
            String apiParameter = apiIterator.next();

            String modifiedApiParameter = new String(apiParameter);
            String modifiedMethodParameter = new String(methodParameter);

            Set<String> alreadyPluralized = TestConstants.ALREADY_PLURALIZED;

            // Remove trailing spaces
            modifiedApiParameter = modifiedApiParameter.trim();
            // Remove Swedish letters (there exists API parameters that have those for
            // some weird reason, such as "grounds för settlement" instead of "grounds for
            // settlement")
            modifiedApiParameter = toEnglish(modifiedApiParameter);

            String tempModifiedApiParameter = modifiedApiParameter.replaceAll("[^a-zA-Z]", "");

            StringBuilder builder = new StringBuilder(modifiedApiParameter);
            if (!alreadyPluralized.contains(tempModifiedApiParameter)) {
                // Replace / with "and"
                String toReplace = "/";
                String replaceWith = "and";
                int indexOfToReplace = modifiedApiParameter.indexOf(toReplace);
                if (indexOfToReplace > 0) {
                    builder.replace(indexOfToReplace, indexOfToReplace + toReplace.length(), replaceWith);
                    modifiedApiParameter = builder.toString();

                    int indexOfAnd = modifiedApiParameter.indexOf(replaceWith);

                    // Insert spaces before and after "and" to match API formatting
                    builder.insert(indexOfAnd, " ");
                    builder.insert(indexOfAnd + replaceWith.length() + 1, " ");

                    modifiedApiParameter = builder.toString();
                }
            }

            // Remove all characters EXCEPT alpha and whitespace
            modifiedApiParameter = modifiedApiParameter.replaceAll("[^a-zA-Z\\s]", "");

            tempModifiedApiParameter = modifiedApiParameter.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!alreadyPluralized.contains(tempModifiedApiParameter)) {
                // If the last character of the word is a letter and not
                // already pluralized, then we do it ourself
                modifiedApiParameter = pluralizeWord(modifiedApiParameter);
            }

            tempModifiedApiParameter = modifiedApiParameter.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!alreadyPluralized.contains(tempModifiedApiParameter)) {
                modifiedApiParameter = pluralizeWordsBeforePrepositions(modifiedApiParameter);
            }

            // Remove all non-alpha characters
            modifiedApiParameter = modifiedApiParameter.replaceAll("[^a-zA-Z]", "");

            String modifiedApiParameterLower = modifiedApiParameter.toLowerCase();
            String modifiedMethodParameterLower = modifiedMethodParameter.toLowerCase();

            int maLength = modifiedApiParameterLower.length();
            int mmLength = modifiedMethodParameterLower.length();

            // Is this a case of the API parameter not being pluralized correctly when
            // compared to the method parameter? Example: API parameter
            // industrialclassificationnacerev is written as method parameter
            // industrialclassifications, and as such the API parameter doesn't contain
            // the pluralization
            if (!modifiedApiParameterLower.contains(modifiedMethodParameterLower) && maLength >= mmLength) {
                builder = new StringBuilder(modifiedApiParameterLower);
                String commonPart = modifiedApiParameterLower.substring(0, modifiedMethodParameter.length() - 1);
                String commonPartPluralized = English.plural(commonPart);
                builder.replace(0, modifiedMethodParameterLower.length() - 1, commonPartPluralized);
                modifiedApiParameterLower = builder.toString();
            }
            if (!modifiedApiParameterLower.contains(modifiedMethodParameterLower)) {
                return true;
            }
        }
        return false;
    }

    private static String pluralizeWord(String word) {
        return English.plural(word);
    }

    private static String pluralizeWordsBeforePrepositions(String word) {
        List<String> parts = Arrays.asList(word.split(" "));
        String[] prepositions = new String[] { "at", "and", "of", };
        StringBuilder builder = new StringBuilder(word);
        for (int k = 0; k < prepositions.length; k++) {
            String preposition = prepositions[k];
            int position = word.indexOf(preposition);
            if (position > 0) {
                // Check for space before the supposed preposition (and, of, etc.)
                // If there is then it's an preposition and simply not a part of
                // a word (i.e. industrial classificATions)
                // System.out.println(modifiedApiParameter.charAt(position - 1));
                boolean isPreposition = (word.charAt(position - 1) == ' ');
                if (position >= 2 && isPreposition) {
                    boolean previousWordIsPluralized = false;
                    String wordBeforePreposition = parts.get(parts.indexOf(preposition) - 1);
                    int indexOfLast = position - 2;
                    char last = word.charAt(indexOfLast);
                    previousWordIsPluralized = (last == 's');
                    if (!previousWordIsPluralized) {
                        String wordBeforePrepositionPluralized = pluralizeWord(wordBeforePreposition);
                        int start = indexOfLast - wordBeforePreposition.length() + 1;
                        builder = builder.replace(start, indexOfLast + 1, wordBeforePrepositionPluralized);
                    }
                }
            }
        }
        return builder.toString();
    }

    private static String toEnglish(String word) {
        word = word.replace('å', 'a');
        word = word.replace('ä', 'a');
        word = word.replace('ö', 'o');
        return word;
    }
    
    public static boolean isPluralized(List<String> methodParameters) {
        for (String methodParameter : methodParameters) {
            boolean isPluralized = isPluralized(methodParameter);
            if (!isPluralized) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPluralized(String word) {
        String tempWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (TestConstants.ALREADY_PLURALIZED.contains(tempWord)) {
            return true;
        }
        String[] pluralizedEndings = { "s", "es" };
        for (int i = 0; i < pluralizedEndings.length; i++) {
            if (word.endsWith(pluralizedEndings[i])) {
                return true;
            }
        }
        return false;
    }

}
