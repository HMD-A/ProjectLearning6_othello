package projectLearning;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player {

}

class HomePage extends JPanel {
    public HomePage(Client frame) {
    	setLayout(new BorderLayout());
    	JLabel label = new JLabel("ホーム画面");
    	label.setFont(new Font("MS Gothic", Font.PLAIN, 24));
    	JButton button = new JButton("オセロ画面へ");
    	button.setActionCommand("panel02");
        button.addActionListener(frame);
    	
        add(label,"North");
        add(button,"Center");
    }
}