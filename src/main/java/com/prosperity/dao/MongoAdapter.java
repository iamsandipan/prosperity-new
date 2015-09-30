package com.prosperity.dao;

import com.mongodb.MongoClient;

public class MongoAdapter {
	
	public void connectToMongo(){
		MongoClient mongoClient = new MongoClient();
		
		mongoClient.getDatabase("users");
		
	}

}
