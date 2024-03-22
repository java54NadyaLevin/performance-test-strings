package telran.performance.strings;

import telran.performance.PerformanceTest;
import telran.strings.SymbolsRemove;

public class SymbolsRemovePerformanceTest extends PerformanceTest {
	String str;
	char symbol;
	SymbolsRemove symbolsRemove;

	public SymbolsRemovePerformanceTest(String displayName, String str, int nRuns, SymbolsRemove symbolsRemove,
			char symbol) {
		super(displayName, nRuns);
		this.symbolsRemove = symbolsRemove;
		this.str = str;
		this.symbol = symbol;
	}

	@Override
	protected void runTest() {
		symbolsRemove.removeSymbol(str, symbol);

	}

}
