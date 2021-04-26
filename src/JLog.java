import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class JLog extends JLogRecord{
	
	private String fileName;
	private String filePath;
	private String fileNameBackup;
	
	private String typeError;
	private String typeSuccess;
	
	private JLogRecord jLogRecord;
	private File fileLog;
	private File fileLogBackup;
	private FileWriter fileWriter;
	
	JLog(){
		
		super("InitLogger", "Logger iniciado");
		
		fileName = "LOG.txt";
		//filePath = "/Users/aldov500/Documents/Eclipse/JavaLogger/";
		fileNameBackup = "backupLogs/LOG.txt";
		
		typeError = "Exception";
		typeSuccess = "Success";
		
		fileLog = new File(fileName);
		
		
		fileLogBackup = new File(fileNameBackup);
		
		jLogRecord = new JLogRecord(typeSuccess, "Creación de Logger");
	}
	
	public void createLog() {
		// Creates the file for logger
		try {
			if (fileLog.createNewFile()) {
				System.out.println("Archivo creado exitosamente");
			}else {
				System.out.println("Error al crear archivo");
			}
			
		} catch (IOException err) {
			err.printStackTrace();
		}
	}
	
	public void writeLog(String type, String message) {
		// Create logger record
		jLogRecord.setRecord(type, message);
		// Write in actual file logger a new record
		writeLog();
		
	}
	
	private void writeLog() {
		// Write log to file
		try {
			fileWriter = new FileWriter(fileName,true);
			fileWriter.write(jLogRecord.getRecord());
			fileWriter.close();
			
		}catch(IOException err) {
			err.printStackTrace();
		}
	}
	
	@Override
	public String getRecord() {
		return this.jLogRecord.record;
	}
	
	public void backUpLog() {
		// Creates a copy of actual logger into logger backup folder
		try {
			if(Files.exists(fileLogBackup.toPath()) == false) {
				fileLogBackup.mkdirs();
			}
			
			Files.copy(fileLog.toPath(), 
					fileLogBackup.toPath(), 
					StandardCopyOption.REPLACE_EXISTING);
			
			clearLog();
			
			createLog();
			
		}catch (IOException err) {
			err.printStackTrace();
		}
		
	}
	
	public void clearLog() {
		// Delete log and create a new one
		if(fileLog.delete()) {
			System.out.println("Log eliminado correctamente");
		}else {
			System.out.println("No se pudo eliminar el log");
		}
	}
	
}
