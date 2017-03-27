package fieldmap;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class InventoryMenuItem extends JMenuItem{
	public InventoryMenuItem(String menuItemName){
		super(menuItemName);
		setPreferredSize(new Dimension(80, 24));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setHorizontalAlignment(SwingConstants.CENTER);
		setMaximumSize(new Dimension(80, 300));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(ExecGame.flag%2!=0)
					{Inventory in = new Inventory();
					InvenDB invDB = new InvenDB();
					invDB.getInven();
					in.getContentPane().setFont(new Font("나눔고딕코딩", Font.PLAIN, 11));
					in.setBounds(500, 300, 400, 650);
					in.getContentPane().setLayout(null); // 레이아웃
					in.setVisible(true);
					}else{}
				
			}
		});
		
	}

}
