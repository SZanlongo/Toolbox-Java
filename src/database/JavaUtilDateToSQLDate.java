package database;

public class JavaUtilDateToSQLDate {
	public void convertDate() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	}
}
