package Payload;

public class LmsE2EPayload {
	static ProgramPayload program = new ProgramPayload();
	static BatchPayload batch = new BatchPayload();
	static StringBuffer bugLog = new StringBuffer();
	public static int bugCount = 0;

	public static int getBugCount() {
		return bugCount;
	}

	public static void setBugCount(int bugCount) {
		LmsE2EPayload.bugCount = bugCount;
	}

	public static StringBuffer getBugLog() {
		return bugLog;
	}

	public static void setBugLog(StringBuffer bugLog) {
		LmsE2EPayload.bugLog = bugLog;
	}

	public static ProgramPayload getProgram() {
		return program;
	}

	public static void setProgram(ProgramPayload program) {
		LmsE2EPayload.program = program;
	}

	public static BatchPayload getBatch() {
		return batch;
	}

	public static void setBatch(BatchPayload batch) {
		LmsE2EPayload.batch = batch;
	}

}
