
public class JLog {
	
	private String fileName;
	private String filePath;
	private String backupPath;
	private String recordFormat;
	
	JLog(){
		fileName = "";
		filePath = "";
		recordFormat = "";
	}
	
	public void writeLog() {
		// Write in actual logger a new record
	}
	
	public void createLog() {
		// Creates the file for logger
	}
	
	public void backUpLog() {
		// Creates a copy of actual logger into logger backup folder
	}
	
	public void clearLog() {
		
	}
	
}
