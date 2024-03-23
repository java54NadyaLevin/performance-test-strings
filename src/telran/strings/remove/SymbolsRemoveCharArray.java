package telran.strings.remove;

public class SymbolsRemoveCharArray implements SymbolsRemove {

	@Override
	public String removeSymbol(String str, char symbol) {
		char[] array = str.toCharArray();
		int count = 0;
		char[] resultArray;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == symbol)
				count++;
		}
		
		if (count > 0) {
			resultArray = new char[array.length - count];
			for (int i = 0, j = 0; i < array.length; i++) {
				if (array[i] != symbol) {
					resultArray[j] = array[i];
					j++;
				}
			}
		} else
			resultArray = array;

		return new String(resultArray);
	}

}
