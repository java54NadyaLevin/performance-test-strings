package telran.performance.strings;

import java.util.Random;

import telran.strings.SymbolsRemove;
import telran.strings.SymbolsRemoveCharArray;
import telran.strings.SymbolsRemoveStandard;

public class SymbolsRemovePerformanceAppl {
	private static final int N_SYMBOLS = 1000;
	private static final int N_RUNS = 1000;

	public static void main(String[] args) {
		String str = getString(N_SYMBOLS);
		// String.replaceAll method is considering first parameter as a regex,
		// so if getString method which generates symbol to remove, generates some
		// special symbol,
		// it causes an exception in replaceAll since it want this symbol to be escaped.
		// So some additional code was added to fix this problem
		
		String s = "";
		while (s.length() == 0) {
			s = getString(1);
		}
		char symbol = s.toCharArray()[0];

		SymbolsRemovePerformanceTest testCharsRemove = getTest("test of SymbolRemoveCharArray", str, N_RUNS,
				new SymbolsRemoveCharArray(), symbol);
		SymbolsRemovePerformanceTest testStandardRemove = getTest("test of SymbolsRemoveStandard", str, N_RUNS,
				new SymbolsRemoveStandard(), symbol);
		testStandardRemove.run();
		testCharsRemove.run();

	}

	private static SymbolsRemovePerformanceTest getTest(String displayName, String str, int nRuns,
			SymbolsRemove symbolsRemove, char symbol) {
		return new SymbolsRemovePerformanceTest(displayName, str, nRuns, symbolsRemove, symbol);
	}

	
	private static String getString(int nSymbols) {

		int lowerBound = 32; 
		int upperBound = 122; 

		StringBuilder randomString = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < nSymbols; i++) {
			int asciiValue = lowerBound + random.nextInt(upperBound - lowerBound + 1);

			if (!isExcluded(asciiValue)) {
				randomString.append((char) asciiValue);
			}
		}

		return randomString.toString();

	}

	private static boolean isExcluded(int character) {
		char[] exclude = { '<', '(', '[', '{', '\\', '^', '-', '=', '$', '!', '|', ']', '}', ')', '?', '*', '+', '.',
				'>' };
		boolean isExcluded = false;
		int i = 0;
		while (i < exclude.length && !isExcluded) {
			if (exclude[i] == (char) character) {
				isExcluded = true;
			}
			i++;
		}
		return isExcluded;
	}

}
