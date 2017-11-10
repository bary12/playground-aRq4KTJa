package com.yourself;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.yourself.TechIOUtil;

import org.junit.Assert;
import org.junit.Test;

public class UniverseTest {

	@Test
	public void test() throws FileNotFoundException {
		try {
			Assert.assertEquals("Running Universe.countAllStars(2, 3)...", 5, Universe.countAllStars(2, 3));
			Assert.assertEquals("Running Universe.countAllStars(9, -3)...", 6, Universe.countAllStars(9, -3));
			TechIOUtil.success(true);

			if (existsInFile("Arrays.stream(galaxies).sum()", new File("./src/main/java/com/yourself/Universe.java"))) {
				TechIOUtil.msg("My personal Yoda, you are. 🙏", "* ● ¸ .　¸. :° ☾ ° 　¸. ● ¸ .　　¸.　:. • ");
				TechIOUtil.msg("My personal Yoda, you are. 🙏", "           　★ °  ☆ ¸. ¸ 　★　 :.　 .   ");
				TechIOUtil.msg("My personal Yoda, you are. 🙏", "__.-._     ° . .　　　　.　☾ ° 　. *   ¸ .");
				TechIOUtil.msg("My personal Yoda, you are. 🙏", "'-._\\7'      .　　° ☾  ° 　¸.☆  ● .　　　");
				TechIOUtil.msg("My personal Yoda, you are. 🙏", " /'.-c    　   * ●  ¸.　　°     ° 　¸.    ");
				TechIOUtil.msg("My personal Yoda, you are. 🙏", " |  /T      　　°     ° 　¸.     ¸ .　　  ");
				TechIOUtil.msg("My personal Yoda, you are. 🙏", "_)_/LI");
			} else {
				TechIOUtil.msg("Kudos 🌟", "Did you know that since Java8 is out you can use streams? Try it!");
				TechIOUtil.msg("Kudos 🌟", "");
				TechIOUtil.msg("Kudos 🌟", "int[] galaxies = {37, 3, 2};");
				TechIOUtil.msg("Kudos 🌟", "int totalStars = Arrays.stream(galaxies).sum(); // 42");
			}
		} catch (AssertionError ae) {
			TechIOUtil.success(false);
			TechIOUtil.msg("Oops! 🐞", ae.getMessage());
			TechIOUtil.msg("Hint 💡", "Did you properly accumulate all stars into 'totalStars'? 🤔");
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