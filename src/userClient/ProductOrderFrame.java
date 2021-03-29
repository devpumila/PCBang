package userClient;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductOrderFrame extends JFrame implements ActionListener {

	private Vector<String> vector, vector2;
	private DefaultTableModel model, model2;
	private JTable table, table2;
	private JButton add, delete, order, cancel;

	public ProductOrderFrame() {

		// 타이틀
		vector = new Vector<String>();
		vector.add("상품명");
		vector.add("가격");
		vector.add("수량");

		vector2 = new Vector<String>();
		vector.add("상품명");
		vector.add("가격");
		vector.add("수량");

		model = new DefaultTableModel(vector, 0) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return (c != 0) ? true : false;
			}
		};

		model2 = new DefaultTableModel(vector, 0) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return (c != 0) ? true : false;
			}
		};

		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		table2 = new JTable(model2);
		JScrollPane scroll2 = new JScrollPane(table2);

		// 버튼 생성
		add = new JButton("추가");
		delete = new JButton("삭제");
		order = new JButton("주문");
		cancel = new JButton("취소");

		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p.add(add);
		p.add(delete);
		p.add(order);
		p.add(cancel);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p2.add(add);
		p2.add(delete);
		p2.add(order);
		p2.add(cancel);

		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);

		Container c2 = this.getContentPane();
		c2.add("Center", scroll2);
		c2.add("South", p2);

		setBounds(460, 200, 1000, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 이벤트
		add.addActionListener(this);
		delete.addActionListener(this);
		order.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			add();
		} else if (e.getSource() == delete) {
			delete();
		} else if (e.getSource() == order) {
			order();
		} else if (e.getSource() == cancel) {
			cancel();
		}
	}

	private void add() {
		JOptionPane.showConfirmDialog(this, "추가하시겠습니까?", "추가", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	private void delete() {
		JOptionPane.showConfirmDialog(this, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	private void order() {

		// 리턴 값 : 사용자가 입력한 문자열, 취소 버튼이 선택되거나 창이 닫히면 null 리턴

		JOptionPane.showConfirmDialog(this, "장바구니 항목을 주문하시겠습니까", "주문", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

	}

	private void cancel() {
	}

}