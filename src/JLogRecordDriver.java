
public class JLogRecordDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JLogRecord logRecord = new JLogRecord("Correctos","El archivo fue abierto correctamente");
		System.out.println(logRecord.getRecord());
		
		logRecord.setRecord("Exception", "El archivo no se cerró correctamente");
		System.out.println(logRecord.getRecord());
		
		JLog newLog = new JLog();
		newLog.createLog();
		
		for(int i=0; i<100; i++) {
			newLog.writeLog("Aldo", "New message " + Integer.toString(i));
		}
		
		newLog.backUpLog();
		
		for(int i=0; i<100; i++) {
			newLog.writeLog("Aldo", "New message " + Integer.toString(-i));
		}
		
	}

}
