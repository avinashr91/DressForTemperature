package dressUp;


/**
 * This DressingState class represents the current set of clothing that
 * are put on and the clothing that are not put on for this input instance. 
 * @author Avinash
 *
 */
public class DressingState {
	boolean footwear;
	boolean headwear;
	boolean socks;
	boolean shirt;
	boolean jacket;
	boolean pants;
	boolean leaveHouse;
	boolean takeOffPJs;
	
	public boolean isFootwear() {
		return footwear;
	}
	public void setFootwear(boolean footwear) {
		this.footwear = footwear;
	}
	public boolean isHeadwear() {
		return headwear;
	}
	public void setHeadwear(boolean headwear) {
		this.headwear = headwear;
	}
	public boolean isSocks() {
		return socks;
	}
	public void setSocks(boolean socks) {
		this.socks = socks;
	}
	public boolean isShirt() {
		return shirt;
	}
	public void setShirt(boolean shirt) {
		this.shirt = shirt;
	}
	public boolean isJacket() {
		return jacket;
	}
	public void setJacket(boolean jacket) {
		this.jacket = jacket;
	}
	public boolean isPants() {
		return pants;
	}
	public void setPants(boolean pants) {
		this.pants = pants;
	}
	public boolean isLeaveHouse() {
		return leaveHouse;
	}
	public void setLeaveHouse(boolean leaveHouse) {
		this.leaveHouse = leaveHouse;
	}
	public boolean isTakeOffPJs() {
		return takeOffPJs;
	}
	public void setTakeOffPJs(boolean takeOffPJs) {
		this.takeOffPJs = takeOffPJs;
	}
}
