package fieldmap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;

public class CharInfo extends JFrame {
	Font myFont;
	ImageIcon img;

	public CharInfo() {
		Font myFont = new Font("Power Pixel-7", Font.BOLD, 18);
		Font myFont2 = new Font("HY동녘M", Font.BOLD, 18);

		setTitle("캐릭터 정보");
		getContentPane().setLayout(null);
		setBounds(100, 100, 512, 413);
		setVisible(true);
		setResizable(false);
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.drawImage(new ImageIcon("image/Trainercard.png").getImage(), 0, 0, this);
				setOpaque(false);
			}
		};

		JLabel imagelabel = new JLabel(new ImageIcon(".png"));
		imagelabel.setBounds(0, 0, 200, 300);

		JPanel imagepanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.drawImage(new ImageIcon("image/정보창캐릭터1.png").getImage(), 0, 0, this);
				setOpaque(false);
			}
		};

		JLabel charname = new JLabel(ExecGame.player.getPname());
		charname.setFont(myFont2);

		JLabel l_gold = new JLabel("Gold ");
		l_gold.setFont(myFont);
		JLabel gold = new JLabel(Long.toString(ExecGame.player.getGold()));
		gold.setFont(myFont);

		JLabel l_gender = new JLabel("Gender");
		l_gender.setFont(myFont);
		JLabel gender = new JLabel(ExecGame.player.getGender());
		gender.setFont(myFont2);

		JLabel l_level = new JLabel("Lelvel");
		l_level.setFont(myFont);
		JLabel level = new JLabel(Integer.toString(ExecGame.player.getLevel().getLev()));
		level.setFont(myFont);

		JLabel l_exp = new JLabel("Exp ");
		l_exp.setFont(myFont);
		JLabel exp = new JLabel(Long.toString(ExecGame.player.getExp()));
		exp.setFont(myFont);

		JLabel l_tcount = new JLabel("Monster ");
		l_tcount.setFont(myFont);
		JLabel tcount = new JLabel(Integer.toString(ExecGame.player.getCount()));
		tcount.setFont(myFont);

		JLabel l_playtime = new JLabel("Playtime");
		l_playtime.setFont(myFont);
		JLabel playtime = new JLabel(Long.toString((ExecGame.player.getPlayTime()) / (1000 * 60)) + " 분");
		playtime.setFont(myFont);

		l_gender.setBounds(45, 55, 220, 46);
		l_gold.setBounds(45, 105, 220, 46);
		l_playtime.setBounds(45, 300, 220, 46);

		charname.setBounds(370, 55, 220, 46);
		gender.setBounds(245, 55, 220, 46);
		gold.setBounds(245, 105, 220, 46);
		playtime.setBounds(245, 300, 220, 46);

		l_level.setBounds(45, 152, 220, 46);
		l_exp.setBounds(45, 200, 220, 46);
		l_tcount.setBounds(45, 248, 220, 46);

		level.setBounds(245, 152, 220, 46);
		exp.setBounds(245, 200, 220, 46);
		tcount.setBounds(245, 248, 220, 46);

		panel.setLayout(null);
		panel.setBounds(0, 0, 512, 413);

		imagepanel.setLayout(null);
		imagepanel.setBounds(355, 110, 200, 300);// (325,130,200,300);

		getContentPane().add(panel);
		panel.add(charname);
		panel.add(l_gender);
		panel.add(gender);
		panel.add(l_gold);
		panel.add(gold);
		panel.add(l_level);
		panel.add(level);
		panel.add(l_exp);
		panel.add(exp);
		panel.add(l_tcount);
		panel.add(tcount);
		panel.add(l_playtime);
		panel.add(playtime);
		panel.add(imagepanel);

	}
}