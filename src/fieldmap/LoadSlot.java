package fieldmap;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Database.Player;
public class LoadSlot extends JFrame{
	FileInputStream fis;
	ObjectInputStream ois;
	public LoadSlot(ExecGame frame){
		super("불러올 캐릭터의 정보를 선택하세요.");
		setLayout(new GridLayout(3,1,0,0));
		JPanel slot1 = new JPanel();
		JPanel slot2 = new JPanel();
		JPanel slot3 = new JPanel();
		slot1.setLayout(new GridLayout(1,1,0,0));
		slot2.setLayout(new GridLayout(1,1,0,0));
		slot3.setLayout(new GridLayout(1,1,0,0));
		getContentPane().add(slot1);
		getContentPane().add(slot2);
		getContentPane().add(slot3);
		
		JButton slot1_btt = new JButton("저장슬롯1");
		JButton slot2_btt = new JButton("저장슬롯2");
		JButton slot3_btt = new JButton("저장슬롯3");
		slot1_btt.addActionListener(new ActionListener(){

		
			public void actionPerformed(ActionEvent e) {
				try {
					fis = new FileInputStream("세이브파일1.sav");
					ois = new ObjectInputStream(fis);
					ExecGame.player = (Player) ois.readObject();
					FireFieldView.finalflag = (Integer) ois.readObject();
					WaterFieldView.finalflag = (Integer) ois.readObject();
					GrassFieldView.finalflag = (Integer) ois.readObject();
					EarthFieldView.finalflag = (Integer) ois.readObject();
					frame.fieldViewMaker();
					frame.changePanel(new InGameView(frame));

				} catch (FileNotFoundException ex) {
					System.out.println("사용자를 불러오지 못했습니다.");

				} catch (Exception e2) {
					System.out.println("사용자가 없습니다."+e2.getMessage());
				}finally{
					try {
						if(fis!=null)fis.close();
						if(ois!=null)ois.close();
					} catch (Exception e3) {
					}
			}
				dispose();
			}
			
		});
		slot2_btt.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				try {
					fis = new FileInputStream("세이브파일2.sav");
					ois = new ObjectInputStream(fis);
					ExecGame.player = (Player) ois.readObject();
					frame.changePanel(new InGameView(frame));
				} catch (FileNotFoundException ex) {
					System.out.println("사용자를 불러오지 못했습니다.");
					
				} catch (Exception e2) {
					System.out.println("사용자가 없습니다.");
				}finally{
					try {
						if(fis!=null)fis.close();
						if(ois!=null)ois.close();
					} catch (Exception e3) {
					}
			}
				dispose();
			}
			
		});
		slot3_btt.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				try {
					fis = new FileInputStream("세이브파일3.sav");
					ois = new ObjectInputStream(fis);
					ExecGame.player = (Player) ois.readObject();
					frame.changePanel(new InGameView(frame));
				} catch (FileNotFoundException ex) {
					System.out.println("사용자를 불러오지 못했습니다.");
					
				} catch (Exception e2) {
					System.out.println("사용자가 없습니다.");
				}finally{
					try {
						if(fis!=null)fis.close();
						if(ois!=null)ois.close();
					} catch (Exception e3) {
					}
			}
				dispose();
			}
			
		});
		slot1.add(slot1_btt);
		slot2.add(slot2_btt);
		slot3.add(slot3_btt);
		
	}

}
