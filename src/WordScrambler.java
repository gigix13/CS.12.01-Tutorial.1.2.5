public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {

        scrambledWords = mixedWords(wordArr);

    }

    private String recombine(String word1, String word2) {

        String s = "";
        s += word1.substring(0, word1.length()/2);
        s += word2.substring(word2.length()/2);

        return s;
    }

    private String[] mixedWords(String[] words) {
        String[] w = new String[words.length];
        if(words.length % 2 == 1){
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        for(int i = 0; i < words.length; i++){
            if(words[i].indexOf(32)!=-1){
                throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
            }
            String s = "";
            if(i % 2 == 0){
                w[i] = recombine(words[i], words[i + 1]);
            }
            else{
                w[i] = recombine(words[i], words[i-1]);
            }

        }
        return w;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}
