package Database;

import java.io.Serializable;

public class Ball implements Serializable{
	
	private static final long serialVersionUID = 100;
	private int b_key;
	private int b_price;
	private String b_type;
	private double b_getrate;		//포획률
	public Ball(){					//생성자 호출 했을 때 볼가격,속성,포획률 정해주려고
		b_key =1;					//생성자로 초기화
		setBallPrice();
		setBallType();			 
		setBallGetrate();
	}
	
	public void setBallKey(int b_key) {//b_key설정
		this.b_key = b_key;
	}

	public void setBallPrice() {		//볼가격 설정
		if(b_key<=4)					//C등급 볼은
			b_price = 50;				//50원
		else if (b_key<=8)				//B등급 볼은
			b_price = 300;				//300원
		else if (b_key<=12)				//A등급 볼은
			b_price = 1000;				//1000원
		else			   				//S등급 볼은
			b_price = 10000;			//10000원
	}

	public void setBallType() {
		if(b_key%4==1)					//b_key 1,5,9,13은
			b_type = "불";				//불속성 볼
		else if (b_key%4==2)			//b_key 2,6,10,14는
			b_type = "물";				//물속성 볼
		else if (b_key%4==3)			//b_key 3,7,11,15는
			b_type = "풀";				//풀속성 볼
		else 							//b_key 4,8,12,16은
			b_type = "땅";				//땅속성 볼
		
	}

	public void setBallGetrate() {
		if(b_key<=4)					//C등급 포획률
			b_getrate = 0.1;
		else if (b_key<=8)				//B등급 포획률
			b_getrate = 0.15;
		else if (b_key<=12)				//A등급 포획률
			b_getrate = 0.18;
		else 							//S등급 포획률
			b_getrate = 0.22;
		
	}

	public int getBallkey() {			//이 메소드를 호출하면 b_key를 가져온다
		return b_key;
	}

	public int getBallPrice() {			//b_price를 가져온다
		return b_price;
	}

	public String getBallType() {		//b_type을 가져온다
		return b_type;
	}

	public double getBallGetrate() {	//b_getrate를 가져온다
		return b_getrate;
	}


}
