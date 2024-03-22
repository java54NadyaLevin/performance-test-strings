package telran.strings;

public class StringsJoinOperator implements StringsJoin {

	@Override
	public String joinStrings(String[] array, String delimeter) {
		String str = array[0];
		for(int i = 1; i < array.length; i++) {
			str += delimeter + array[i];
		}
		return str;
	}

}
