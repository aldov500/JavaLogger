import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class JLogRecord {
	
	// Variables for dates
	private DateTimeFormatter dateTimeFormatter;
	private LocalDateTime localDateTime;
	private String dateFormat = "dd/MM/yyyy HH:mm:ss";
	
	private String messageFormat = "[%s][%s] Log:[%s] \n";
	
	// Variables for usage
	protected String message;
	protected String type;
	protected String date;
	protected String record;
	
	// Constructor
	JLogRecord(String type, String message){
		this.message = message;
		this.type = type;
		
		dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
		localDateTime = LocalDateTime.now();
		date = dateTimeFormatter.format(localDateTime);
		
		record = String.format(messageFormat,date,this.type,this.message);
	}
	
	// Privates
	private void updateRecord() {
		setDate();
		record = String.format(messageFormat, dateTimeFormatter.format(localDateTime), type, message);
	}
	
	private void setDate() {
		localDateTime = LocalDateTime.now();
		date = dateTimeFormatter.format(localDateTime);
	}
	
	// Getters
	protected String getRecord() {
		
		updateRecord();
		
		return record;
	}
	
	// Setters
	protected void setMessage(String message) {
		this.message = message;
	}
	
	protected void setType(String type) {
		this.type = type;
	}
	
	
	public void setDate(LocalDateTime datetime) {
		localDateTime = datetime;
		date = dateTimeFormatter.format(localDateTime);
		
	}
	
	public void setRecord(String type,String message) {
		this.message = message;
		this.type = type;
		
		updateRecord();
		
	}
	
	
}
