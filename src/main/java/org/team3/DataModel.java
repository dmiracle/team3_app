package org.team3;

import com.datastax.oss.driver.api.core.CqlSession;

public class DataModel {

	private CqlSession session;

	public DataModel(CqlSession session) {
		this.session = session;
	}

	public void createDemographicsTable() {
		System.out.println("Table created");
		String query = "CREATE TABLE demographics (tract int PRIMARY KEY,"
				+ "age_group_1_18 int,"
				+ "age_group_19_35 int,"
				+ "age_group_36_55 int,"
				+ "age_group_55plus int,"
				+ "gender_male int,"
				+ "gender_female int,"
				+ "income_low int,"
				+ "income_middle int,"
				+ "income_high int);";
		session.execute(query);
	}

	public void createAdAuctionsTable() {
		System.out.println("Table created");
		String query = "CREATE TABLE ad_auctions (auction_id uuid PRIMARY KEY,"
				+ "ad_id uuid,"
				+ "time timestamp,"
				+ "winning_bid decimal,);";
		session.execute(query);
	}

	public void createAdvertisementTable() {
		System.out.println("Table created");
		String query = "CREATE TABLE advertisements (ad_id uuid PRIMARY KEY,"
				+ "ad_name text,"
				+ "ad_image blob);";
		session.execute(query);
	}

	public void createUserTable() {
		System.out.println("Table created");
		String query = "CREATE TABLE user_ad_run (user_id uuid PRIMARY KEY,"
				+ "auction_id uuid,"
				+ "user_name text,"
				+ "user_email text,"
				+ "start_time timestamp,"
				+ "end_time timestamp,"
				+ "earnings decimal);";
		session.execute(query);
	}

}
