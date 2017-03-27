package fieldmap;

import java.awt.Rectangle;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class ExecWindow {
	public static void main(String[] args) {
		try {// 창 디자인을 바꿀수 있는 룩앤필, 이 경우는 Nimbus 테마를 찾아 적용한 것
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		ExecGame mainWin = new ExecGame(); // 메인 창 생성
		
		mainWin.setBounds(new Rectangle(720, 100, 800, 800)); // 메인 창 사이즈
		mainWin.setVisible(true); // 메인창 보이기
	}
	
}
