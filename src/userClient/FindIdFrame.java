package userClient;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import memberDAO.MemberDAO;

public class FindIdFrame extends JFrame implements ActionListener {
	// 변수 선언
	JLabel title = new JLabel("회원님의 [이름]과 [이메일주소]를 입력해주세요", JLabel.CENTER);
	JLabel nameL, emailL;
	JTextField nameT, emailT;
	JButton findBtn = new JButton("찾기");
	JButton cancelBtn = new JButton("취소");

	public FindIdFrame() {

		// 선언부분
		nameL = new JLabel("이        름", JLabel.RIGHT);
		emailL = new JLabel("이  메  일", JLabel.RIGHT);
		nameT = new JTextField();
		nameT.setFont(new Font(null, Font.BOLD, 15));
		emailT = new JTextField();
		emailT.setFont(new Font(null, Font.BOLD, 15));

		setLayout(null);

		// 타이틀
		title.setFont(new Font(null, Font.BOLD, 15));
		title.setForeground(Color.BLUE);
		title.setBounds(35, 20, 320, 20);
		add(title);

		// 이름
		nameL.setFont(new Font(null, Font.BOLD, 15));
		nameL.setBounds(10, 80, 100, 30);
		nameT.setBounds(120, 80, 200, 30);
		add(nameL);
		add(nameT);

		// 이메일
		emailL.setFont(new Font(null, Font.BOLD, 15));
		emailL.setBounds(10, 130, 100, 30);
		emailT.setBounds(120, 130, 200, 30);
		add(emailL);
		add(emailT);

		// 하단버튼
		findBtn.setFont(new Font(null, Font.BOLD, 15));
		cancelBtn.setFont(new Font(null, Font.BOLD, 15));
		add(findBtn);
		add(cancelBtn);
		findBtn.setBounds(70, 200, 100, 40);
		findBtn.setContentAreaFilled(false);
		cancelBtn.setBounds(220, 200, 100, 40);
		cancelBtn.setContentAreaFilled(false);

		setBounds(760, 300, 400, 300);
		setVisible(true);
		setTitle("아이디찾기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 이벤트 호출
		findBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findBtn) {
			findBtn();
		} else if (e.getSource() == cancelBtn) {
			dispose();
		}
	}

	private void findBtn() {
		String name = nameT.getText();
		String email = emailT.getText();

		MemberDAO memberDAO = MemberDAO.getInstance();
		String id = memberDAO.searchID(name, email);
		if (id == null) {
			JOptionPane.showMessageDialog(this, "잘못된 정보입력입니다", "정보", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "고객님의 아이디는 " + id + " 입니다", "정보", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new FindIdFrame();
	}
}