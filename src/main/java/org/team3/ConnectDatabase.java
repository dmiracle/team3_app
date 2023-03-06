package org.team3;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.nio.file.Paths;

public class ConnectDatabase {

	public static void main(String[] args) {
		// Create the CqlSession object: This is using Astra DB is a serverless
		// database-as-a-service (DBaaS) built on Apache Cassandra®.
		try (CqlSession session = CqlSession.builder()
				.withCloudSecureConnectBundle(
						Paths.get("env/secure-connect-ics611-team3.zip"))
				.withAuthCredentials(System.getenv("DATASTAX_CLIENT_ID"),
						System.getenv("DATASTAX_CLIENT_SECRET"))
				.withKeyspace("team3")
				.build()) {
			// Select the release_version from the system.local table:
			ResultSet rs = session.execute("select release_version from system.local");
			Row row = rs.one();
			// Print the results of the CQL query to the console:
			if (row != null) {
				System.out.println(row.getString("release_version"));
				CustomerTable cust = new CustomerTable(session);
				cust.createTable();
				cust.addColumn();
				cust.insertData();
				cust.updateData();
				cust.deleteData();
			} else {
				System.out.println("An error occurred.");
			}
		}
		System.exit(0);
	}
}