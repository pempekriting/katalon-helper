
package com.katalon.database.mongodb

import com.katalon.etc.VariableConstants
import com.kms.katalon.core.annotation.Keyword
import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress as ServerAddress

public class Helper implements VariableConstants{

	@Keyword
	public static MongoClient connectToDatabase(String user, String database, String password) {
		MongoCredential credential = MongoCredential.createCredential(user, database, password.toCharArray())

		MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build()

		MongoClient mongoClient = new MongoClient(listServerAddreess, Arrays.asList(credential), options)

		return mongoClient
	}
}
