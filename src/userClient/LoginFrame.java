package userClient;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import memberDAO.MemberDAO;
import memberDTO.MemberDTO;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener, Runnable {

	private JButton join, close, loginLeft, loginRight, id, pw, card, member, nonMember, idFind, pwFind;
	private JTextField idText, cardText;
	private JPasswordField pwText;

	public LoginFrame() {

		// 사진
		JLabel display = new JLabel(new ImageIcon("img/login.jpg"));
		add(display);
		display.setBounds(0, 0, 1600, 670);

		// 로그인 필드
		idText = new JTextField();
		idText.setFont(new Font(null, Font.BOLD, 20));
		idText.setBounds(820, 720, 290, 30);
		idText.setOpaque(true);
		idText.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		// 패스워드
		pwText = new JPasswordField();
		pwText.setFont(new Font(null, Font.BOLD, 20));
		pwText.setBounds(820, 760, 290, 30);
		pwText.setOpaque(true);
		pwText.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		// 비회원 카드번호 입력창
		cardText = new JTextField();
		cardText.setFont(new Font(null, Font.BOLD, 20));
		cardText.setBounds(200, 740, 290, 30);
		cardText.setOpaque(true);
		cardText.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		add(idText);
		add(pwText);
		add(cardText);

		JPanel p = new JPanel();
		p.setLayout(null);

		// 선언부분
		nonMember = new JButton("비회원로그인");
		nonMember.setFont(new Font(null, Font.BOLD, 20));
		nonMember.setBorderPainted(false);
		nonMember.setFocusPainted(false);
		nonMember.setContentAreaFilled(false);
		member = new JButton("회원로그인");
		member.setFont(new Font(null, Font.BOLD, 20));
		member.setBorderPainted(false);
		member.setFocusPainted(false);
		member.setContentAreaFilled(false);
		card = new JButton("카드번호:");
		card.setFont(new Font(null, Font.BOLD, 20));
		card.setBorderPainted(false);
		card.setFocusPainted(false);
		card.setContentAreaFilled(false);
		id = new JButton("아이디");
		id.setFont(new Font(null, Font.BOLD, 20));
		id.setBorderPainted(false);
		id.setFocusPainted(false);
		id.setContentAreaFilled(false);
		pw = new JButton("비밀번호");
		pw.setFont(new Font(null, Font.BOLD, 20));
		pw.setBorderPainted(false);
		pw.setFocusPainted(false);
		pw.setContentAreaFilled(false);

		idFind = new JButton("아이디찾기");
		idFind.setFont(new Font(null, Font.BOLD, 15));

		pwFind = new JButton("비밀번호찾기");
		pwFind.setFont(new Font(null, Font.BOLD, 15));

		join = new JButton("회원가입");
		join.setFont(new Font(null, Font.BOLD, 20));
		close = new JButton("시스템종료");
		close.setFont(new Font(null, Font.BOLD, 20));

		loginLeft = new JButton("로그인");
		loginLeft.setFont(new Font(null, Font.BOLD, 20));

		loginRight = new JButton("로그인");
		loginRight.setFont(new Font(null, Font.BOLD, 20));

		add(join);
		add(close);
		add(loginLeft);
		add(loginRight);
		add(nonMember);
		add(member);
		add(card);
		add(id);
		add(pw);
		add(idFind);
		add(pwFind);

		// 각 버튼의 좌표
		join.setBounds(1420, 710, 140, 40);
		close.setBounds(1420, 780, 140, 40);
		loginLeft.setBounds(500, 735, 100, 40);
		loginRight.setBounds(1120, 735, 100, 40);
		nonMember.setBounds(215, 690, 240, 20);
		member.setBounds(845, 690, 240, 20);
		card.setBounds(85, 745, 130, 20);
		id.setBounds(705, 725, 100, 20);
		pw.setBounds(705, 765, 120, 20);
		idFind.setBounds(820, 810, 130, 30);
		pwFind.setBounds(980, 810, 130, 30);

		// 프레임 전체화면을 위한 메소드
		// 프레임 전체화면 해야하는 부분인데 전체화면시 화면전환이 용이하지 않아서 일단 뒤로 미뤄둠
		add(p);
		setBounds(200, 60, 1600, 900);
		setTitle(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// 이벤트
		join.addActionListener(this); // 회원가입 버튼 실행 이벤트
		close.addActionListener(this); // 시스템종료 이벤트
		loginLeft.addActionListener(this); // 비회원로그인
		loginRight.addActionListener(this); // 회원로그인
		idFind.addActionListener(this);
		pwFind.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == join) {
			// 회원가입 메소드 실행
			SignUpFrame suf = new SignUpFrame();
		} else if (e.getSource() == close) {
			// 시스템종료 메소드실행
			System.exit(0);

		} else if (e.getSource() == loginLeft) {
			// 비화원로그인메소드 실행
			nonMemberLogin();
		} else if (e.getSource() == idFind) {
			FindIdFrame fi = new FindIdFrame();
		} else if (e.getSource() == pwFind) {
			FindPwFrame fp = new FindPwFrame();
		} else if (e.getSource() == loginRight) {// 회원로그인
			MemberLogin();
		}

	}

	private void nonMemberLogin() {
		String cardid = cardText.getText();

		if (cardid.equals("")) {// 아이디텍스트 입력값 없을시
			JOptionPane.showMessageDialog(this, "카드번호를 확인해주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
			return;
		} 
		// 비회원 로그인
		int result = login(cardid);
		if (result == 0) {
			JOptionPane.showMessageDialog(this, "카드번호를 확인해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
		} else if (result == 1) {
			MemberDAO memberDAO = MemberDAO.getInstance();
			MemberDTO memberDTO = memberDAO.getMemberInfo(cardid);
			if (memberDTO.getTime() == 0) {
				JOptionPane.showMessageDialog(this, "잔여시간이부족합니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
			} else {
				dispose();
				InnerClientFrame icf = new InnerClientFrame(memberDTO);
			}
		}
	}

	private void MemberLogin() {
		String id = idText.getText();
		String pw = pwText.getText();

		if (id.equals("")) {// 아이디텍스트 입력값 없을시
			JOptionPane.showMessageDialog(this, "아이디를 입력해주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
			return;
		} else if (pw.equals("")) {// 비밀번호 텍스트 입력값 없을 시
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		// 회원 로그인
		int result = login(id, pw);
		if (result == 0) {
			JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호 오류입니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
		} else if (result == 1) {
			MemberDAO memberDAO = MemberDAO.getInstance();
			MemberDTO memberDTO = memberDAO.getMemberInfo(id, pw);
			if (memberDTO.getTime() == 0) {
				System.out.println(memberDTO.getTime());
				System.out.println(memberDTO.getName());
				JOptionPane.showMessageDialog(this, "잔여 시간이 없습니다", "정보", JOptionPane.INFORMATION_MESSAGE);
			} else {
				dispose();
				InnerClientFrame icf = new InnerClientFrame(memberDTO);
			}
		}

	}

	//회원 로그인
	private int login(String id, String pw) {
		MemberDAO memberDAO = MemberDAO.getInstance();
		// result가 0이면 db에 정보가 없음, 1이면 로그인성공
		int result = memberDAO.login(id, pw);
		return result;
	}
	
	//비회원 로그인
	private int login(String id) {
		MemberDAO memberDAO = MemberDAO.getInstance();
		// result가 0이면 db에 정보가 없음, 1이면 로그인성공
		int result = memberDAO.login(id);
		return result;
	}

	public static void main(String[] args) {
		new LoginFrame();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}