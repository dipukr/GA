package main;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Anim extends JPanel {
	private byte[][] current;
	private byte[][][] frames;
	private int index = 0;

	public Anim(byte[][][] frames) {
		this.frames = frames;
		this.current = frames[0];

		Timer timer = new Timer(50, e -> {
			index++;
			if (index >= frames.length) {
				((Timer) e.getSource()).stop();
			} else {
				current = frames[index];
				repaint();
			}
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int tileSize = 80;
		int xpad = 30;
		int ypad = 35;
		g.setFont(new Font("SansSerif", Font.BOLD, 30));
		for (int r = 0; r < current.length; r++) {
			for (int c = 0; c < current[0].length; c++) {
				int x = c * tileSize;
				int y = r * tileSize;
				g.setColor(Color.BLACK);
				g.drawRect(x + xpad, y + ypad, tileSize, tileSize);
				if (current[r][c] != 0) {
					g.setColor(Color.green);
					g.fillRect(xpad + x + 1, ypad + y + 1, tileSize - 1, tileSize - 1);
					g.setColor(Color.BLACK);
					String text = String.valueOf(current[r][c]);
					FontMetrics fm = g.getFontMetrics();
					int tx = xpad + x + (tileSize - fm.stringWidth(text)) / 2;
					int ty = ypad + y + ((tileSize - fm.getHeight()) / 2) + fm.getAscent();
					g.drawString(text, tx, ty);
				}
			}
		}
	}
	
	public static void anim(Stack<State> states) {
		byte[][][] frames = new byte[states.size()][][];
		int count = 0;
		while (!states.isEmpty()) {
			frames[count] = states.pop().data;
			count += 1;
		}
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("8_Puzzle Game Animation");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new Anim(frames));
			frame.setSize(300, 320);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
