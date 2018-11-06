package com.github.dannil.scbjavaclient.test.utility;

import java.util.ArrayList;
import java.util.List;

import info.debatty.java.stringsimilarity.Jaccard;
import info.debatty.java.stringsimilarity.interfaces.StringDistance;

public class Sorter {

    public static List<String> sortAccordingTo(List<String> toBeSorted, List<String> accordingTo) {
        String[] sortedArr = new String[toBeSorted.size()];
        StringDistance dis = new Jaccard();
        for (int i = 0; i < toBeSorted.size(); i++) {
            String to = toBeSorted.get(i);
            String toLower = to.toLowerCase();
            double mostProbableDistance = 1.0;
            int pos = -1;
            for (int j = 0; j < accordingTo.size(); j++) {
                String acc = accordingTo.get(j);
                String accLower = acc.toLowerCase();
                double distance = dis.distance(toLower, accLower);
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
