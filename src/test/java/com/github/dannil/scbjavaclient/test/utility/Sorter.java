package com.github.dannil.scbjavaclient.test.utility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.hypertino.inflector.English;

import info.debatty.java.stringsimilarity.Cosine;
import info.debatty.java.stringsimilarity.interfaces.StringDistance;

public class Sorter {

    public static List<String> sortAccordingTo(List<String> toBeSorted, List<String> accordingTo) {
        String[] sortedArr = new String[toBeSorted.size()];
        StringDistance comparer = new Cosine();

        for (String to : toBeSorted) {
            // Normalize value so we can perform comparison easier
            String toNormalized = normalize(to);

            int accIndex = 0;
            int mostProbableSortedPosition = -1;
            double mostProbableDistance = Double.MAX_VALUE;

            for (String acc : accordingTo) {
                // Normalize value so we can perform comparison easier
                String accNormalized = normalize(acc);

                double distance = Double.MAX_VALUE;

                String toNormalizedWithoutPluralization = English.singular(toNormalized);
                if (accNormalized.startsWith(toNormalizedWithoutPluralization)) {
                    // If the method parameter constitutes the beginning of the API
                    // parameter, it's very likely this is a match
                    //
                    // Due to false positives, we need to set a likely distance, which
                    // has a high chance of being in the boundary
                    // actualDistance < x < falsePositiveDistance
                    //
                    // This value might need to be adjusted in the future
                    distance = 0.31;
                }

                distance = Math.min(distance, comparer.distance(toNormalized, accNormalized));
                if (distance < mostProbableDistance) {
                    mostProbableDistance = distance;
                    mostProbableSortedPosition = accIndex;
                }

                accIndex++;
            }
            String parameterAtSortedPosition = sortedArr[mostProbableSortedPosition];
            if (parameterAtSortedPosition != null) {
                throw new UnsupportedOperationException("Position " + mostProbableSortedPosition
                        + " isn't empty, value is: " + parameterAtSortedPosition);
            }
            sortedArr[mostProbableSortedPosition] = to;
        }
        return Arrays.stream(sortedArr).collect(Collectors.toList());
    }

    private static String normalize(String word) {
        word = word.trim();
        word = word.replaceAll("[^a-zA-Z]", "");
        word = word.toLowerCase();
        return word;
    }

}
