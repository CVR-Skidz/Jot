import javax.swing.*;

public class JotInput extends JTextField{
	//TODO padding, border, colors
	public int width;
	
	public JotInput(String defaultValue, int width) {
		super(defaultValue);
		
		this.width = width/getColumnWidth();
		
		setColumns(this.width);

	}

}
