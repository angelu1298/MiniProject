package fieldmap;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Database.Player;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

public class ExecGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int flag = 0;
	private CardLayout cards = new CardLayout(); // 패널이 바뀌어야하므로 카드 레이아웃을 선택했다 밑에
	public static Player player; // 있는 changPanel 메소드로 패널 바꿈
	FileInputStream fis = null; // 플레이어 객체를 따로 파일로 저장하기 위해 만든 입력스트림
	ObjectInputStream ois = null;
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	StartView sv; // 시작화면 패널
	InGameView iv; // 게임화면 패널
	FireFieldView fv;// 불지역 패널
	GrassFieldView gv;// 풀지역 패널
	WaterFieldView wv;// 물지역 패널
	EarthFieldView ev;// 땅지역 패널
	FireFightView ffv;// 불지역 전투패널
	WaterFightView wfv;
	GrassFightView gfv;
	EarthFightView efv;

	public ExecGame() {
		// 시작화면 패널과 게임화면 패널을 생성 일반 패널 하나 추가 생성
		// player = new Player();

		sv = new StartView(this);
		iv = new InGameView(this);
		// String bgm = "poketmon-fight.mp3";
		// Media media = new Media(bgm);
		// MediaPlayer mplayer = new MediaPlayer(media);
		// mplayer.play();

		// 이 패널위에 게임화면 패널 올렸다

		sv.setOpaque(false); // 투명도 설정?-일단 무조건 false로 가는걸로....
		setTitle("*-*-*-*포켓몬을 잡아보자*-*-*-*"); // 타이틀바에 보여줄 메시지
		getContentPane().setLayout(cards); // 컨텐트 팬에 카드레이아웃 설정
		getContentPane().add("StartView", sv); // 컨텐트 팬에 시작화면 패널 얹음
		getContentPane().add("InGameView", iv); // 컨텐트 팬에 게임화면 패널이 얹어진 패널 얹음

		// 게임화면 패널이 얹어진 패널의 레이아웃은 앱솔루트 레이아웃이다 (setLayout메소드의 인자로 null을 입력하면 앱솔루트
		// 레이아웃이됨
		changeMenuBar(sv); // 시작화면 메뉴바 세팅 이 소스 맨 아래에 메소드 오버로딩으로 작성해 놓음
		iv.setBounds(new Rectangle(0, 0, 800, 800)); // 패널위에 올려진 게임화면의 사이즈와 위치
														// 설정 좌표는 패널의 왼쪽 상단 끝 기준
		// 패널 위에 게임화면 얹음
		setAutoRequestFocus(false);
		setAlwaysOnTop(false);
		setResizable(false); // 이 창의 크기를 임의 변경 할 수 없게 만들었다 왜? 버튼위치랑 다 깨질 수
								// 있으니까...
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 빨간 x버튼 누를 시 프로그램을
	}

	public void fieldViewMaker() {
		fv = new FireFieldView(this);
		gv = new GrassFieldView(this);
		wv = new WaterFieldView(this);
		ev = new EarthFieldView(this);
		getContentPane().add("FireFieldView", fv); // 컨텐트 팬에 게임화면 패널이 얹어진 패널 얹음
		getContentPane().add("GrassFieldView", gv);
		getContentPane().add("WaterFieldView", wv);
		getContentPane().add("EarthFieldView", ev);
	}

	public void fightViewMaker() {
		ffv = new FireFightView(this);
		wfv = new WaterFightView(this);
		gfv = new GrassFightView(this);
		efv = new EarthFightView(this);
		getContentPane().add("FireFightView", ffv);
		getContentPane().add("WaterFightView", wfv);
		getContentPane().add("GrassFightView", gfv);
		getContentPane().add("EarthFightView", efv);

	}

	public void changePanel(JPanel panel) { // 카드레이아웃에서 패널을 교체할 때 쓰는 메소드. 컨텐트 팬에
		// 있는 다른 패널을 부른당!

		if (panel instanceof StartView) {
			cards.show(getContentPane(), "StartView");
			changeMenuBar(sv);
			flag = 2;
		} else if (panel instanceof InGameView) {
			cards.show(getContentPane(), "InGameView");
			changeMenuBar(iv);
			flag = 3;
		} else if (panel instanceof FireFieldView) {
			cards.show(getContentPane(), "FireFieldView");// 지역별로 추가해야함
			changeMenuBar(iv);
			flag = 3;
		} else if (panel instanceof GrassFieldView) {
			cards.show(getContentPane(), "GrassFieldView");
			changeMenuBar(iv);
			flag = 3;
		} else if (panel instanceof WaterFieldView) {
			cards.show(getContentPane(), "WaterFieldView");
			changeMenuBar(iv);
			flag = 3;
		} else if (panel instanceof EarthFieldView) {
			cards.show(getContentPane(), "EarthFieldView");
			changeMenuBar(iv);
			flag = 3;
		} else if (panel instanceof FireFightView) {
			cards.show(getContentPane(), "FireFightView");
			changeMenuBar(iv);
			flag = 3;
		} else if (panel instanceof WaterFightView) {
			cards.show(getContentPane(), "WaterFightView");
			changeMenuBar(iv);
			flag = 3;
		} else if (panel instanceof GrassFightView) {
			cards.show(getContentPane(), "GrassFightView");
			changeMenuBar(iv);
			flag = 3;
		} else if (panel instanceof EarthFightView) {
			cards.show(getContentPane(), "EarthFightView");
			changeMenuBar(iv);
			flag = 3;
		}
	}

	// 패널이 시작화면일 때 메뉴바 세팅
	public void changeMenuBar(StartView sv) {
		JMenuBar menuBar = new JMenuBar(); // 메뉴바 생성
		JMenu menu = new JMenu("메인메뉴"); // 메뉴 생성
		JMenuItem restartGame = new JMenuItem("게임재시작"); // 게임재시작 메뉴아이템 생성
		JMenu savePlayerInfo = new JMenu("저장하기"); // 불러오기 저장하기 메뉴 생성
		JMenu loadPlayerInfo = new JMenu("불러오기");
		JMenuItem save01 = new JMenuItem("저장위치1"); // 저장파일 메뉴아이템 생성(슬롯 세개에 맞춤) -
													// startview에서는 비활성화 됨
		JMenuItem save02 = new JMenuItem("저장위치2");
		JMenuItem save03 = new JMenuItem("저장위치3");
		JMenuItem load01 = new JMenuItem("저장파일1");// 불러오기 메뉴아이템생성(슬롯 세개)
		JMenuItem load02 = new JMenuItem("저장파일2");
		JMenuItem load03 = new JMenuItem("저장파일3");
		JMenuItem endGame = new JMenuItem("끝내기"); // 끝내기 메뉴아이템
		setJMenuBar(menuBar); // 프레임에 메뉴바 추가

		InventoryMenuItem inventory = new InventoryMenuItem("인벤토리"); // 인벤토리
																		// 메뉴아이템
		MonsterDictionaryMenuItem monsterdictionary = new MonsterDictionaryMenuItem("몬스터 도감");// 몬스터도감
																								// 메뉴아이템
		CharacterInfoMenuItem charInfo = new CharacterInfoMenuItem("캐릭터 정보");// 캐릭터
																				// 정보
																				// 메뉴아이템

		menu.setBounds(0, 0, 80, 24); // 메인메뉴의 위치와 크기세팅
		menu.setVisible(true); // 이것도 보여주게 만들어야한다!
		menu.add(restartGame); // 메인메뉴에 게임재시작 메뉴아이템과 불러오기, 저장하기 메뉴, 끝내기 메뉴아이템 추가
		menu.add(savePlayerInfo);
		menu.add(loadPlayerInfo);
		menu.add(endGame);

		save01.setForeground(Color.GRAY);
		save02.setForeground(Color.GRAY);
		save03.setForeground(Color.GRAY);
		loadPlayerInfo.add(load01); // 불러오기 메뉴에 저장위치 메뉴아이템들을 추가
		loadPlayerInfo.add(load02);
		loadPlayerInfo.add(load03);
		savePlayerInfo.add(save01); // 저장하기 메뉴에 저장위치 메뉴아이템들을 추가
		savePlayerInfo.add(save02);
		savePlayerInfo.add(save03);

		monsterdictionary.setForeground(Color.GRAY); // 몬스터도감, 인벤토리, 캐릭터 정보
														// 메뉴아이템의 글씨 색을 회색으로
														// 세팅-비활성화되었다는 표시로
		inventory.setForeground(Color.GRAY);
		charInfo.setForeground(Color.GRAY);

		restartGame.addActionListener(new ActionListener() { // 게임재시작 메뉴아이템을 눌렀을
																// 때의 액션리스너 패널을
																// 바꿔주는 메소드를 호출
			public void actionPerformed(ActionEvent e) {
				changePanel(sv);

			}
		});
		load01.addActionListener(new ActionListener() { // 저장위치1 메뉴아이템을 눌렀을때의 효과
														// 데이터베이스에서 불러와야 하기 때문에
														// 다시작성해야함
			public void actionPerformed(ActionEvent e) {
				String filename = "savefile1.sav";
				SaveDB loadfile = new SaveDB();
				loadfile.loadFile(filename);
				fieldViewMaker();
			}
		});
		load02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = "savefile2.sav";
				SaveDB loadfile = new SaveDB();
				loadfile.loadFile(filename);
				fieldViewMaker();
			}
		});
		load03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String filename = "savefile3.sav";
				SaveDB loadfile = new SaveDB();
				loadfile.loadFile(filename);
				fieldViewMaker();
			}
		});

		endGame.setHorizontalAlignment(SwingConstants.LEFT);
		endGame.addActionListener(new ActionListener() { // 끝내기 메뉴아이템을 눌렀을때의 이벤트
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "포켓몬 세상을 떠나시겠습니까?", "종료", 2, 2);
				switch (i) {
				case JOptionPane.YES_OPTION: // 스위치 문을 써서 예버튼 눌렀을 때와 아니오 버튼 눌렀을
												// 때의 효과를 정해줄 수 있다.
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:

					break;

				}
				sv.setVisible(true);
			}
		});

		menuBar.add(menu);
		menuBar.add(monsterdictionary);
		menuBar.add(inventory);
		menuBar.add(charInfo);
	}

	// 패널이 게임화면일 때의 메뉴바 세팅
	public void changeMenuBar(InGameView iv) {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("메인메뉴");
		JMenuItem restartGame = new JMenuItem("게임재시작");
		JMenu savePlayerInfo = new JMenu("저장하기");
		JMenu loadPlayerInfo = new JMenu("불러오기");
		JMenuItem save01 = new JMenuItem("세이브파일1");
		JMenuItem save02 = new JMenuItem("세이브파일2");
		JMenuItem save03 = new JMenuItem("세이브파일3");
		JMenuItem load01 = new JMenuItem("세이브파일1");
		JMenuItem load02 = new JMenuItem("세이브파일2");
		JMenuItem load03 = new JMenuItem("세이브파일3");
		JMenuItem endGame = new JMenuItem("끝내기");
		InventoryMenuItem inventory = new InventoryMenuItem("인벤토리");
		MonsterDictionaryMenuItem monsterdictionary = new MonsterDictionaryMenuItem("몬스터 도감");
		CharacterInfoMenuItem charInfo = new CharacterInfoMenuItem("캐릭터 정보");
		menu.setBounds(0, 0, 80, 24);
		menu.setVisible(true);
		menu.add(restartGame);
		menu.add(savePlayerInfo);
		menu.add(loadPlayerInfo);
		menu.add(endGame);
		menuBar.add(menu);
		loadPlayerInfo.add(load01); // 불러오기 메뉴에 저장위치 메뉴아이템들을 추가
		loadPlayerInfo.add(load02);
		loadPlayerInfo.add(load03);
		savePlayerInfo.add(save01); // 저장하기 메뉴에 저장위치 메뉴아이템들을 추가
		savePlayerInfo.add(save02);
		savePlayerInfo.add(save03);
		monsterdictionary.setForeground(Color.BLACK);
		inventory.setForeground(Color.BLACK);
		charInfo.setForeground(Color.BLACK);
		menuBar.add(monsterdictionary);
		menuBar.add(inventory);
		menuBar.add(charInfo);
		restartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(sv);

			}
		});
		load01.addActionListener(new ActionListener() { // 저장위치1 메뉴아이템을 눌렀을때의 효과
			// 데이터베이스에서 불러와야 하기 때문에
			// 다시작성해야함
			public void actionPerformed(ActionEvent e) {
				String filename = "savefile1.sav";
				SaveDB loadfile = new SaveDB();
				loadfile.loadFile(filename);
				fieldViewMaker();
			}
		});
		load02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = "savefile2.sav";
				SaveDB loadfile = new SaveDB();
				loadfile.loadFile(filename);
				fieldViewMaker();
			}
		});
		load03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String filename = "savefile3.sav";
				SaveDB loadfile = new SaveDB();
				loadfile.loadFile(filename);
				fieldViewMaker();
			}
		});
		save01.addActionListener(new ActionListener() { // 저장위치1 메뉴아이템을 눌렀을때의 효과
			// 데이터베이스에서 불러와야 하기 때문에
			// 다시작성해야함
			public void actionPerformed(ActionEvent e) {
				try {
					String filename = "savefile1.sav";
					File checkfile = new File(filename);
					
					if (checkfile.exists()) {
						int i = JOptionPane.showConfirmDialog(null, "저장된 정보 위에 덮어쓰시겠습니까?", "지울꺼양?", 2, 2);
						switch (i) {
						case JOptionPane.YES_OPTION: // 스위치 문을 써서 예버튼 눌렀을 때와 아니오
							// 버튼 눌렀을
							// 때의 효과를 정해줄 수 있다.
							fos = new FileOutputStream("savefile1.sav");
							oos = new ObjectOutputStream(fos);

							oos.writeObject(player);
							oos.writeObject(FireFieldView.finalflag);
							oos.writeObject(WaterFieldView.finalflag);
							oos.writeObject(GrassFieldView.finalflag);
							oos.writeObject(EarthFieldView.finalflag);
							DbSave ds = new DbSave();
							ds.updatePlayer(ExecGame.player.getPname(), ExecGame.player.getGold(),
									ExecGame.player.getLevel().getLev(), ExecGame.player.getExp(),
									ExecGame.player.getPlayTime(), ExecGame.player.getCount());
							break;
						case JOptionPane.NO_OPTION:
							break;
						}
					} else {
						fos = new FileOutputStream("savefile1.sav");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(player);
						oos.writeObject(FireFieldView.finalflag);
						oos.writeObject(WaterFieldView.finalflag);
						oos.writeObject(GrassFieldView.finalflag);
						oos.writeObject(EarthFieldView.finalflag);
						DbSave sp = new DbSave();
						sp.updatePlayer(ExecGame.player.getPname(), ExecGame.player.getGold(),
								ExecGame.player.getLevel().getLev(), ExecGame.player.getExp(),
								ExecGame.player.getPlayTime(), ExecGame.player.getCount());
					}

				} catch (Exception e2) {
					System.out.println("저장에 실패 했습니다." + e2.getMessage());
				} finally {
					System.out.println(player.getExp() + player.getPname() + player.getGold() + player.getPlayTime());
					try {
						if (fos != null)
							fos.close();
						if (oos != null)
							oos.close();
					} catch (Exception e3) {
					}
				}
			}

		});
		save02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File checkfile = new File("savefile2.sav");
					if (checkfile.exists()) {
						int i = JOptionPane.showConfirmDialog(null, "저장된 정보 위에 덮어쓰시겠습니까?", "지울꺼양?", 2, 2);
						switch (i) {
						case JOptionPane.YES_OPTION:
							fos = new FileOutputStream("savefile2.sav");
							oos = new ObjectOutputStream(fos);
							oos.writeObject(player);
							oos.writeObject(FireFieldView.finalflag);
							oos.writeObject(WaterFieldView.finalflag);
							oos.writeObject(GrassFieldView.finalflag);
							oos.writeObject(EarthFieldView.finalflag);
							System.out.println(
									player.getExp() + player.getPname() + player.getGold() + player.getPlayTime());
							DbSave sp = new DbSave();
							sp.updatePlayer(ExecGame.player.getPname(), ExecGame.player.getGold(),
									ExecGame.player.getLevel().getLev(), ExecGame.player.getExp(),
									ExecGame.player.getPlayTime(), ExecGame.player.getCount());
							break;
						case JOptionPane.NO_OPTION:
							break;
						}
					} else {
						fos = new FileOutputStream("savefile2.sav");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(player);
						oos.writeObject(FireFieldView.finalflag);
						oos.writeObject(WaterFieldView.finalflag);
						oos.writeObject(GrassFieldView.finalflag);
						oos.writeObject(EarthFieldView.finalflag);
						DbSave sp = new DbSave();
						sp.updatePlayer(ExecGame.player.getPname(), ExecGame.player.getGold(),
								ExecGame.player.getLevel().getLev(), ExecGame.player.getExp(),
								ExecGame.player.getPlayTime(), ExecGame.player.getCount());
					}

				} catch (Exception e2) {
					System.out.println("저장에 실패 했습니다." + e2.getMessage());
				} finally {
					System.out.println(player.getExp() + player.getPname() + player.getGold() + player.getPlayTime());
					try {
						if (fos != null)
							fos.close();
						if (oos != null)
							oos.close();
					} catch (Exception e3) {
					}
				}

			}
		});
		save03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File checkfile = new File("savefile3.sav");
					if (checkfile.exists()) {
						int i = JOptionPane.showConfirmDialog(null, "저장된 정보 위에 덮어쓰시겠습니까?", "지울꺼양?", 2, 2);
						switch (i) {
						case JOptionPane.YES_OPTION: // 스위치 문을 써서 예버튼 눌렀을 때와 아니오
							// 버튼 눌렀을
							// 때의 효과를 정해줄 수 있다.
							fos = new FileOutputStream("savefile3.sav");
							oos = new ObjectOutputStream(fos);
							oos.writeObject(player);
							oos.writeObject(FireFieldView.finalflag);
							oos.writeObject(WaterFieldView.finalflag);
							oos.writeObject(GrassFieldView.finalflag);
							oos.writeObject(EarthFieldView.finalflag);
							DbSave sp = new DbSave();
							sp.updatePlayer(ExecGame.player.getPname(), ExecGame.player.getGold(),
									ExecGame.player.getLevel().getLev(), ExecGame.player.getExp(),
									ExecGame.player.getPlayTime(), ExecGame.player.getCount());
							break;
						case JOptionPane.NO_OPTION:
							break;
						}
					} else {
						fos = new FileOutputStream("savefile3.sav");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(player);
						oos.writeObject(FireFieldView.finalflag);
						oos.writeObject(WaterFieldView.finalflag);
						oos.writeObject(GrassFieldView.finalflag);
						oos.writeObject(EarthFieldView.finalflag);
						DbSave sp = new DbSave();
						sp.updatePlayer(ExecGame.player.getPname(), ExecGame.player.getGold(),
								ExecGame.player.getLevel().getLev(), ExecGame.player.getExp(),
								ExecGame.player.getPlayTime(), ExecGame.player.getCount());
					}

				} catch (Exception e2) {
					System.out.println("저장에 실패 했습니다." + e2.getMessage());
				} finally {
					System.out.println(player.getExp() + player.getPname() + player.getGold() + player.getPlayTime());
					try {
						if (fos != null)
							fos.close();
						if (oos != null)
							oos.close();
					} catch (Exception e3) {
					}
				}
			}
		});

		endGame.setHorizontalAlignment(SwingConstants.LEFT);
		endGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "포켓몬 세상을 떠나시겠습니까?", "종료", 2, 2);
				switch (i) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					ExecGame.player.setLogoutTime();
					break;
				case JOptionPane.NO_OPTION:

					break;

				}

			}
		});

	}

}
