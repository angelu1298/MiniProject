package fieldmap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MonsterDictionary extends JFrame {

	MonsterDictionary() {
		super("몬스터도감");
		setPreferredSize(new Dimension(580, 600));
		setLocation(200, 300);
		getContentPane().setLayout(new BorderLayout());
		HashSet<String> monlist = ExecGame.player.getMonlist();
		JPanel dicName = new JPanel() {
			ImageIcon icon = new ImageIcon("image/도감이름패널.png");

			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.drawImage(icon.getImage(), 0, 0, this);
			}
		};
		JPanel monInfo = new JPanel();
		JScrollPane scrollPane = new JScrollPane(monInfo);
		JLabel playername = new JLabel(ExecGame.player.getPname() + "의 몬스터도감", SwingConstants.CENTER);
		Font font = new Font("나눔 고딕", Font.BOLD, 15);
		monInfo.setBackground(Color.WHITE);
		getContentPane().add(dicName, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		monInfo.setLayout(new GridLayout(16, 2));

		dicName.setLayout(new BorderLayout());
		dicName.setPreferredSize(new Dimension(580, 60));
		dicName.add(playername, BorderLayout.CENTER);
		playername.setFont(new Font("나눔고딕", Font.BOLD, 19));
		setResizable(false);
		MON_DIC info = new MON_DIC();
		info.getMonInfo();
		JPanel[] panels = new JPanel[32];
		JLabel[] monList = new JLabel[96];
		JLabel[] monImage = new JLabel[32];
		JLabel[] questionImg = new JLabel[32];
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel() {
				ImageIcon icon = new ImageIcon("image/몬스터도감패널.png");

				public void paintComponent(Graphics g) {
					super.paintComponents(g);
					g.drawImage(icon.getImage(), 0, 0, this);

				}
			};
			JLabel quesImg = new JLabel(new ImageIcon("image/물음표.png"));
			quesImg.setBounds(10, 15, 128, 128);
			panels[i].setPreferredSize(new Dimension(270, 160));
			monInfo.add(panels[i], SwingConstants.CENTER);
			panels[i].setLayout(null);
			monList[i] = new JLabel("이름   :  " + info.mon_name.get(i));// DB에서
																		// 받아옴
			monList[i + 32] = new JLabel("속성   :  " + info.t_name.get(i));//
			monList[i + 64] = new JLabel("등급   :  " + info.grade.get(i));//
			monImage[i] = new JLabel(info.icon.get(i));
			monImage[i].setBounds(10, 15, 128, 128);
			monList[i].setBounds(150, 20, 100, 40);
			monList[i + 32].setBounds(150, 60, 100, 40);
			monList[i + 64].setBounds(150, 100, 100, 40);
			monList[i].setFont(font);
			monList[i + 32].setFont(font);
			monList[i + 64].setFont(font);
			if(monlist.contains(info.mon_name.get(i))){
				panels[i].add(monList[i]);
				panels[i].add(monList[i + 32]);
				panels[i].add(monList[i + 64]);
				panels[i].add(monImage[i]);
			}else
				panels[i].add(quesImg);

		}

		setVisible(true);
		pack();
	}

}
