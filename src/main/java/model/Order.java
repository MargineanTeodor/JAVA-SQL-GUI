package model;

import java.util.Arrays;


public class Order {
	private int prodId;
	private int id;
	private int clientId;
	private int cantitate;

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public Order(int prodId, int id, int clientId, int cantitate) {
		this.prodId = prodId;
		this.id = id;
		this.clientId = clientId;
		this.cantitate= cantitate;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "Order[" + "prodId=" + prodId + ", id=" + id + ", clientId=" + clientId + '}';
	}

}
