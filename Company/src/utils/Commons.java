package utils;

import java.text.SimpleDateFormat;

public interface Commons {
	String connectionString = "jdbc:mysql://localhost:3306/company"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST";
	String dbUsername = "root";
	String dbPassword = "root";

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
}
