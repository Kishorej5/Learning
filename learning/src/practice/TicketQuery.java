package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketQuery {
	public static void main(String[] args) throws IOException {
		

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://etlqa-lkp-cluster.cluster-cyrwvn3qibpy.us-east-1.rds.amazonaws.com:3306/jobs", "kishore_etl", "rdcldKiCoDZYJbL8");
			
			PreparedStatement preparedStatement = con.prepareStatement("select tt.id  as rawtitleid, st.name  from  jobs.tbl_Title tt inner join  jobs.tbl_TitleMappingStandardV1 sm on sm.titleid=tt.id inner join norm_prod.standard_titles st on st.id=sm.mlstandardtitleid where sm.mlstandardtitleid =(?) limit 1;");
			
			String location = "jobid";
			FileReader file = new FileReader(location);
			BufferedReader reader = new BufferedReader(file);
			
			String  line;
			while ((line=reader.readLine()) != null) {
				
				 int mlstandardtitleidValue = Integer.parseInt(line.trim());
				preparedStatement.setInt(1,mlstandardtitleidValue );
				ResultSet resultSet =preparedStatement.executeQuery();
				
		 
		while (resultSet.next()) {
			int rawTitleID = resultSet.getInt("rawtitleid");
			System.out.println(rawTitleID);
			 
		 }
		}
		}

		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
