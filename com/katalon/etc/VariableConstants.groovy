package com.katalon.etc

import com.kms.katalon.core.configuration.RunConfiguration
import com.mongodb.ServerAddress

public interface VariableConstants {

	public static final List<ServerAddress> listServerAddreess = Arrays.asList(new ServerAddress('qa-001-shard-00-00-g3x8i.mongodb.net', 27017),
	new ServerAddress('qa-001-shard-00-01-g3x8i.mongodb.net', 27017), new ServerAddress('qa-001-shard-00-02-g3x8i.mongodb.net',
	27017))

	public static String path = RunConfiguration.getProjectDir().concat('/Data Files/')
}
