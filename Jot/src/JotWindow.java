import java.awt.Dimension;
import java.awt.Container;
import java.util.HashMap;

import javax.swing.*;

public class JotWindow extends JFrame {
	public Dimension defaultSize;
	private JPanel container;
	private SpringLayout layout;
	private SpringLayout containerLayout;
	public HashMap<String, JComponent> children;

	/**
	 * Creates a new JotWindow instance, inheriting a JFrame
	 * 
	 * @param name   Title of widow
	 * @param width  Width of default size
	 * @param height Height of default size
	 */
	public JotWindow(String name, int width, int height) {
		super(name);
		
		layout = new SpringLayout();
		defaultSize = new Dimension(width, height);
		container = new JPanel();
		children = new HashMap<String, JComponent>();
		
		genForm(new String[]{"Words", "Noun"} ,175, container);
		add(container);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, container, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
		setLayout(layout);
		
		setSize(defaultSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void genForm(String[] labels, int width, Container parent) {
		for(String label : labels) {
			children.put(label, new JotInput(label, width));
			parent.add(children.get(label));
		}
	}

}
