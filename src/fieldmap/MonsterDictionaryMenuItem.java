package fieldmap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class MonsterDictionaryMenuItem extends JMenuItem {
	public MonsterDictionaryMenuItem(String menuItemName){
		super(menuItemName);
		setPreferredSize(new Dimension(80, 24));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setHorizontalAlignment(SwingConstants.CENTER);
		setMaximumSize(new Dimension(80, 300));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ExecGame.flag%2!=0){
				MonsterDictionary jw = new MonsterDictionary();
				jw.getContentPane().setFont(new Font("나눔고딕코딩", Font.PLAIN, 11));
				jw.getContentPane().setLayout(null); // 레이아웃
				jw.setVisible(true);
				}else{}
			}
		
	});

}
}