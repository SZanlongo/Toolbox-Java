package database;

public class JavaUtilDateToSQLDate {
	public void convertDate() {
		java.util.Date utilDate = new java.util.Date();
		@SuppressWarnings("unused")
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	}
}
