package test02_ex01.contruct;

public class Hotel {
	
	private Chef chef; //멤버 선언 객체

	public Hotel(Chef chef) {
		this.chef = chef;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	} 

}
