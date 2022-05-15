package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Feedback {

	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/power", "root", "SZ0116");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// insert method
	public String insertFeedback(String FeedbackName,String FeedbackEmail,String FeedbackSubject,String FeedbackMessage) {
		Connection con = connect();
		String output = "";
		if (con == null) {
			return "Error while connecting to the database";
		}

		// create a prepared statement
		String query = " insert into feedback (`FeedbackId`,`FeedbackName`,`FeedbackEmail`,`FeedbackSubject`,`FeedbackMessage`)"
				+ " values (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, FeedbackName);
			preparedStmt.setString(3, FeedbackEmail);
			preparedStmt.setString(4, FeedbackSubject);
			preparedStmt.setString(5, FeedbackMessage);

			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (SQLException e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}

		return output;
	}


	public String readFeedback() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>FeedbackName</th>FeedbackEmail<th></th>" + "<th>FeedbackSubject</th>"
					+ "<th>FeedbackMessage</th></tr>";

			String query = "select * from feedback ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String FeedbackName = rs.getString("Name");
				String FeedbackEmai = rs.getString("Email");
				String FeedbackSubject = rs.getString("Feedback_Subject");
				String FeedbackMessage = rs.getString("Feedback_Message");

				// Add into the html table
				output += "<tr><td>" + FeedbackName + "</td>";
				output += "<td>" + FeedbackEmai + "</td>";
				output += "<td>" + FeedbackSubject + "</td>";
				output += "<td>" + FeedbackMessage + "</td>";

			}
			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the feedback .";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateFeedback(String FeedbackId, String FeedbackName,String FeedbackEmail,String FeedbackSubject,String FeedbackMessage)

	{
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement

			String query =" feedback set FeedbackName= ? ,FeedbackEmai = ? , FeedbackSubject = ? , FeedbackMessage = ?  where FeedbackId = ? ";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, FeedbackName);
			preparedStmt.setString(2, FeedbackEmail);
			preparedStmt.setString(3, FeedbackSubject);
			preparedStmt.setString(4, FeedbackMessage);
			preparedStmt.setInt(5, Integer.parseInt(FeedbackId));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the product.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteFeedback(String FeedbackId) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from approvements where FeedbackId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(FeedbackId));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
