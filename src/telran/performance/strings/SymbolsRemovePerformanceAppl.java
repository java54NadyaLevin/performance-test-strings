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
		String s = "";
		while (s.length() == 0) {
			s = getString(1);
		}
		char symbol = s.toCharArray()[0];

		SymbolsRemovePerformanceTest testCharsRemove = getTest(str, N_RUNS, "test of SymbolRemoveCharArray",
				new SymbolsRemoveCharArray(), symbol);
		SymbolsRemovePerformanceTest testStandardRemove = getTest(str, N_RUNS, "test of SymbolsRemoveStandard",
				new SymbolsRemoveStandard(), symbol);
		testStandardRemove.run();
		testCharsRemove.run();

	}

	private static SymbolsRemovePerformanceTest getTest(String str, int nRuns, String displayName,
			SymbolsRemove symbolsRemove, char symbol) {
		return new SymbolsRemovePerformanceTest(displayName, str, nRuns, symbolsRemove, symbol);
	}

	private static String getString(int nSymbols) {

		int lowerBound = 32; // Decimal value for space character
		int upperBound = 122; // Decimal value for tilde character (~)
		char[] exclude = { '<', '(', '[', '{', '\\', '^', '-', '=', '$', '!', '|', ']', '}', ')', '?', '*', '+', '.',
				'>' };
		StringBuilder randomString = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < nSymbols; i++) {
			int asciiValue = lowerBound + random.nextInt(upperBound - lowerBound + 1);
			boolean isExcluded = false;
			int j = 0;
			while (j < exclude.length && isExcluded == false) {
				if (exclude[j] == (char) asciiValue) {
					isExcluded = true;
				}
				j++;
			}
			if (isExcluded == false) {
				randomString.append((char) asciiValue);
			}
		}

		return randomString.toString();

	}

}
