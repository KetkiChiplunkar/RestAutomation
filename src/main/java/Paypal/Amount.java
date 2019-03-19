package Paypal;

public class Amount {

	private String total;

	private String currency;

	private Details details;

	public  final String getTotal() {
		return total;
	}

	public final void setTotal(String total) {
		this.total = total;
	}

	public final String getCurrency() {
		return currency;
	}

	public final void setCurrency(String currency) {
		this.currency = currency;
	}

	public final Details getDetails() {
		return details;
	}

	public  final void setDetails(Details details) {
		this.details = details;
	}
}
