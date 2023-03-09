package NotepadProject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NPWindowAction extends WindowAdapter {

	Notepad np;

	public NPWindowAction(Notepad np) {
		super();
		this.np = np;
	}
	@Override
	public void windowClosing(WindowEvent e) {
		
		CustmDialogBox d;
		if(np.textarea.getText().length()>0) {
			d=new CustmDialogBox(np);
		}else{
			System.exit(np.EXIT_ON_CLOSE);
		}
	}
}
