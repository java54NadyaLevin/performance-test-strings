package telran.performance.strings.remove;

import java.util.Random;

import telran.strings.remove.SymbolsRemove;
import telran.strings.remove.SymbolsRemoveCharArray;
import telran.strings.remove.SymbolsRemoveStandard;

public class SymbolsRemovePerformanceAppl {
	private static final int N_SYMBOLS = 1000;
	private static final int N_RUNS = 1000;

	public static void main(String[] args) {
		String str = getString(N_SYMBOLS);

		char symbol = getString(1).toCharArray()[0];

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
		int upperBound = 126;

		StringBuilder randomString = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < nSymbols; i++) {
			int asciiValue = lowerBound + random.nextInt(upperBound - lowerBound + 1);

			randomString.append((char) asciiValue);

		}

		return randomString.toString();

	}

}
