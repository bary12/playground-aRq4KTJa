package com.yourself;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class UniverseTest {

	@Test
	public void test() throws FileNotFoundException {
		try {
			Assert.assertEquals("Running Universe.countAllStars(2, 3)...", 5, Universe.countAllStars(2, 3));
			Assert.assertEquals("Running Universe.countAllStars(9, -3)...", 6, Universe.countAllStars(9, -3));
			Util.success(true);

			if (existsInFile("Arrays.stream(galaxies).sum()", new File("./src/main/java/com/yourself/Universe.java"))) {
				Util.msg("My personal Yoda, you are. 🙏", "* ● ¸ .　¸. :° ☾ ° 　¸. ● ¸ .　　¸.　:. • ");
				Util.msg("My personal Yoda, you are. 🙏", "           　★ °  ☆ ¸. ¸ 　★　 :.　 .   ");
				Util.msg("My personal Yoda, you are. 🙏", "__.-._     ° . .　　　　.　☾ ° 　. *   ¸ .");
				Util.msg("My personal Yoda, you are. 🙏", "'-._\\7'      .　　° ☾  ° 　¸.☆  ● .　　　");
				Util.msg("My personal Yoda, you are. 🙏", " /'.-c    　   * ●  ¸.　　°     ° 　¸.    ");
				Util.msg("My personal Yoda, you are. 🙏", " |  /T      　　°     ° 　¸.     ¸ .　　  ");
				Util.msg("My personal Yoda, you are. 🙏", "_)_/LI");
			} else {
				Util.msg("Kudos 🌟", "Did you know that since Java8 is out you can use streams? Try it!");
				Util.msg("Kudos 🌟", "");
				Util.msg("Kudos 🌟", "int[] galaxies = {37, 3, 2};");
				Util.msg("Kudos 🌟", "int totalStars = Arrays.stream(galaxies).sum(); // 42");
			}
		} catch (AssertionError ae) {
			Util.success(false);
			Util.msg("Oops! 🐞", ae.getMessage());
			Util.msg("Hint 💡", "Did you properly accumulate all stars into 'totalStars'? 🤔");
		}
	}

	// check if a string exists in a text file
	private static boolean existsInFile(String str, File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		try {
			while (scanner.hasNextLine()) {
				if (scanner.nextLine().contains(str))
					return true;
			}
			return false;
		} finally {
			scanner.close();
		}
	}
}