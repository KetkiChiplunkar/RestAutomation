package Paypal;

import java.util.List;



public class CreatePaymentPojo {
	private String intent;
	private String note_to_payer;
	private Payer payer;
	private redirect_urls redirect_urls;
	private List<Transactions> transactions;
	
	public final String getIntent() {
		return intent;
	}
	public final void setIntent(String intent) {
		this.intent = intent;
	}
	public final String getNote_to_payer() {
		return note_to_payer;
	}
	public final void setNote_to_payer(String note_to_payer) {
		this.note_to_payer = note_to_payer;
	}
	public final Payer getPayer() {
		return payer;
	}
	public final void setPayer(Payer payer) {
		this.payer = payer;
	}
	public final redirect_urls getRedirect_urls() {
		return redirect_urls;
	}
	public final void setRedirect_urls(redirect_urls redirect_urls) {
		this.redirect_urls = redirect_urls;
	}
	public final List<Transactions> getTransactions() {
		return transactions;
	}
	public final void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
}
