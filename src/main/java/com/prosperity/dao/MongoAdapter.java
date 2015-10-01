package com.prosperity.dao;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

@Service
public class MongoAdapter {

	public void connectToMongo() {
		// or
		MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017)));

		MongoDatabase db = mongoClient.getDatabase("prosperitydb");

	}

	public static void main(String[] args) {
		try {
			MongoAdapter adap = new MongoAdapter();
			adap.connectToMongo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getDigest(String password, String salt) {

		return "";
	}

}
