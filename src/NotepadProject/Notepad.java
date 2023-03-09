package NotepadProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Notepad extends JFrame {

	JFrame jf;
	JTextArea textarea;
	JMenuBar mb;
	JMenu file, edit, format, help;
	JMenuItem New, NewWindow,Open, Save, Print, Exit, Cut, Copy, Paste, SelectAll, ViewHelp, SendFeadback, about, WordWrap,
	fontitem;
	JPopupMenu pop;
	JMenuItem cut, copy, paste, selectAll;

	public Notepad() {
		super("MY Notepad");
		
		// notepad Icon Image 
		ImageIcon icon=new ImageIcon(getClass().getResource("notepad.png"));
		setIconImage(icon.getImage());

		
		// Text Area 
		
		textarea = new JTextArea(); 
		add(textarea);

// for text Font
	textarea.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));

// Scrolling 
		JScrollPane jsp = new JScrollPane(textarea);
		add(jsp);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		jsp.setBorder(BorderFactory.createEmptyBorder());
		
		
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);

		// Creating  menu  name 
		
		mb = new JMenuBar();
		setJMenuBar(mb);

		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		help = new JMenu("Help");

		mb.add(file);
		mb.add(edit);
		mb.add(format);
		mb.add(help);

//Creating MenuItem "File"

		New = new JMenuItem("New");
		NewWindow=new JMenuItem("New Window");
		Open = new JMenuItem("Open");
		Save = new JMenuItem("Save");
		Print = new JMenuItem("Print");
		Exit = new JMenuItem("Exit");

		file.add(New);
		file.add(NewWindow);
		file.add(Open);
		file.add(Print);
		file.add(Save);
		file.add(Exit);
		

		// Action after Click
		
		New.addActionListener(new ActionListenForNotepad(this));
		NewWindow.addActionListener(new ActionListenForNotepad(this));
		Open.addActionListener(new ActionListenForNotepad(this));
		Save.addActionListener(new ActionListenForNotepad(this));
		Print.addActionListener(new ActionListenForNotepad(this));
		Exit.addActionListener(new ActionListenForNotepad(this));

// for shortcut key 
		
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

		NewWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		
		Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));

		Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

		Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));

		


//Creating MenuItem "Edit"
		
		Cut = new JMenuItem("Cut");
		Copy = new JMenuItem("Copy");
		Paste = new JMenuItem("Paste");
		SelectAll = new JMenuItem("SelectAll");

		edit.add(Cut);
		edit.add(Copy);
		edit.add(Paste);
		edit.add(SelectAll);
		Cut.addActionListener(new ActionListenForNotepad(this));
		Copy.addActionListener(new ActionListenForNotepad(this));
		Paste.addActionListener(new ActionListenForNotepad(this));
		SelectAll.addActionListener(new ActionListenForNotepad(this));
		
		
	      Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));

			Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));

			Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));

			SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));

	

		

		ViewHelp = new JMenuItem("ViewHelp");
		SendFeadback = new JMenuItem("SendFeadback");
		about = new JMenuItem("About");
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));

		pop = new JPopupMenu();

//Creating MenuItem "PoppupMenu"

		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");

		paste = new JMenuItem("Paste");

		pop.add(cut);
		pop.add(copy);
		pop.add(paste);

		cut.addActionListener(new ActionListenForNotepad(this));

		copy.addActionListener(new ActionListenForNotepad(this));

		paste.addActionListener(new ActionListenForNotepad(this));

		textarea.addMouseListener(new ActionListenForNotepad(this));

//Creating MenuItem "Format"

//Creating MenuItem "Font Family"
		WordWrap = new JMenuItem("Word Wrap");
//Creating MenuItem "Font Style"
		fontitem = new JMenuItem("Font... ");
//Creating MenuItem "Font Size" in Java Text Editor
		//fontsize = new JMenuItem("Font Size");

		format.add(WordWrap);
		format.add(fontitem);
		
		//format.add(fontstyle);

//Creating List of Font Family and assigning the list values

//fontfamily.addActionListener(new ActionListenForNotepad(this));
//fontsize.addActionListener(new ActionListenForNotepad(this));
//fontstyle.addActionListener(new ActionListenForNotepad(this));

		help.add(ViewHelp);
		help.add(SendFeadback);
		help.add(about);

//addWindowFocusListener(new NPWindowAction(this));

		addWindowListener(new NPWindowAction(this));
		setLocation(100, 100);
		setSize(900, 500);
		setVisible(true);
//setDefaultCloseOperation(EXIT_ON_CLOSE);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new Notepad();
	}
}
