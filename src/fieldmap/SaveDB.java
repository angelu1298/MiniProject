package fieldmap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import Database.Player;
import Database.SavePlayer;

public class SaveDB {
	
	
	public void saveDB() {
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		File savefile1 = new File("savefile1.sav");
		File savefile2 = new File("savefile2.sav");
		File savefile3 = new File("savefile3.sav");
		try {
			if (!savefile1.exists()) {
				fos = new FileOutputStream("savefile1.sav");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(ExecGame.player);
				oos.writeObject(FireFieldView.finalflag);
				oos.writeObject(WaterFieldView.finalflag);
				oos.writeObject(GrassFieldView.finalflag);
				oos.writeObject(EarthFieldView.finalflag);
				JOptionPane.showConfirmDialog(null, "1번 슬롯에 저장됩니다.", "캐릭터생성", 1, 1);

			} else if (!savefile2.exists()) {
				fos = new FileOutputStream("savefile2.sav");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(ExecGame.player);
				oos.writeObject(FireFieldView.finalflag);
				oos.writeObject(WaterFieldView.finalflag);
				oos.writeObject(GrassFieldView.finalflag);
				oos.writeObject(EarthFieldView.finalflag);
				JOptionPane.showConfirmDialog(null, "2번 슬롯에 저장됩니다.", "캐릭터생성", 1, 1);
			} else if (!savefile3.exists()) {
				fos = new FileOutputStream("savefile3.sav");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(ExecGame.player);
				oos.writeObject(FireFieldView.finalflag);
				oos.writeObject(WaterFieldView.finalflag);
				oos.writeObject(GrassFieldView.finalflag);
				oos.writeObject(EarthFieldView.finalflag);
				JOptionPane.showConfirmDialog(null, "3번 슬롯에 저장됩니다.", "캐릭터생성", 1, 1);
			} else {
				fos = new FileOutputStream("savefile1.sav");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(ExecGame.player);
				oos.writeObject(FireFieldView.finalflag);
				oos.writeObject(WaterFieldView.finalflag);
				oos.writeObject(GrassFieldView.finalflag);
				oos.writeObject(EarthFieldView.finalflag);
				JOptionPane.showConfirmDialog(null, "1번 슬롯에 저장된 정보를 지우고 저장됩니다.", "캐릭터생성", 1, 1);
			}
		} catch (Exception exx) {
			System.out.println("무슨 오류니?");
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (oos != null)
					oos.close();
			} catch (Exception e3) {
			}
		}
		// 데이터베이스와 연동을 위한 클래스 SavePlayer의 생성자. 인자로 player테이블의 각 칼럼에 추가될
		// 내용들을 순서대로 받는다. 위에 플레이어 객체가 가리키는 정보들.
		SavePlayer sp = new SavePlayer();
		sp.saveNewPlayer(ExecGame.player.getPname(), ExecGame.player.getGender(), ExecGame.player.getGold(),
				ExecGame.player.getLevel().getLev(), ExecGame.player.getExp(), ExecGame.player.getBirth(),
				ExecGame.player.getPlayTime(), ExecGame.player.getMonlist().toString(), ExecGame.player.getCount());
		InvenDBsave in_DB = new InvenDBsave();
		in_DB.getInven();
	}
	public void saveFile(String filename){
		File savefile = new File(filename);
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		String num = filename.substring(-1);
		try {
			if (!savefile.exists()) {
				fos = new FileOutputStream(savefile);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(ExecGame.player);
				oos.writeObject(FireFieldView.finalflag);
				oos.writeObject(WaterFieldView.finalflag);
				oos.writeObject(GrassFieldView.finalflag);
				oos.writeObject(EarthFieldView.finalflag);
				JOptionPane.showConfirmDialog(null, num+"번 슬롯에 저장됩니다.", "캐릭터정보저장", 1, 1);
			}
			
		}catch (Exception exx) {
				System.out.println("무슨 오류니?");
			} finally {
				try {
					if (fos != null)
						fos.close();
					if (oos != null)
						oos.close();
				} catch (Exception e3) {
				}
			}
		
	}
	public void loadFile(String filename){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			ExecGame.player = (Player) ois.readObject();
			FireFieldView.finalflag = (Integer) ois.readObject();
			WaterFieldView.finalflag = (Integer) ois.readObject();
			GrassFieldView.finalflag = (Integer) ois.readObject();
			EarthFieldView.finalflag = (Integer) ois.readObject();
		} catch (FileNotFoundException ex) {
			System.out.println("사용자를 불러오지 못했습니다.");

		} catch (Exception e2) {
			System.out.println("사용자가 없습니다.");
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (ois != null)
					ois.close();
			} catch (Exception e3) {
			}
		}
	}
}
