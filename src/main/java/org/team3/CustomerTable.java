package org.team3;

import com.datastax.oss.driver.api.core.CqlSession;

//Customer Class that represents customer data and methods
public class CustomerTable {

	private CqlSession session;

	public CustomerTable(CqlSession session) {
		this.session = session;
	}

	public void createTable() {
		System.out.println("Table created");
		String query = "CREATE TABLE customer(cust_id int PRIMARY KEY, " + "first_name text, " + "last_name text, "
				+ "registered_on timestamp, );";
		session.execute(query);
	}

	public void addColumn() {
		System.out.println("Add column");
		String query = "ALTER Table customer ADD email text";
		session.execute(query);
	}

	public void insertData() {
		System.out.println("Insert Data");
		String query1 = "INSERT INTO customer (cust_id, email, first_name, last_name, registered_on)"
				+ "VALUES (1, 'rose@test.com', 'John', 'Doe', '2023-4-3');";
		String query2 = "INSERT INTO customer (cust_id, email, first_name, last_name, registered_on)"
				+ "VALUES (2, 'karen@new.me', 'Karen', 'Tistle', '2023-3-4');";
		session.execute(query1);
		session.execute(query2);
	}

	public void updateData() {
		System.out.println("Update Data");
		String query = "UPDATE customer SET email = 'john@test.com' WHERE cust_id=1;";
		session.execute(query);
	}

	public void deleteData() {
		System.out.println("Delete Data");
		String query = "DELETE FROM customer WHERE cust_id=1;";
		session.execute(query);
	}

	// Only run this is you are going to recreate the tables
	public void dropTable() {
		System.out.println("Drop Table");
		String query = "DROP TABLE customer";
		session.execute(query);
	}
}
