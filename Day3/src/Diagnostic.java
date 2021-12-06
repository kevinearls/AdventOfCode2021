import com.kevinearls.adventofcode2021.common.MyUtils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Diagnostic {
    public static void main(String[] args) throws Exception {
        Diagnostic d = new Diagnostic();
        //List<String> data = d.getTestData();
        List<String> data = d.loadData();

        // Fpr part 1
        String gamma = d.getMostCommon(data);
        int gammaRate = d.convertToBinary(gamma);
        System.out.println("Gamma " + gamma + " binary: " + gammaRate);
        String epsilon = d.findEpsilon(gamma);
        int epsilonRate = d.convertToBinary(epsilon);
        System.out.println("Epsilon is: " + epsilon + " binary: " + epsilonRate);

        int powerConsumption = gammaRate * epsilonRate;
        System.out.println("PowerConsumption is " + powerConsumption) ;  // Correct answer for part1 is 3882564

        // For part 2
        String oxygenGeneratorRatingString = d.reduceToMostCommon(data);
        int oxygenGeneratorRating = d.convertToBinary(oxygenGeneratorRatingString);

        String scrubberRatingString = d.reduceToLeastCommon(data);
        int scrubberRating = d.convertToBinary(scrubberRatingString);

        System.out.println("Oxygen Rating " + oxygenGeneratorRating);
        System.out.println("Scrubber Rating " + scrubberRating);
        System.out.printf("Life support rating: " + (oxygenGeneratorRating * scrubberRating));  // 3385170
    }

    public static Predicate<String> isMostCommon(final int pos, char mostCommon) {
        return d -> d.charAt(pos) == mostCommon;
    }

    public static Predicate<String> isNotMostCommon(final int pos, char mostCommon) {
        return d -> d.charAt(pos) != mostCommon;
    }

    public String reduceToMostCommon(List<String> data) {
        int position = 0;
        while (data.size() > 1) {
            char mostCommon = findMostCommonBit(data, position);
            final int pos = position;
            data = data.stream()
                    .filter(isMostCommon(pos, mostCommon))
                    .collect(Collectors.toList());

            position++;
        }

        return data.get(0);
    }

    public String reduceToLeastCommon(List<String> data) {
        int position = 0;
        while (data.size() > 1) {
            char mostCommon = findMostCommonBit(data, position);
            final int pos = position;
            data = data.stream()
                    .filter(isNotMostCommon(pos, mostCommon))
                    .collect(Collectors.toList());

            position++;
        }

        return data.get(0);
    }


    public char findMostCommonBit(List<String> data, int position) {
        int count = 0;
        for (String d : data) {
            if (d.charAt(position) == '1') {
                count++;
            }
        }

        if (count*2 >= data.size()) {  // if equal retrun 1
            return '1';
        } else {
            return '0';
        }
    }

    public int convertToBinary(String bits) {
        int value = 0;

        int factor = 1;
        for (int i = bits.length() -1 ; i >= 0; i--) {
            if (bits.charAt(i) == '1') {
                value += factor;
            }
            factor *= 2;
        }

        return value;
    }

    public String findEpsilon(String gamma) {
        String epsilon = "";

        for (int i = 0 ; i< gamma.length() ; i++) {
            if (gamma.charAt(i) == '1') {
                epsilon += '0';
            } else {
                epsilon += "1";
            }
        }

        return epsilon;
    }

    public String getMostCommon(List<String> data) {
        String commonString = "";
        int[] common = new int[data.get(0).length()] ;
        // Do I need to initialize this?
        for (int i=0; i< data.get(0).length(); i++) {
            common[i] = 0;
        }

        for (String d:data) {
            for (int i=0; i < d.length(); i++) {
                if (d.charAt(i) == '1') {
                    common[i]++;
                }
            }
        }

        for (int i=0; i < common.length; i++) {;
            if (common[i] > (data.size()/2)) {
                commonString += "1";
            } else {
                commonString += "0";
            }
        }

        return commonString;
    }

    public List<String> loadData() throws Exception {
        String fileName = "Day3/resources/input.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }

    public List<String> getTestData() throws Exception{
        String fileName = "Day3/resources/test.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }
}
