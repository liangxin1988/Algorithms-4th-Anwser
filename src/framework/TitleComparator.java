package framework;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class TitleComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		String[] str1 = arg0.split("\\.");
		String[] str2 = arg1.split("\\.");
		
		if(!str1[0].equals(str2[0])){
			return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]);
		}
		
		if(!str1[1].equals(str2[1])){
			return Integer.parseInt(str1[1]) - Integer.parseInt(str2[1]);
		}
		
		return Integer.parseInt(str1[2]) - Integer.parseInt(str2[2]);
	}
}