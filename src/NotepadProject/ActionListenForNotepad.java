package NotepadProject;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ActionListenForNotepad extends MouseAdapter implements ActionListener {

	Notepad myNP;

	public ActionListenForNotepad(Notepad myNP) {
		super();
		this.myNP = myNP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cap = e.getActionCommand();


		
		// For New

		 if (cap.equals("New")) {
			myNP.textarea.setText(null);
		}
		
		// for save
		 else if (cap.equals("Save")) {
			JFileChooser jfc = new JFileChooser("D:");
// Only text File  Filter
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Only text File(.txt)", ".text");
// apply
			jfc.setAcceptAllFileFilterUsed(true);
			// type of file chooser

			jfc.addChoosableFileFilter(filter);

			// show and its is return one status
			int r = jfc.showSaveDialog(null);
			// press the save button

			if (r != jfc.APPROVE_OPTION) {
				return;
			} else {
				String filename = jfc.getSelectedFile().getAbsolutePath().toString();
				if (!filename.contains(".txt"))
					filename += ".txt";

				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
					myNP.textarea.write(bw);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		 //Open file 
		 
		 else if (cap.contentEquals("Open")) {
				JFileChooser jfc = new JFileChooser();
				// Only text File Filter
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Only text File(.txt)", ".text");
				// apply
				jfc.setAcceptAllFileFilterUsed(true);
				// type of file chooser

				jfc.addChoosableFileFilter(filter);

				int Actions = jfc.showOpenDialog(null);
				if (Actions != jfc.APPROVE_OPTION) {
					return;
				} else {
					try {
						BufferedReader reader = new BufferedReader(new FileReader(jfc.getSelectedFile()));
						myNP.textarea.read(reader, null);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}


			// print the file
		 
		else if (cap.equals("Print")) {
			try {
				myNP.textarea.print();
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}		
		
		else if(cap.equalsIgnoreCase("New Window")){
			//   myNP.textarea.
		}
		
		 //Exit NotePad
		else if (cap.equals("Exit")) {
			System.exit(myNP.EXIT_ON_CLOSE);
		}
		
		 
		
		// For Cut
		else if (cap.equals("Cut")) {
			myNP.textarea.cut();

		}
		// for Copy

		else if (cap.equals("Copy")) {
			myNP.textarea.copy();
		}
		// for Paste
		else if (cap.equals("Paste")) {
			myNP.textarea.paste();
		}
		// for selectAll Text
		else if (cap.equals("SelectAll")) {
			myNP.textarea.selectAll();
		}
		// for exit

		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3)
			myNP.pop.show(myNP.textarea, e.getX(), e.getY());

	}

}
