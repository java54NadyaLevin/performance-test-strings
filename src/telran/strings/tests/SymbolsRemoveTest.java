package telran.strings.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import telran.strings.SymbolsRemoveCharArray;
import telran.strings.SymbolsRemoveStandard;

class SymbolsRemoveTest {

	@Test
	@DisplayName("For method based on String.replaceAll")
	void symbolsRemoveStandardTest() {
		String testString = "To be or not to be";
		SymbolsRemoveStandard instance = new SymbolsRemoveStandard();
		assertEquals("Tobeornottobe", instance.removeSymbol(testString, ' '));
		assertEquals("o be or not to be", instance.removeSymbol(testString, 'T'));
		assertEquals("T be r nt t be", instance.removeSymbol(testString, 'o'));
		assertEquals("To be or not to be", instance.removeSymbol(testString, 'X'));
		assertEquals("To b or not to b", instance.removeSymbol(testString, 'e'));

	}

	@Test
	@DisplayName("For method based on Char")
	void symbolsRemoveCharArrayTest() {
		String testString = "To be or not to be";
		SymbolsRemoveCharArray instance = new SymbolsRemoveCharArray();
		assertEquals("Tobeornottobe", instance.removeSymbol(testString, ' '));
		assertEquals("o be or not to be", instance.removeSymbol(testString, 'T'));
		assertEquals("T be r nt t be", instance.removeSymbol(testString, 'o'));
		assertEquals("To be or not to be", instance.removeSymbol(testString, 'X'));
		assertEquals("To b or not to b", instance.removeSymbol(testString, 'e'));

	}
}
