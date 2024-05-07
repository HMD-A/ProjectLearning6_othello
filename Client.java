package projectLearning;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client extends JFrame implements ActionListener{

	private JPanel cardPanel;
    private CardLayout layout;
    private static String currentOperation = "None";
    private static String currentPhase = "Home";
    private Player player;
    private Othello othello;

    public static void main(String[] args) {
        Client frame = new Client();
        frame.setTitle("画面遷移テスト");
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        Othello othello = new Othello();
        
        
        while(true) {
        	System.out.println("hello");
        	if (currentPhase.equals("Home")) {
        		// home画面で行う処理
        	}else if(currentPhase.equals("Matching")) {
        		// matching画面で行う処理
        	}else if(currentPhase.equals("MyTrun")) {
        		int[][] board = othello.getBoardState();
        		for(int i = 0; i < board.length ;i++) {
        			for(int j = 0 ; j < board[0].length ; j++) {
        				if(board[i][j] == 0) {
        					
        				}
        			}
        				
        		}
        	}else if(currentPhase.equals("HisTurn")) {
        		// 相手の番に行う処理
        	}else if(currentPhase.equals("WinOrLose")) {
        		// 勝ち負け判定
        	}else if(currentPhase.equals("Win")) {
        		// 勝ち状態
        	}else if(currentPhase.equals("Lose")) {
        		// 負け状態
        	}else {
        		System.out.println("Unexpected Phase : " + currentPhase);
        		System.exit(0);
        	}
        	try {
        		Thread.sleep(10000); // 10秒(1万ミリ秒)間だけ処理を止める
        	} catch (InterruptedException e) {
        	}
        }
    }

    public Client() {
        // パネルを初期化
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

        // 各パネルを追加
        cardPanel.add(new HomePage(this), "homepage");
        OthelloPage othelloPanel = new OthelloPage(this);
        cardPanel.add(othelloPanel, "othellopage");

        // ボタンパネルを作成
        JPanel btnPanel = createNavigationButtons();

        // cardPanelとカード移動用ボタンをJFrameに配置
        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);
        contentPane.add(btnPanel, BorderLayout.PAGE_END);
    }

    // ナビゲーションボタンを作成するメソッド
    private JPanel createNavigationButtons() {
        JPanel btnPanel = new JPanel();

        JButton firstButton = new JButton("homepage");
        firstButton.setActionCommand("homepage");
        firstButton.addActionListener(this);
        btnPanel.add(firstButton);

        JButton secondButton = new JButton("othellopage");
        secondButton.setActionCommand("othellopage");
        secondButton.addActionListener(this);
        btnPanel.add(secondButton);


        return btnPanel;
    }

    // イベントハンドラー
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        layout.show(cardPanel, cmd);
        System.out.println(cmd);
        currentOperation = cmd;
    }
}



