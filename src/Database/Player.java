package Database;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Player implements Serializable{
	
	private static final long serialVersionUID = 100;
	private String p_name;
	private String gender;
	private long gold;
	private long birthday;
	private Level level;
	private long logouttime;
	private long playtime;
	private long exp;
	private int totalcount;
	private HashSet<String> monlist;
	private HashMap<Integer,Integer> ball_t_num; //key : 볼의 키 ,value : 갯수
	
	
	public Player(){
		this.birthday=new Date().getTime(); //??//현재시간???생성했을 때 시간
		this.gold=500;
		this.playtime =0;
		this.exp=0 ;
		this.totalcount = 0;
		this.level = new Level();
		this.monlist = new HashSet<String>();
		this.ball_t_num = new HashMap<Integer,Integer>();
		ball_t_num.put(1, 10); //볼 16개 다들어가야함
		ball_t_num.put(2, 10);
		ball_t_num.put(3, 10);
		ball_t_num.put(4, 10);
		ball_t_num.put(5, 0);
		ball_t_num.put(6, 0);
		ball_t_num.put(7, 0);
		ball_t_num.put(8, 0);
		ball_t_num.put(9, 0);
		ball_t_num.put(10, 0);
		ball_t_num.put(11, 0);
		ball_t_num.put(12, 0);
		ball_t_num.put(13, 0);
		ball_t_num.put(14, 0);
		ball_t_num.put(15, 0);
		ball_t_num.put(16, 0);
		
	}
	public void setBallnum(Integer ball,Integer num){
		ball_t_num.put(ball, num);//ball이 key, num이 value
	}
	public void setPname(String p_name){
		this.p_name = p_name;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setGold(long gold){
		this.gold += gold;//원래 gold에서 추가되게 함
	}
	
	public void setLevel(Level level){
		this.level = level;
	}
	
	public void setPlayTime(){
		this.playtime =logouttime-birthday;	//로그아웃시간 에서 처음시작한시간 뺀시간
	}
	
	
	public void setLogoutTime(){
		this.logouttime =new Date().getTime(); //로그아웃한 시간
	}
	
	public void setExp(long exp){
		this.exp += exp;						//원래있던 exp에서 추가되게 함
	}
	public void setCount(){
		this.totalcount = monlist.size(); 		//몬리스트의 사이즈가 수집한몬스터 종류의 수가 됨
	}
	public void setMonlist(String monstername){
		monlist.add(monstername); 				//몬리스트에 몬스터이름 추가시킴
	}
	
	
	
	public String getPname(){
		return p_name;
	}
	public String getGender(){
	
		return gender;
	}
	
	public long getGold(){
		return gold;
	}
	public long getBirth(){
		return birthday;
	}
	
	public Level getLevel(){
		return level;
	}
	public long getPlayTime(){
		playtime = new Date().getTime()-getBirth(); //지금시간에서 처음시작한시간 뺀 것이 총 플레이한 시간이됨
		return playtime;
	}
	public long getExp(){
		return exp;
	}
	public long getLogoutTime(){
		return logouttime;
	}
	public int getCount(){
		totalcount = monlist.size();
		return totalcount;
	}
	public HashSet<String> getMonlist(){
		
		return monlist;
	}
	public Integer getBallnum(Integer ball){ 
		return ball_t_num.get(ball); 	//ball key값을 넣어서 value값을 리턴하는 메소드
	}
	
	
}
