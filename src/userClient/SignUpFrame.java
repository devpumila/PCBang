package userClient;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import memberDAO.MemberDAO;
import memberDTO.MemberDTO;

public class SignUpFrame extends JFrame implements ActionListener {
	// 변수 선언
	JLabel title = new JLabel("회원가입", JLabel.CENTER);
	JLabel idL, pwL1, pwL2, nameL, numberL, eMailL, checkL, at;
	JTextField idT, nameT, numberT, eMailT1, eMailT2, checkT, adressT;
	JPasswordField pwT1, pwT2;
	JButton duplicateBtn, sendBtn;
	JButton createBtn = new JButton("회원가입");
	JButton eraseBtn = new JButton("취소");
	JButton checkBtn = new JButton("확인");
	String checkNum;
	JComboBox adressCB;

	int emailCheck, idCheck;

	public SignUpFrame() {

		// 선언부분
		nameL = new JLabel("이름", JLabel.RIGHT);
		idL = new JLabel("아이디", JLabel.RIGHT);
		pwL1 = new JLabel("비밀번호", JLabel.RIGHT);
		pwL2 = new JLabel("재확인", JLabel.RIGHT);
		numberL = new JLabel("휴대폰", JLabel.RIGHT);
		eMailL = new JLabel("이메일", JLabel.RIGHT);
		at = new JLabel("@");
		checkL = new JLabel("인증번호", JLabel.RIGHT);

		Container con = getContentPane();
		con.setLayout(null);

		String[] adressCombo = { "직접입력", "gmail.com", "naver.com", };
		adressCB = new JComboBox<String>(adressCombo);
		adressCB.setFont(new Font(null, Font.BOLD, 15));
		adressCB.setBounds(320, 280, 110, 30);

		con.add(adressCB);

		adressCB.addActionListener(this);

		idT = new JTextField();
		nameT = new JTextField();
		numberT = new JTextField();
		eMailT1 = new JTextField();
		eMailT2 = new JTextField();
		checkT = new JTextField();
		pwT1 = new JPasswordField();
		pwT2 = new JPasswordField();

		duplicateBtn = new JButton("중복체크");
		duplicateBtn.setFont(new Font(null, Font.BOLD, 15));

		sendBtn = new JButton("인증번호전송");
		sendBtn.setFont(new Font(null, Font.BOLD, 15));
		setLayout(null);

		checkBtn = new JButton("인증번호확인");
		checkBtn.setFont(new Font(null, Font.BOLD, 15));

		// 타이틀
		title.setFont(new Font(null, Font.BOLD, 35));
		title.setBounds(215, 10, 150, 40);
		add(title);

		// 이름
		nameL.setFont(new Font(null, Font.BOLD, 15));
		nameT.setFont(new Font(null, Font.BOLD, 15));
		nameL.setBounds(10, 80, 70, 30);
		nameT.setBounds(90, 80, 220, 30);
		add(nameL);
		add(nameT);

		// 아이디
		idL.setFont(new Font(null, Font.BOLD, 15));
		idT.setFont(new Font(null, Font.BOLD, 15));
		idL.setBounds(10, 120, 70, 30);
		idT.setBounds(90, 120, 220, 30);
		duplicateBtn.setBounds(320, 120, 130, 30);

		add(idL);
		add(idT);
		add(duplicateBtn);

		// 비밀번호
		pwL1.setFont(new Font(null, Font.BOLD, 15));
		pwT1.setFont(new Font(null, Font.BOLD, 15));
		pwL1.setBounds(10, 160, 70, 30);
		pwT1.setBounds(90, 160, 220, 30);
		add(pwL1);
		add(pwT1);

		// 재확인
		pwL2.setFont(new Font(null, Font.BOLD, 15));
		pwL2.setFont(new Font(null, Font.BOLD, 15));
		pwL2.setBounds(10, 200, 70, 30);
		pwT2.setBounds(90, 200, 220, 30);
		add(pwL2);
		add(pwT2);

		// 휴대폰
		numberL.setFont(new Font(null, Font.BOLD, 15));
		numberT.setFont(new Font(null, Font.BOLD, 15));
		numberL.setBounds(10, 240, 70, 30);
		numberT.setBounds(90, 240, 220, 30);
		add(numberL);
		add(numberT);

		// 이메일
		eMailL.setFont(new Font(null, Font.BOLD, 15));
		eMailT1.setFont(new Font(null, Font.BOLD, 15));
		eMailT2.setFont(new Font(null, Font.BOLD, 15));
		at.setFont(new Font(null, Font.BOLD, 15));
		at.setBounds(200, 285, 20, 20);
		eMailL.setBounds(10, 280, 70, 30);
		eMailT1.setBounds(90, 280, 105, 30);
		eMailT2.setBounds(220, 280, 90, 30);
		sendBtn.setBounds(440, 280, 130, 30);
		add(at);
		add(sendBtn);
		add(eMailL);
		add(eMailT1);
		add(eMailT2);

		// 인증
		checkL.setFont(new Font(null, Font.BOLD, 15));
		checkT.setFont(new Font(null, Font.BOLD, 15));
		checkL.setBounds(10, 320, 70, 30);
		checkT.setBounds(90, 320, 220, 30);
		checkBtn.setBounds(318, 320, 130, 30);
		add(checkBtn);
		add(checkL);
		add(checkT);

		// 하단버튼
		createBtn.setFont(new Font(null, Font.BOLD, 15));
		eraseBtn.setFont(new Font(null, Font.BOLD, 15));
		add(createBtn);
		add(eraseBtn);
		createBtn.setBounds(150, 380, 120, 40);
		eraseBtn.setBounds(310, 380, 120, 40);

		setBounds(675, 200, 600, 500);
		setVisible(true);
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 이벤트 호출
		createBtn.addActionListener(this);
		eraseBtn.addActionListener(this);
		duplicateBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		checkBtn.addActionListener(this);

	}

	public void eMailAdress() {
		String naver = "naver.com";
		String gmail = "gmail.com";

		if (adressCB.getSelectedItem() == naver)
			eMailT2.setText(naver);
		else if (adressCB.getSelectedItem() == gmail)
			eMailT2.setText(gmail);
		else
			eMailT2.setText("");
		eMailT2.requestFocus();

	}// actionPerformed
	// id 체크 후 결과값 받아서 0 == 사용가능, 1==사용중

	@Override
	public void actionPerformed(ActionEvent e) {
		String userEmail = eMailT1.getText() + "@" + eMailT2.getText();

		if (e.getSource() == createBtn) {
			create();
		} else if (e.getSource() == eraseBtn) {
			dispose();
		} else if (e.getSource() == duplicateBtn) {
			idCheck();
		} else if (e.getSource() == sendBtn) {
			System.out.println("SendBtn 눌림");
			checkNum = new SignUpMailSend().NaverMailSend(userEmail);// 유저의 이메일을 MailSend클래스로 보내고 인증번호를 가져옴
			JOptionPane.showMessageDialog(this, "인증 번호가 발송되었습니다", "정보", JOptionPane.INFORMATION_MESSAGE);
			emailCheck = 1;// 인증번호를발송받았는지 확인
		} else if (e.getSource() == checkBtn) {
			if (!checkNum.equals(checkT.getText())) {
				JOptionPane.showMessageDialog(this, "인증번호가 틀렸습니다, 다시 입력해 주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "인증번호가 확인되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == adressCB) {
			eMailAdress();
		}
	}

	private void erase() {
		idT.setText("");
		nameT.setText("");
		eMailT1.setText("");
		eMailT2.setText("");
		pwT1.setText("");
		pwT2.setText("");
		numberT.setText("");
		checkT.setText("");

	}

	public void idCheck() {
		String id = idT.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력해주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
		} else {
			MemberDAO memberDAO = new MemberDAO();
			int result = memberDAO.idCheck(id);
			if (result == 0) {
				JOptionPane.showMessageDialog(this, "사용가능한 아이디 입니다", "정보", JOptionPane.INFORMATION_MESSAGE);
				idCheck = 1;// ID중복확인버튼이 눌렸는지 확인*****************************
			} else if (result == 1) {
				JOptionPane.showMessageDialog(this, "사용중인 아이디 입니다", "정보", JOptionPane.INFORMATION_MESSAGE);
				idT.setText("");
				idCheck = 0;// ID중복확인버튼이 눌렸는지 확인*****************************
			}
		}
	}// idcheck method

	private void create() {

		String id = idT.getText();
		String pw = pwT1.getText();
		String name = nameT.getText();
		String phoneNumber = numberT.getText();
		String email = eMailT1.getText() + "@" + eMailT2.getText();
		int nonidcheck = 1;

		// 확인 취소or 예 아니요가 아니라 yes or no로 나올때는 주석 지워야함 이유는모름
		// String[] buttons = {"확인","취소"};

		int result = JOptionPane.showConfirmDialog(this, "회원가입을 하시겠습니까?", "회원가입", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		// JOptionPane.showOptionDialog(this, "회원가입을 하시겠습니까?", "회원가입",
		// JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		// buttons, "아니요");

		if (result == JOptionPane.YES_OPTION) {
			if (nameT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.\n이름을 입력해 주세요");

			} else if (idT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.\n아이디를 확인해 주세요");
			} else if (pwT1.getText().equals("") || pwT2.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.\n비밀번호를 확인해주세요.");
			} else if (pwT1.getText().equals(pwT2.getText()) == false) {
				JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.\n입력된 비밀번호가 다릅니다.");
			} else if (!checkNum.equals(checkT.getText())) {
				JOptionPane.showMessageDialog(this, "인증번호가 틀렸습니다, 다시 입력해 주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
			}

			else {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(id);
				memberDTO.setPw(pw);
				memberDTO.setName(name);
				memberDTO.setPhonenumber(phoneNumber);
				memberDTO.setEmail(email);
				memberDTO.setNonidcheck(nonidcheck);

				MemberDAO memberDAO = new MemberDAO();
				memberDAO.regist(memberDTO);
				JOptionPane.showMessageDialog(this, "회원가입에 성공했습니다.");
				dispose();
			}
		}
	}

	public static void main(String[] args) {
		new SignUpFrame();
	}

}