package com.github.dannil.scbjavaclient.test.utility;

import java.util.List;

import com.github.dannil.scbjavaclient.test.TestConstants;

public class TestProcessor {

    public static boolean isJumbled(List<String> methodParameters, List<String> apiParameters) {
        // Sort method parameters according to API parameters
        List<String> sortedMethodParameters = Sorter.sortAccordingTo(methodParameters, apiParameters);
        for (int i = 0; i < methodParameters.size(); i++) {
            String p1 = methodParameters.get(i);
            String p2 = sortedMethodParameters.get(i);
            if (!p1.equals(p2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMissingParameters(List<String> methodParameters, List<String> apiParameters) {
        for (int i = 0; i < methodParameters.size(); i++) {
            String methodParameter = methodParameters.get(i);
            String apiParameter = apiParameters.get(i).replaceAll(" ", "");

            System.out.println("M: " + methodParameter);
            System.out.println("A: " + apiParameter);

            String modifiedApiParameter = new String(apiParameter);
            StringBuilder builder = new StringBuilder(modifiedApiParameter);

            // Replace / with "and"
            String toReplace = "/";
            int indexOfToReplace = modifiedApiParameter.indexOf(toReplace);
            if (indexOfToReplace > 0) {
                builder.replace(indexOfToReplace, indexOfToReplace + toReplace.length(), "and");
                modifiedApiParameter = builder.toString();
            }

            String[] prependPluralized = new String[] { /* "at", */ "and", "of", };
            builder = new StringBuilder(modifiedApiParameter);
            for (int k = 0; k < prependPluralized.length; k++) {
                int position = modifiedApiParameter.indexOf(prependPluralized[k]);
                if (position >= 0 && modifiedApiParameter.charAt(position - 1) != 's') {
                    builder = builder.insert(position, "s");
                }
            }
            modifiedApiParameter = builder.toString();
            
            // Remove all non-alpha characters
            modifiedApiParameter = modifiedApiParameter.replaceAll("[^a-zA-Z]", "");

            // If the last character of the word is a letter and not
            // already pluralized, then we do it ourself
            if (!TestConstants.ALREADY_PLURALIZED.contains(modifiedApiParameter)) {
                String lastCharacter = apiParameter.substring(apiParameter.length() - 1);
                if (lastCharacter.matches("[xX]")) {
                    modifiedApiParameter += "es";
                } else if (lastCharacter.matches("[yY]")) {
                    // Remove the last y and replace it with ies
                    // Example: country becomes countries
                    String withoutLastLetter = modifiedApiParameter.substring(0, modifiedApiParameter.length() - 1);
                    modifiedApiParameter = withoutLastLetter + "ies";
                } else if (lastCharacter.matches("[s]")) {
                    modifiedApiParameter += "es";
                } else if (lastCharacter.matches("[a-zA-Z]")) {
                    modifiedApiParameter += 's';
                }
            }

            // There exists some cases which are nigh on impossible to
            // handle if the method parameter name is pluralized, so
            // lets remove that
            // String modifiedMethodParameter =
            // methodParameter.substring(0,
            // methodParameter.length() - 1);
            String modifiedMethodParameter = methodParameter;

            String modifiedApiParameterLower = modifiedApiParameter.toLowerCase();
            String modifiedMethodParameterLower = modifiedMethodParameter.toLowerCase();

            System.out.println("APL: " + modifiedApiParameterLower);
            System.out.println("MPL: " + modifiedMethodParameterLower);

            if (!modifiedApiParameterLower.contains(modifiedMethodParameterLower)) {

                // Is this a case of the API parameter not being
                // pluralized correctly when compared to the
                // method parameter?
                // Example: API parameter
                // industrialclassificationnacerev is written as
                // method parameter industrialclassifications, and as
                // such the API parameter doesn't contain the trailing
                // s
                StringBuilder b2 = new StringBuilder(modifiedApiParameterLower);
                System.out.println(modifiedMethodParameterLower);
                if (modifiedApiParameterLower.length() >= modifiedMethodParameterLower.length()) {
                    b2.insert(modifiedMethodParameterLower.length() - 1, "s");
                }

                modifiedApiParameterLower = b2.toString();
                System.out.println("B2: " + modifiedApiParameterLower);
                if (modifiedApiParameterLower.contains(modifiedMethodParameterLower)) {
                    continue;
                }

                // System.out.println("!!! " + clazz.getName() + " !!!");
                // missingParameters = true;
                // System.exit(1);
                // break;
                return true;
            }
        }
        return false;
    }

}
