package fieldmap;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import Database.Player;

public class CharacterInfoMenuItem extends JMenuItem {
	FileInputStream fis;
	ObjectInputStream ois;

	public CharacterInfoMenuItem(String menuItemName) {
		super(menuItemName);
		setPreferredSize(new Dimension(80, 24));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setHorizontalAlignment(SwingConstants.CENTER);
		setMaximumSize(new Dimension(80, 300));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ExecGame.flag % 2 != 0) {
					CharInfo chin = new CharInfo();
					chin.getContentPane().setFont(new Font("윤고딕", Font.PLAIN, 11));
					// 레이아웃
					chin.setBounds(100, 100, 512, 413);
					chin.getContentPane().setLayout(null);
					chin.setVisible(true);
				} else {

				}
			}
		});

	}

}
