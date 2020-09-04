# KatalonHelper
![helper](https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTtw4ocYMGnnszm0jvRV7aXGcIea3ixXljV62OBKTdOPoUYKcQg)

Hi, welcome on repository KatalonHelper. KatalonHelper will make all your work easier.

* ## Intermezzo

	**KatalonHelper** is a helper made with **[Selenium](https://selenium.dev/)** base and using **[Java](https://java.com/en/download/faq/whatis_java.xml)** and **[Groovy](http://groovy-lang.org/)** languages. It was made to handle recurring and unique cases.

##
* ## Contribute

	Do you want to contribute to make KatalonHelper more **better and efficient?** just clone and make some magic!

##
* ## How to Use

	1. Use at least use on version 6.3.2 or latest version of Katalon Studio. Open Katalon Studio
	2. Right click on folder Keywords, and then choose Git.
	3. Set Repository to this repository URL
	4. Use your Bitbucket user
	5. Click button next and wait until branch load.
	6. Checklist on branch master and click button next
	7. Click button finish
	8. Wait until Katalon Studio success to clone this repository
	9. JojoHelper ready to use! Happy Testing!
	
# What Inside KatalonHelper
There are so many functions that can be performed by KatalonHelper. I'll explain some helper that is often used. Let's breakdown!
	
##
* ## Package com.katalon.api
#
* __Validate JSON with JSON Schema__
	
	**Before you start to use this function,** you must add all the libraries ([everit](https://mvnrepository.com/artifact/org.everit.json/org.everit.json.schema/1.5.1) and [json-simple](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1)) into Katalon Studio. The ways is :
	
	1. Follow the guideline to install [Gradle](https://gradle.org/install/). Ignore this step if you already install the Gradle
	2. Make sure your Katalon Studio is not running.
	3. Prepare your gradle.build file. You can copy that file from this repository, and paste into your Katalon project.
	4. You can update version of library too. Just open the gradle.build file and change the version. This is an additional steps
	5. Open your Katalon project from terminal and use the command ```gradle katalonCopyDependencies```. Wait until the process done.
	
	You want to compare your response with JSON Schema do you have? this helper will help you to validate it!. To use it :
	
	```
	import com.katalon.api.Helper
	```
	
	```
	Helper.jsonValidate(response.getResponseBodyContent().toString(), 'responseIdOnlyTrue.json')
	```

##
* ## Package com.katalon.database.mongodb

	**Before you start to use this helper,** you must have the MongoDB library first. To add MongoDB into Katalon Studio, we have two ways :
	
	* __Import External Libraries__
		1. Download [MongoDB.jar](https://mvnrepository.com/artifact/org.mongodb/mongodb-driver). Make sure download the latest version.
		2. Open Katalon Studio, go to menu Project -> Settings -> External Libraries.
		3. Click button Add and search MongoDB.jar that has been downloaded.
		4. Click button Apply and Close.
		
	* __Gradle__
		1. Follow the guideline to install [Gradle](https://gradle.org/install/). Ignore this step if you already install the Gradle
		2. Make sure your Katalon Studio is not running.
		3. Prepare your gradle.build file. You can copy that file from this repository, and paste into your Katalon project.
		4. You can update version of library too. Just open the gradle.build file and change the version. This is an additional steps
		5. Open your Katalon project from terminal and use the command ```gradle katalonCopyDependencies```. Wait until the process done.
##

* __Connect to MongoDB__
	
	Do you want to enter the MongoDB QA database? don't worry, just enter your username, password and database only!. To use it :

	```
	import com.katalon.database.mongodb.Helper
	```
	
	```
	mongoClient = Helper.connectToDatabase('rangga', 'admin', 'Indonesia1')
	```
	
	```
	DB db = mongoClient.getDB('digiform')
	```
	
	```
	collection = db.getCollection('forms')
	```
	
	```
	DBCursor cursor = collection.find()
	```
	```
	while (cursor.hasNext()) {
		println(cursor.next())
	}
	```