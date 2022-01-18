package ca.hapke.util;

import java.util.Collection;
import java.util.List;

/**
 * @author Nathan Hapke
 */
public abstract class CollectionUtil {

	public static <T> T getRandom(T[] l) {
		int i = CollectionUtil.getRandomIndex(l);
		if (i == -1)
			return null;
		return l[i];
	}

	public static <T> T getRandom(List<T> l) {
		if (l == null || l.size() == 0)
			return null;

		int i = (int) (Math.random() * l.size());
		return l.get(i);
	}

	public static <T> int getRandomIndex(T[] l) {
		if (l == null)
			return -1;
		int length = l.length;
		return CollectionUtil.getRandomIndex(length);
	}

	public static <T> int getRandomIndex(Collection<T> l) {
		if (l == null)
			return -1;
		int length = l.size();
		return CollectionUtil.getRandomIndex(length);
	}

	public static int getRandomIndex(int length) {
		if (length == 0)
			return -1;
		return (int) (Math.random() * length);
	}
}
