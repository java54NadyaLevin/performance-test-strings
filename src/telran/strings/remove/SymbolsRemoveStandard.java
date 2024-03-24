package telran.strings.remove;
public class SymbolsRemoveStandard implements SymbolsRemove {

	@Override
	public String removeSymbol(String str, char symbol) {
		return !needEscape(symbol) ? str.replaceAll(""+symbol, ""): str.replaceAll("\\"+symbol, "");
	}
	private static boolean needEscape(int character) {
		char[] exclude = { '<', '(', '[', '{', '\\', '^', '-', '=', '$', '!', '|', ']', '}', ')', '?', '*', '+', '.',
				'>' };
		boolean needEscape = false;
		int i = 0;
		while (i < exclude.length && !needEscape) {
			if (exclude[i] == (char) character) {
				needEscape = true;
			}
			i++;
		}
		return needEscape;
	}

}
