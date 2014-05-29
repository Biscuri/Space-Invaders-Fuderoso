package util;

import java.util.ArrayList;

import model.Tiro;

public class EstadoTiros {

	private ArrayList<Tiro> tiros;
	private boolean atirou;
	
	public EstadoTiros(ArrayList<Tiro> tiros){
		this.tiros = tiros;
	}
	
	public ArrayList<Tiro> getTiros(){
		return tiros;
	}
	
	public void setTiros(ArrayList<Tiro> tiros){
		this.tiros = tiros;
	}

	public boolean isAtirou() {
		return atirou;
	}

	public void setAtirou(boolean atirou) {
		this.atirou = atirou;
	}
}
