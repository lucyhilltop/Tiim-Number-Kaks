package ee.ut.math.tvt.salessystem.domain.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="History")
public class HistoryItem implements DisplayableItem {

	@Column(name="Date")
	private String Date;

	@Column(name="Time")
	private String Time;

	@Column(name="Total")
	private double total;
	
	
	public HistoryItem(String date, String time, double total) {
		this.Date = date;
		this.Time = time;
		this.total = total;
	}
	
	public HistoryItem() {
    }



	public Object getColumn(int columnIndex) {
        switch(columnIndex) {
            case 0: return Date;
            case 1: return Time;
            case 2: return total;
            default: throw new RuntimeException("invalid column!");
        }
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
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	

}