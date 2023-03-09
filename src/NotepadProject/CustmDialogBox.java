package NotepadProject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustmDialogBox  extends JDialog{

	
	
	JLabel message;
	
	
	JButton  btnsave,btnCancle,btndnt;
	
	Notepad np;

	public CustmDialogBox(Notepad np) {
		
		
		 this();
	     this.np=np;
	
		
	}
	
	public CustmDialogBox() {
		setModal(true);
		setTitle("Notepad");
    //JPanel p=new JPanel();
		message=new JLabel("Do You want to save changes to Untitled?");
		btnsave=new JButton("Save");
		btndnt=new JButton("Don't Save");
		btnCancle=new JButton("Cancle");
		add(message);
		add(btnsave);
	     add(btndnt);
	     add(btnCancle);
	//	Dimension size=btnsave.getPreferredSize();
	     message.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
	     message.setBounds(120,70,400,30);
		btnsave.setBounds(100,230,90,30);
		btndnt.setBounds(250,230,120,30);
		btnCancle.setBounds(430,230,100,30);
		
		btndnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cap = e.getActionCommand();
				if(cap.equalsIgnoreCase("Don't Save")) {
					System.exit(EXIT_ON_CLOSE);
				}
				
			}
		});
		
		
		
		
		//getContentPane().add(p);
		setLayout(null);
		setSize(700,400);
		setLocation(120,120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new CustmDialogBox();
			}
	
}