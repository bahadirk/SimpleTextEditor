package gui;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.StyledDocument;

public class LineArea extends JTextArea implements CaretListener {

	TextArea textArea;
	StyledDocument document;

	public LineArea() {
		textArea = new TextArea();

		setSize(300, 600);
		setEditable(false);

	}

	public void caretUpdate(CaretEvent e) {
		displaySelectionInfo(e.getDot(), (TextArea) e.getSource());
	}

	private void displaySelectionInfo(final int dot, final TextArea textArea) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				int textAreaRowNumber = textArea.getLineCount();
				int lineAreaRowNumber = getLineCount();

				if (textAreaRowNumber == lineAreaRowNumber) {
					if (lineAreaRowNumber == 1) {
						setText("1");
					}
				} else {
					String currentText = getText();

					if (textAreaRowNumber > lineAreaRowNumber) {
						for (int i = lineAreaRowNumber; i < textAreaRowNumber; i++) {
							currentText += "\n" + Integer.toString(i + 1);
							setText(currentText);
						}
					}
				}

			}
		});
	}

	public CaretListener getRowPanelCaretListener() {
		return this;
	}

}
