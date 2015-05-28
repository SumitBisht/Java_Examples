package com.sumitbisht.data;

import org.apache.log4j.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class BackendAuthenticator {
	
	Mongo mongo;
	DB db;
	DBCollection table;
	private Logger logger = Logger.getLogger(BackendAuthenticator.class);
	
	public BackendAuthenticator(){
		try {
			mongo = new Mongo("localhost", 27017);
			db = mongo.getDB("UserAuthenticator");
			table = db.getCollection("login");
			
		} catch (Exception e) {
			logger.error("Unable to connect to the database: "+e.getMessage());
		}
		
	}
	
	
	
	public boolean authenticate(String username, String password)
	{
		BasicDBObject match = new BasicDBObject();
		match.put("username", username);
		DBCursor cursor = table.find(match);
		logger.debug("Finding records in the database containing the username as: "+username);
		while(cursor.hasNext()){
			BasicDBObject record = (BasicDBObject) cursor.next();
			if(record.get("pasword").equals(password)){
				logger.debug("Matched proper password for the given username");
				return true;
			}
		}
		logger.debug("No match found for the given username");
		return false;
	}

}
