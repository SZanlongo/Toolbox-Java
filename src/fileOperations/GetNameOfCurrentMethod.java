package fileOperations;

public class GetNameOfCurrentMethod {
	public void getCurrentMethodName() {
		@SuppressWarnings("unused")
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	}
}
