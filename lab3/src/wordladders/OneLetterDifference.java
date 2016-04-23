package wordladders;

public class OneLetterDifference implements GraphStrategy {

    public boolean adjacent(String word1, String word2) {
        int charDiff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                charDiff++;
            }
        }
        if (charDiff == 1) {
            return true;
        }
        return false;
    }

}
