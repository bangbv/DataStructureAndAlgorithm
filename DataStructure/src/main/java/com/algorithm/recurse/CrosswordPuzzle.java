package com.algorithm.recurse;

public class CrosswordPuzzle {

    static String[] crosswordPuzzle(String[] crosswork,String hints) {
    		String[] hints_a = hints.split(";");
    		Word[] w = new Word[10];
    		for(int i = 0;i<crosswork.length;i++) {
    			Word word = new Word();
    			for(int j = 0;j<10;j++) {
    				while(crosswork[i].charAt(j) == '-') {
    					if(word.start == null) {
    						XY start = new XY(i,j);
    					}
    					j++;
    				}
    				if(word.end == null) {
    					XY end = new XY(i,j);
    				}
    			}
    			w[i] = word;
    		}
    		return crosswordPuzzle(crosswork,hints);
    }
	
	public static void main(String[] args) {
		String[] input = {
				"+-++++++++",
				"+-++++++++",
				"+-------++",
				"+-++++++++",
				"+-++++++++",
				"+------+++",
				"+-+++-++++",
				"+++++-++++",
				"+++++-++++",
				"++++++++++"};
		String hints = "AGRA;NORWAY;ENGLAND;GWALIOR";
		System.out.println(crosswordPuzzle(input,hints));
	}

	
}
