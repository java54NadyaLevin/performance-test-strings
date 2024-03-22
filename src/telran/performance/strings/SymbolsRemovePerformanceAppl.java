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
		char symbol = getString(1).toCharArray()[0];
		
		SymbolsRemovePerformanceTest testCharsRemove = getTest(str, N_RUNS, "test of SymbolRemoveCharArray",
				new SymbolsRemoveCharArray(), symbol);
		SymbolsRemovePerformanceTest testStandardRemove = getTest(str, N_RUNS, "test of SymbolsRemoveStandard",
				new SymbolsRemoveStandard(), symbol);
		testCharsRemove.run();
		testStandardRemove.run();

	}

	private static SymbolsRemovePerformanceTest getTest(String str, int nRuns, String displayName,
			SymbolsRemove symbolsRemove, char symbol) {
		return new SymbolsRemovePerformanceTest(displayName, str, nRuns, symbolsRemove, symbol);
	}

	private static String getString(int nSymbols) {

		int lowerBound = 65; // Decimal value for space character
		int upperBound = 122; // Decimal value for tilde character (~)
		StringBuilder randomString = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < nSymbols; i++) {
			int asciiValue = lowerBound + random.nextInt(upperBound - lowerBound + 1);
			randomString.append((char) asciiValue);
		}

		return new String(randomString);

	}

}
