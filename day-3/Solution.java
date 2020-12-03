import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Solution {

	enum Slope {

		RIGHT_ONE_DOWN_ONE   (1, 1),
		RIGHT_THREE_DOWN_ONE (3, 1),
		RIGHT_FIVE_DOWN_ONE  (5, 1),
		RIGHT_SEVEN_DOWN_ONE (7, 1),
		RIGHT_ONE_DOWN_TWO   (1, 2);

		int right, down;

		Slope(int right, int down) {
			this.right = right;
			this.down = down;
		}
	}

	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("input.txt"));
		String[] lines = input.toArray(new String[0]);
		long result = 1;
		for (Slope slope : Slope.values()) {
			int trees = calculateNumTrees(lines, slope);
			System.out.println(String.format("Result for slope %s: %s", slope, trees));
			result = result * trees;
		}
		System.out.println(String.format("Final Result: %s", result));
	}

	// will not work if down > 2
	static int calculateNumTrees(String[] map, Slope slope) {
		int totalRight = 0, trees = 0;
		boolean down = false;
		for (int i = 0; i < map.length; i++) {
			if (down) {
				down = false;
				continue;
			}
			while (totalRight - 1 >= map[i].length() - 1) {
				// that doesn't look right too
				map[i] = map[i] + map[i];
			}
			char[] chars = map[i].toCharArray();
			if (chars[totalRight] == '#') {
				trees++;
			}
			int right = 0;
			for (char c : chars) {
				// there's probably a better way to do this
				if (right == slope.right) {
					if (slope.down > 1) {
						down = true;
					}
					break; // down
				}
				right++;
				totalRight++;
			}
		}
		return trees;
	}
}
