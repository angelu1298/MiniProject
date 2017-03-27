package Database;

import java.io.Serializable;

public class Monster implements Serializable{
	private static final long serialVersionUID = 100;
	private String mname;
	private Attribute mtype; // 속성
	private String mgrade;   // 등급
	private double mhp;
	private double mrate;
	private int mmoney;
	private int stageNo;
	private double oMhp;
	private int exp;
	private int maxattcnt;
	public void setMname(String mname) {//이름 설정
		this.mname = mname;
	}

	public void setMtype(Attribute mtype) {//속성 설정
		this.mtype = mtype;
	}

	public void setMGrade(String mgrade) {//등급 설정
		this.mgrade = mgrade;
	}
	public void setMhp(double mhp) {//HP를 인자로 받아와서 Mhp에 설정
		this.mhp = mhp;
	}

	public void setOMhp() {
		if(mgrade.equals("S"))		//S등급 hp
			oMhp = 2000;			
		else if (mgrade.equals("A"))//A등급 hp
			oMhp = 1000;			
		else if (mgrade.equals("B"))//B등급 hp
			oMhp = 500;				
		else						//C등급 hp
			oMhp = 150;				
	}
	


	public void setMmoney() {
		if(mgrade.equals("S"))		//S등급 몬스터가 떨어뜨리는 가격
			mmoney = 10000;			
		else if (mgrade.equals("A"))//A등급 몬스터가 떨어뜨리는 가격
			mmoney = 3000;			
		else if (mgrade.equals("B"))//B등급 몬스터가 떨어뜨리는 가격
			mmoney = 1000;			
		else						//C등급 몬스터가 떨어뜨리는 가격
			mmoney = 500;			
		

	}

	public void setStageNo(int stageNo) {//스테이지 번호를 인자로 받아와서 스테이지 번호 바꾸는 메소드  
		this.stageNo = stageNo;
	}
	public void setMaxattcnt() {	//최대공격횟수
		if(mgrade.equals("S"))		//S등급은 8번
			maxattcnt = 8;			
		else if (mgrade.equals("A"))//A등급은 8번
			maxattcnt = 10;
		else if (mgrade.equals("B"))//B등급은 8번
			maxattcnt = 13;
		else						//C등급은 8번
			maxattcnt = 15;
	}
	
	
	
	

	public void setExp() {//경험치
		if(mgrade.equals("S"))		//S등급은 1000경험치 줌
			exp = 1000;
		else if (mgrade.equals("A"))//A등급은 1000경험치 줌
			exp = 500;
		else if (mgrade.equals("B"))//B등급은 1000경험치 줌
			exp = 100;
		else						//C등급은 1000경험치 줌
			exp = 10;

	}
	public void setMrate() {	//몬스터 획득확률								
		
		if((getMhp()/oMhp)>0.7)// (피 깎이고 남은값 / 원래피) 남은피의 퍼센트
			mrate = 0;			
		else if((getMhp()/oMhp)<=0.7 && (getMhp()/oMhp)>0.5)
			mrate = 0.05;		//5%
		else if ((getMhp()/oMhp)<=0.5 &&(getMhp()/oMhp)>0.3)
			mrate = 0.5;		//50%
		else
			mrate = 0.7;		//70%
	}
	
	


	public String getMname() { 
		return mname;
	}

	public Attribute getMtype() {
		return mtype;
	}

	public String getMGrade() {
		return mgrade;
	}

	public double getMhp() {
		return mhp;
	}
	public double getOMhp() {
		return oMhp;
	}

	public int getMmoney() {
		return mmoney;
	}

	public int getStageNo() {
		return stageNo;
	}
	public double getMrate() {
		return mrate;
	}
	public int getExp() {
		return exp;
	}
	public int getMaxattcnt() {
		return maxattcnt;
	}
	public Monster FireEasyMonster(){//불지역 EASY 몬스터의 각 데이터를 정해주는것
		
		//기본적으로 정해줘야할 타입
		setMtype(Attribute.FIRE);
		setMGrade("C");
		setOMhp();
		setMhp(oMhp);
		setMrate();
		setExp();
		setMmoney();
		setStageNo(1);
		setMaxattcnt();
		return this;
	}
	public Monster GrassEasyMonster(){//풀지역 EASY 몬스터
		
		setMname("이상해씨");
		setMtype(Attribute.GRASS);
		setMGrade("C");
		setOMhp();
		setMhp(oMhp);
		setMrate();
		setExp();
		setMmoney();
		setStageNo(1);
		setMaxattcnt();
		return this;
	}
	public Monster WaterEasyMonster(){//물지역 EASY 몬스터
		
		setMname("고라파덕");
		setMtype(Attribute.WATER);
		setMGrade("C");
		setOMhp();
		setMhp(oMhp);
		setMrate();
		setExp();
		setMmoney();
		setStageNo(1);
		setMaxattcnt();
		return this;
	}
	public Monster EarthEasyMonster(){//땅지역 EASY 몬스터
		
		setMname("디그닥");
		setMtype(Attribute.EARTH);
		setMGrade("C");
		setOMhp();
		setMhp(oMhp);
		setMrate();
		setExp();
		setMmoney();
		setStageNo(1);
		setMaxattcnt();
		return this;  //이 몬스터 객체를 리턴하는것
	}

	

}
