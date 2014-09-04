package fileOperations;

public class GetNameOfCurrentMethod {
	public void getCurrentMethodName() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	}
}
