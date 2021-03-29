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

public class FindPwFrame extends JFrame implements ActionListener {
	// 변수 선언
	JLabel title = new JLabel("회원님의 [아이디] , [이름] , [이메일주소]를 입력해주세요", JLabel.CENTER);
	JLabel idL, nameL, emailL;
	JTextField idT, nameT, emailT;
	JButton findBtn = new JButton("찾기");
	JButton cancelBtn = new JButton("취소");

	public FindPwFrame() {

		// 선언부분
		idL = new JLabel("아  이  디", JLabel.RIGHT);
		nameL = new JLabel("이        름", JLabel.RIGHT);
		emailL = new JLabel("이  메  일", JLabel.RIGHT);
		idT = new JTextField();
		idT.setFont(new Font(null, Font.BOLD, 15));
		nameT = new JTextField();
		nameT.setFont(new Font(null, Font.BOLD, 15));
		emailT = new JTextField();
		emailT.setFont(new Font(null, Font.BOLD, 15));

		setLayout(null);

		// 타이틀
		title.setFont(new Font(null, Font.BOLD, 15));
		title.setForeground(Color.BLUE);
		title.setBounds(1, 20, 380, 20);
		add(title);

		// 아이디
		idL.setFont(new Font(null, Font.BOLD, 15));
		idL.setBounds(10, 105, 100, 30);
		idT.setBounds(120, 105, 200, 30);
		idT.setFont(new Font(null, Font.BOLD, 15));
		add(idL);
		add(idT);

		// 이름
		nameL.setFont(new Font(null, Font.BOLD, 15));
		nameL.setBounds(10, 70, 100, 30);
		nameT.setBounds(120, 70, 200, 30);
		nameT.setFont(new Font(null, Font.BOLD, 15));
		add(nameL);
		add(nameT);

		// 이메일
		emailL.setFont(new Font(null, Font.BOLD, 15));
		emailL.setBounds(10, 140, 100, 30);
		emailT.setBounds(120, 140, 200, 30);
		emailT.setFont(new Font(null, Font.BOLD, 15));
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
		setTitle("비밀번호찾기");
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
		String id = idT.getText();
		String name = nameT.getText();
		String email = emailT.getText();
		MemberDAO memberDAO = MemberDAO.getInstance();
		String pw = memberDAO.searchPW(name, id, email);
		if(pw==null) {
			JOptionPane.showMessageDialog(this, "잘못된 정보입력입니다", "정보", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "고객님의 비밀번호는 "+pw+" 입니다", "정보", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}

	public static void main(String[] args) {
		new FindPwFrame();
	}
}