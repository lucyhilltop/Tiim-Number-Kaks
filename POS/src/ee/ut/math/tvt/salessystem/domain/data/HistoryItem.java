package ee.ut.math.tvt.salessystem.domain.data;

public class HistoryItem implements Cloneable, DisplayableItem {
	private String Date;
	private String Time;
	private double total;
	
	
	
	public HistoryItem(String date, String time, double total) {
		this.Date = date;
		this.Time = time;
		this.total = total;
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}



	public String getDate() {
		return Date;
	}



	public void setDate(String date) {
		Date = date;
	}



	public String getTime() {
		return Time;
	}



	public void setTime(String time) {
		Time = time;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}