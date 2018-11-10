package com.github.dannil.scbjavaclient.test.utility;

import java.util.ArrayList;
import java.util.List;

import info.debatty.java.stringsimilarity.Cosine;
import info.debatty.java.stringsimilarity.interfaces.StringDistance;

public class Sorter {

    public static List<String> sortAccordingTo(List<String> toBeSorted, List<String> accordingTo) {
        String[] sortedArr = new String[toBeSorted.size()];
        for (int i = 0; i < toBeSorted.size(); i++) {
            String to = toBeSorted.get(i);
            String toLower = to.toLowerCase();
            double mostProbableDistance = Double.MAX_VALUE;
            int pos = -1;
            for (int j = 0; j < accordingTo.size(); j++) {
                String acc = accordingTo.get(j);
                String accLower = acc.toLowerCase().replaceAll("[^a-zA-Z]", "");
                StringDistance dis = new Cosine();
                double distance = Double.MAX_VALUE;
                String toLowerWithoutLast = toLower.substring(0, toLower.length() - 1);
                if (accLower.startsWith(toLowerWithoutLast)) {
                    // If the method parameter constitutes the beginning of the API
                    // parameter, it's very likely this is a match
                    //
                    // Due to falls positives, we need to set a likely distance, which
                    // has a high chance of being in the boundary
                    // actualDistance > x > falsePositiveDistance
                    //
                    // This value might need to be adjusted in the future
                    distance = 0.31;
                }
                distance = Math.min(distance, dis.distance(toLower, accLower));
                if (distance < mostProbableDistance) {
                    mostProbableDistance = distance;
                    pos = j;
                }
            }
            sortedArr[pos] = to;
        }
        List<String> sorted = new ArrayList<>(sortedArr.length);
        for (int i = 0; i < sortedArr.length; i++) {
            sorted.add(sortedArr[i]);
        }
        return sorted;
    }

}
