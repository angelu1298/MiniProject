//상대속성 정리(몬스터와 몬스터볼)
package Database;

import java.io.Serializable;

import javax.swing.ImageIcon;

public enum Attribute implements Serializable{

	FIRE("불") {

		public String getOppAtt(){		//불속성의 상대속성은 물
			return "물";
		}
	},
	WATER("물") {
		
		public String getOppAtt(){		//물속성의 상대속성은 땅
			return "땅";
		}
	},
	EARTH("땅") {
		
		public String getOppAtt(){		//땅속성의 상대속성은 풀
			return "풀";
		}

	},
	GRASS("풀") {
		
		public String getOppAtt(){		//풀속성의 상대속성은 불
			return "불";
		}
	};


	private String attr;				//attr을 private선언

	Attribute(String attr) {
		this.attr = attr;
	}

	public String getAttr() {			//attr을 가져온다
		return this.attr;
	}

	public String getOppAtt(){
		return this.getOppAtt();		//상대속성을 리턴한다
	}

}
