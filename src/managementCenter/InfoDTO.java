package managementCenter;
//임시-메세지의 전수송의 정보, 재고관련 메세지만 적용함

import userClient.CntServer;

public class InfoDTO {
	private String name;
	private String id;// (190331 해은) 식별자를 id로 변경함으로써 id변수+겟커셋터 설정
	private String itemName;
	private int uPrice, itemNum, itemMnt, totCost, userTime;
	private String message;
	private InfoMsg command;
	private CntServer cntServer;
	// =========GETTER % SETTER==========================

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getuPrice() {
		return uPrice;
	}

	public void setuPrice(int uPrice) {
		this.uPrice = uPrice;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public int getItemMnt() {
		return itemMnt;
	}

	public void setItemMnt(int itemMnt) {
		this.itemMnt = itemMnt;
	}

	public int getTotCost() {
		return totCost;
	}

	public void setTotCost(int totCost) {
		this.totCost = totCost;
	}

	public int getUserTime() {
		return userTime;
	}

	public void setUserTime(int userTime) {
		this.userTime = userTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InfoMsg getCommand() {
		return command;
	}

	public void setCommand(InfoMsg command) {
		this.command = command;
	}

	public CntServer getCntServer() {
		return cntServer;
	}

	public void setCntServer(CntServer cntServer) {
		this.cntServer = cntServer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}// InfoDTO class
