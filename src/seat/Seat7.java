package seat;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import memberDAO.MemberDAO;

@SuppressWarnings("serial")
public class Seat7 extends JButton implements Runnable {
	private Font vacantF,normalF;
	private JLabel name;
	private LineBorder lb;
	private MemberDAO dao = new MemberDAO();
	public Seat7() {
		vacantF =new Font("Bahnschrift Light Condensed", Font.BOLD, 30);
		normalF = new Font("Bahnschrift Light Condensed", Font.BOLD, 15);
		dao.setSeatNum(7);
		setLayout(new GridLayout(1,1,0,0));
		name = new JLabel("[7��] �� �¼�",SwingConstants.CENTER);
		
		name.setFont(vacantF);
	
		add(name);
		
		setBackground(new Color(11,42,66));
		
		LineBorder lb = new LineBorder(new Color(7,94,143),5);
		this.setBorder(lb);
		
		Thread t = new Thread(this);
		t.start();
		
		setBounds(30,650,250,100);
		setVisible(true);
		
	}


	@Override
	public void run(){
		while(true){
			if(dao.getOnOff(7)==0) {
				this.setBackground(new Color(11,42,66));
				name.setFont(vacantF);
				lb = new LineBorder(Color.BLUE,5);
				String text = "[7��] �� �¼�";
				name.setText(text);
				this.setBorder(lb);
			}
			else if(dao.getOnOff(7)==1) {
				this.setBackground(new Color(72,121,57));
				name.setFont(normalF);
				String text1 ="[7]��   "+dao.getName(7)+" ��";
				String text2 ="�ܿ��ð�  :  "+(dao.getTime(7)/60)+" �ð�"
						+(dao.getTime(7)%60)+"  ��";
				name.setText(text1);
				try{Thread.sleep(1000);}
				catch(Exception e){e.printStackTrace();}
				name.setText(text2);
				lb = new LineBorder(Color.GREEN,5);
				this.setBorder(lb);	
			}
			repaint();			

			try{Thread.sleep(1000);}
			catch(Exception e){e.printStackTrace();}
		}//while
	}//run method
}//ClockMgr class
