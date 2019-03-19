package Paypal;

import java.util.ArrayList;

public class CreateOrder {

	private String intent;
	//private purchase_units purchase_units; 
	
	private ArrayList < Object > purchase_units = new ArrayList < Object > ();

	public final ArrayList<Object> getPurchase_units() {
		return purchase_units;
	}

	public final void setPurchase_units(ArrayList<Object> purchase_units) {
		this.purchase_units = purchase_units;
	}

	public final String getIntent() {
		return intent;
	}

//	public final purchase_units getPurchase_units() {
//		return purchase_units;
//	}
//
//	public final void setPurchase_units(purchase_units purchase_units) {
//		this.purchase_units = purchase_units;
//	}
//
	public final void setIntent(String intent) {
		this.intent = intent;
	}


}
