package projectLearning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Othello {
	private int[][] board = new int[8][8];
	private int turn = 0;
	
	public int[][] getBoardState() {
		return board;
	}
	
	public int IsMyTurn() {
		return turn;
	}
	
	public int CanPutDisc(int x, int y) {
		return 1;
	}
}

//パネル02のクラス
class OthelloPage extends JPanel {
	 public OthelloPage(Client frame) {
	 	// レイアウトマネージャを設定する
	     //70,
	     setLayout(new BorderLayout());
	
	     // "East"のパネルを作成する
	     JPanel pe = new JPanel();
	     
	     JLabel labele = new JLabel("<html>相手<br />蘇我馬子（白）");
	     labele.setFont(new Font("MS Gothic", Font.PLAIN, 24));
	     pe.add(labele);
	     add(pe, "East");
	     
	     
	     // "Center"のパネルを作成する
	     JPanel pc = new JPanel();
	     pc.setBackground(Color.BLACK);
	     pc.setBorder(new EmptyBorder(10, 10, 10, 10));
	     pc.setLayout(new GridLayout(8, 8,5,5));
	     JButton[] buttons = new JButton[8*8];
	     for (int i = 0; i < 64; i++) {
	     	ImageIcon icon = new ImageIcon("img/board.png");
	         JButton button = new JButton(icon);
	         // ボタンのサイズを正方形に設定
	         button.setPreferredSize(new Dimension(100, 100));
	         button.setActionCommand(Integer.toString(i));
	         button.addActionListener(frame);
	         buttons[i] = button;
	         pc.add(button);
	     }
	     
	     JPanel pcc = new JPanel();
	     pcc.setLayout(new FlowLayout());
	     pcc.add(pc);
	     add(pcc, "Center");
	     
	     // "West"のパネルを作成する
	     JPanel pw = new JPanel();
	     JLabel labelw = new JLabel("<html>あなた<br />中大兄皇子（黒）");
	     labelw.setFont(new Font("MS Gothic", Font.PLAIN, 24));
	     pw.add(labelw);
	     add(pw, "West");
	
	
	     // "South"のパネルを作成する
	     JPanel ps = new JPanel();
	     JLabel label = new JLabel("645年大化の改新\n皇極天皇4年（645年）6月12日、飛鳥板蓋宮の乙巳の変に始まる一連の国政改革");
	     label.setFont(new Font("MS Gothic", Font.PLAIN, 24));
	     ps.add(label);
	     add(ps, "South");
	 }
	 
	 public void changeButtonIcon(int i) {
	 	System.out.println(i);
	 }
}
