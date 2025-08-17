package main;

public class Tools {
	public static void draw(State state) {
		draw(state.data);
	}
	
	public static void draw(byte[][] maze) {
		int rows = maze.length;
		int cols = maze[0].length;
		int max = 0;
		for (byte[] r: maze)
			for (byte v: r)
				max = Math.max(max, v);
		int cellW = Math.max(1, String.valueOf(max).length());
		String horiz = "+" + "-".repeat(cellW + 2);
		String rowSep = horiz.repeat(cols) + "+";
		System.out.println(rowSep);
		for (int i = 0; i < rows; i++) {
			var line = new StringBuilder();
			for (int j = 0; j < cols; j++) {
				String s = (maze[i][j] == 0) ? "" : Byte.toString(maze[i][j]);
				line.append("| ").append(padLeft(s, cellW)).append(" ");
			}
			line.append("|");
			System.out.println(line);
			System.out.println(rowSep);
		}
	}

	public static String padLeft(String s, int width) {
		int pad = width - s.length();
		return (pad <= 0) ? s : 
			" ".repeat(pad) + s;
	}
}
