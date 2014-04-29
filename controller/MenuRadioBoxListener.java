package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class MenuRadioBoxListener implements ActionListener{
	private JRadioButton e1, e2, e3, e4;
	
	public MenuRadioBoxListener(JRadioButton r1, JRadioButton r2){
		this.e1 = r1;
		this.e2 = r2;
		e3 = new JRadioButton();
		e4 = new JRadioButton();
	}
	
	public MenuRadioBoxListener(JRadioButton r1, JRadioButton r2, JRadioButton r3, JRadioButton r4){
		this.e1 = r1;
		this.e2 = r2;
		this.e3 = r3;
		this.e4 = r4;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton auxButton = (JRadioButton) e.getSource();
		String func = auxButton.getName();
			
		if(func.equals("e1")){
			e1.setSelected(true);
			e2.setSelected(false);
			e3.setSelected(false);
			e4.setSelected(false);
		}
		else if(func.equals("e2")){
			e1.setSelected(false);
			e2.setSelected(true);
			e3.setSelected(false);
			e4.setSelected(false);
		}
		else if(func.equals("e3")){
			e1.setSelected(false);
			e2.setSelected(false);
			e3.setSelected(true);
			e4.setSelected(false);
		}
		else if(func.equals("e4")){
			e1.setSelected(false);
			e2.setSelected(false);
			e3.setSelected(false);
			e4.setSelected(true);
		}
	}

}
