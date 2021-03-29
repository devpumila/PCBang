package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import memberDAO.MemberDAO;

public class MemberBill extends JFrame implements ActionListener {

	private JButton payBtn, searchBtn, price1, price2, price3, price4, price5, price6,price7,price8,price9,price10;
	private JLabel info, selectedId;
	private JTextField searchT;
	private int time;

	// 패널 회원 이미지
	private String picture1 = "img/p1.jpg";
	private String picture2 = "img/p2.jpg";
	private String picture3 = "img/p3.jpg";
	private String picture4 = "img/p4.jpg";
	private String picture5 = "img/p5.jpg";
	private String picture6 = "img/p6.jpg";
	private String picture7 = "img/p7.jpg";
	private String picture8 = "img/p8.jpg";
	private String picture9 = "img/p9.jpg";
	private String picture10 = "img/p10.jpg";
	

	private String id;
	private int idselect = 0;
	private int payselect = 0;

	// 회원검색으로 넘겨주기위한 부분

	// 임시로 추가한 부분(텍스트박스)

	public MemberBill() {

		super("Kiosk");

		Container c = this.getContentPane();
		getContentPane().setLayout(null);

		// 테이블부분

		JPanel p = new JPanel();

		JLabel search = new JLabel("회원검색");
		search.setFont(new Font(null, Font.BOLD, 30));
		info = new JLabel("사용할 요금제를 선택해주세요");
		selectedId = new JLabel("");

		// 왼쪽
		price1 = new JButton("1시간");
		price2 = new JButton(new ImageIcon("D:\\eclipse-workspace\\pc\\img\\p2.jpg"));
		price3 = new JButton(new ImageIcon("D:\\eclipse-workspace\\pc\\img\\p3.jpg"));
		price4 = new JButton(new ImageIcon("D:\\eclipse-workspace\\pc\\img\\p4.jpg"));
		price5 = new JButton("");
		price6 = new JButton("");
		price7 = new JButton("");
		price8 = new JButton("");
		price9 = new JButton("");
		price10 = new JButton("");

		searchBtn = new JButton("검색");
		searchBtn.setFont(new Font(null, Font.BOLD, 30));
		searchT = new JTextField();
		payBtn = new JButton("결제");
		payBtn.setFont(new Font(null, Font.BOLD, 30));

		add(search);
		add(price1);
		add(price2);
		add(price3);
		add(price4);
		add(price5);
		add(price6);
		add(price7);
		add(price8);
		add(price9);
		add(price10);
		add(info);
		add(selectedId);
		add(payBtn);

		search.setBounds(735, 50, 130, 30);

		// 왼쪽
		price1.setBounds(30, 170, 250, 100);
		price2.setBounds(30, 300, 250, 100);
		price3.setBounds(30, 430, 250, 100);
		price4.setBounds(30, 560, 250, 100);
		price5.setBounds(30, 690, 250, 100);
		price6.setBounds(350, 170, 250, 100);
		price7.setBounds(350, 300, 250, 100);
		price8.setBounds(350, 430, 250, 100);
		price9.setBounds(350, 560, 250, 100);
		price10.setBounds(350, 690, 250, 100);

		info.setBounds(30, 100, 290, 40);
		info.setFont(new Font(null, Font.BOLD, 20));
		selectedId.setBounds(350, 100, 290, 40);
		selectedId.setFont(new Font(null, Font.BOLD, 20));
		payBtn.setBounds(700,750, 200, 40);

		// 회원검색부분
		searchBtn.setBounds(850, 100, 100, 40);
		searchT.setBounds(640, 100, 200, 40);
		searchT.setFont(new Font(null, Font.BOLD, 30));

		add(searchBtn);
		add(searchT);

		setBounds(460,50,1000, 900);
		setTitle(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// 이벤트
		price1.addActionListener(this);
		price2.addActionListener(this);
		price3.addActionListener(this);
		price4.addActionListener(this);
		price5.addActionListener(this);
		price6.addActionListener(this);
		searchBtn.addActionListener(this);
		payBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == price1) {
			info.setText("1시간이 선택되었습니다.");
			payselect = 1;

		} else if (e.getSource() == price2) {
			info.setText("2시간이 선택되었습니다.");
			payselect = 2;
		} else if (e.getSource() == price3) {
			info.setText("3시간이 선택되었습니다.");
			payselect = 3;
		} else if (e.getSource() == price4) {
			info.setText("4시간이 선택되었습니다.");
			payselect = 4;
		} else if (e.getSource() == price5) {
			info.setText("5시간이 선택되었습니다.");
			payselect = 5;
		} else if (e.getSource() == price6) {
			info.setText("10시간이 선택되었습니다.");
			payselect = 6;
		} else if (e.getSource() == searchBtn) {
			 MemberSearch();
		} else if (e.getSource() == payBtn) {
			 Pay();
		}

	}

   private void Pay() {
      if (idselect == 0) {
         JOptionPane.showMessageDialog(this, "아이디를 선택해주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
         return;
      } else if (payselect == 0) {
         JOptionPane.showMessageDialog(this, "결제금액 선택해주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
         return;
      } else if (payselect == 1) {
         int result = JOptionPane.showConfirmDialog(this, id + "님" + " 1시간이 선택되었습니다.\n결제하시겠습니까?", "결제확인",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");
            Timeadd();
         }
      } else if (payselect == 2) {
         int result = JOptionPane.showConfirmDialog(this, id + "님" + " 2시간이 선택되었습니다.\n결제하시겠습니까?", "결제확인",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");
            Timeadd();
         }
      } else if (payselect == 3) {
         int result = JOptionPane.showConfirmDialog(this, id + "님" + " 3시간이 선택되었습니다.\n결제하시겠습니까?", "결제확인",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");
            Timeadd();
         }
      } else if (payselect == 4) {
         int result = JOptionPane.showConfirmDialog(this, id + "님" + " 4시간이 선택되었습니다.\n결제하시겠습니까?", "결제확인",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");
            Timeadd();
         }
      } else if (payselect == 5) {
         int result = JOptionPane.showConfirmDialog(this, id + "님" + " 5시간이 선택되었습니다.\n결제하시겠습니까?", "결제확인",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");
            Timeadd();
         }
      } else if (payselect == 6) {
         int result = JOptionPane.showConfirmDialog(this, id + "님" + " 10시간이 선택되었습니다.\n결제하시겠습니까?", "결제확인",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");
            Timeadd();
         }
      }
   }

   private void Timeadd() {
      String id = searchT.getText();
      MemberDAO memberDAO = MemberDAO.getInstance();
      int dbTime = memberDAO.getUserTime(id);
      time = 0;
      if(payselect==1) time = 120;
      else if(payselect==2) time=180;
      else if(payselect==3) time=240;
      else if(payselect==4) time=360;
      else if(payselect==5) time=720;
      else if(payselect==6) time=1800;
      time += dbTime;
      memberDAO.setTime(time,id);
   }

   private void MemberSearch() {
      id = searchT.getText();
      if (id.equals("")) {// 아이디텍스트 입력값 없을시
         JOptionPane.showMessageDialog(this, "검색할 아이디를 입력해주세요", "정보", JOptionPane.INFORMATION_MESSAGE);
         return;
      }
      int result = search(id);
      if (result == 0) {
         JOptionPane.showMessageDialog(this, "존재하지 않는 아이디입니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
      } else {
         selectedId.setText(id + "님이 선택되었습니다.");
         idselect = 1;
      }

   }

   private int search(String id) {
      MemberDAO memberDAO = MemberDAO.getInstance();
      // result가 0이면 db에 정보가 없음, 1이면 로그인성공
      int result = memberDAO.search(id);
      return result;
   }

	public static void main(String[] args) {
		new MemberBill();
	}

}