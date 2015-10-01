package com.prosperity.dao.datasource;

import java.util.Arrays;
import java.util.UUID;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.prosperity.dao.model.User;

@Service
public class MongoAdapter {

	private MongoClient mongoClient;
	private MongoDatabase db;

	public MongoAdapter(String dbName, String host, int port) {
		mongoClient = new MongoClient(Arrays.asList(new ServerAddress(host, port)));
		db = mongoClient.getDatabase(dbName);
	}

	public <T> void insert(T t, String collectionName) {
		MongoCollection<Document> coll = getCollection(collectionName);
		Gson gson = new Gson();
		UUID x = UUID.randomUUID();
		Document doc = new Document(x.toString(), gson.toJson(t));
		coll.insertOne(doc);
	}
	
	public <T> T find(T t, String collectionName) {
		return null;

	}
	
	
	public <T> void update(T t, String collectionName) {
		MongoCollection<Document> coll = getCollection(collectionName);
		Gson gson = new Gson();
		UUID x = UUID.randomUUID();
		Document doc = new Document(x.toString(), gson.toJson(t));
		coll.insertOne(doc);
	}
	
	

	private MongoCollection<Document> getCollection(String collectionName) {
		MongoCollection<Document> coll = db.getCollection(collectionName);
		if (coll == null) {
			db.createCollection(collectionName);
		}
		return coll;
	}
	
	
	
	

	public static void main(String[] args) {
		try {
			User user = new User();
			user.setHashPassword("asa");
			user.setLogin("aaaa");
			user.setPhone("4086189433");
			MongoAdapter adap = new MongoAdapter("prosperitydb", "localhost", 27017);
			adap.insert(user, "users");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
