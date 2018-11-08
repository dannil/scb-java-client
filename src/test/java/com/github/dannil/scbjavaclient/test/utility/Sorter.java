package com.github.dannil.scbjavaclient.test.utility;

import java.util.ArrayList;
import java.util.List;

import info.debatty.java.stringsimilarity.Cosine;
import info.debatty.java.stringsimilarity.Jaccard;
import info.debatty.java.stringsimilarity.MetricLCS;
import info.debatty.java.stringsimilarity.NGram;
import info.debatty.java.stringsimilarity.experimental.Sift4;
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
                System.out.println("ACCLOWER: " + accLower);
                // StringDistance dis = new Jaccard(Math.min(to.length(), acc.length()));

                StringDistance dis = null;
                double distance = Double.MAX_VALUE;

                // String toWithoutLast = toLower.substring(0, toLower.length() - 1);
                // if (accLower.startsWith(toWithoutLast)) {
                // dis = new MetricLCS();
                // System.out.println("Using metricLCS");
                // } else {
                // dis = new Cosine();
                // System.out.println("Using cosine");
                // }

                String toLowerWithoutLast = toLower.substring(0, toLower.length() - 1);
                if (accLower.startsWith(toLowerWithoutLast)) {
                    // If the method parameter constitutes the beginning of the API
                    // parameter, it's extremely likely this is a match
                    distance = 0.0;
                    // System.out.println("Using metricLCS");
                    // dis = new MetricLCS();

                    // int shortest = Math.min(accLower.length(), toLower.length());
                    //
                    // distance = dis.distance(toLower.substring(0, shortest),
                    // accLower.substring(0, shortest));
                } else {
                    System.out.println("Using cosine");
                    dis = new Cosine();
                    distance = dis.distance(toLower, accLower);
                }

                // double distance = dis.distance(toLower, accLower);
                System.out.println("TO: " + to + ", ACC: " + acc + ", DISTANCE: " + distance);
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
