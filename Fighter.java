package patika.boxingMatch;

public class Fighter {

	String name;
	int damage;
	int health;//can
	int weight;
	int dodge; //bloklama şansını hesaplayan parametre
	
	Fighter(String name,int damage,int health,int weight,int dodge){
		
		this.name=name;
		this.damage=damage;
		this.health=health;
		this.weight=weight;
		
		if(dodge>=0 && dodge<=100) { //şansın doğru girilmesi için kontrol.
			this.dodge=dodge;	
		}else {
			this.dodge=0;
		}
	}
	
	int hit(Fighter foe) {//foe rakip demek
		
		System.out.println(this.name+" =>"+foe.name+" "+this.damage+" hasar vurdu.");
		
		if(foe.isDodge()) {
			
			System.out.println(foe.name+" gelen hasarı blokladı.");
			System.out.println("---------------");
			return foe.health;
			
		}
		if(foe.health-this.damage<0) {
			
			return 0;
		}
		
		
		return foe.health-this.damage;
	}
	
	boolean isDodge() {//şans hesabı.şansa göre bloklayıp bloklamayacağına karar verir.
		
		double randomNumber=Math.random()*100;
		
		return randomNumber <= this.dodge;
	}
}
