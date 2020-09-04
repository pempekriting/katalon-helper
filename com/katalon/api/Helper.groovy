package com.katalon.api

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.everit.json.schema.Schema
import org.everit.json.schema.ValidationException
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener
import org.json.simple.parser.ParseException

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

public class Helper {
	@Keyword // membuat import class menjadi keyword
	public static LocalDate parsingDate(String date){
		DateTimeFormatter date_format 	= DateTimeFormatter.ofPattern("yyyy-MM-dd")
		LocalDate  parsedDate			= LocalDate.parse(date, date_format)
		return parsedDate
	}
	@Keyword
	public static boolean validateDate(String date){
		String pattern = "[0-9]{4}-[0-9]{2}-[0-9]{2}"
		def dateValidation = date.matches(pattern)
		return dateValidation
	}
	@Keyword
	public static boolean validatePhone(String phone){
		String pattern = "\\D[^0-9]"
		def phoneValidation = phone.matches(pattern)
		return phoneValidation
	}
	@Keyword
	public static boolean validateEmail(String email){
		String pattern = "[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})"
		def emailValidation = email.matches(pattern)
		return  emailValidation
	}
	@Keyword
	public static boolean validateBooleanType(String variable){
		Boolean[] operator=[true, false]
		def logicBoolean = operator.any{operator.contains(variable)}
		return logicBoolean
	}

	/**
	 * Validate JSON with schema
	 * 
	 * @param stringJson string JSON format
	 * @param schemaName just type your schema name. Make sure put the schema into folder Data Files 
	 * 
	 */

	@Keyword
	public static boolean jsonValidate(String stringJson, String schemaName) {

		def stringSchema = findSchema(schemaName)

		JSONObject rawSchema = new JSONObject(new JSONTokener(stringSchema))
		Schema schema = SchemaLoader.load(rawSchema)

		try {
			try {
				println "Validating schema..."
				schema.validate(new JSONObject(stringJson))
				KeywordUtil.markPassed("JSON instance is valid against Schema - PASSED")
				return true
			} catch (ValidationException ve) {
				println "validate step4"
				StringBuffer outmessage = new StringBuffer()
				outmessage << ve.getMessage() << "\n"
				ve.getAllMessages().each { msg -> outmessage << "$msg \n" }
				KeywordUtil.markFailed(outmessage as String)
				return false
			}
		} catch (ParseException pe) {
			println "validate step5"
			StringBuffer outmessage = new StringBuffer()
			outmessage << pe.getMessage() << "\n"
			pe.getAllMessages().each { msg -> outmessage << "$msg \n" }
			KeywordUtil.markFailed(outmessage as String)
			return false
		}
	}

	/**
	 * Find schema
	 * 
	 * @param schemaName just type your schema name.
	 * 
	 */


	@Keyword
	public static String findSchema(String schemaName) {
		try {
			String schema = new File('./Data Files/'+schemaName).text
			KeywordUtil.logInfo("Expected Schema: " + schema)
			return schema
		} catch (ParseException pe) {
			StringBuffer outmessage = new StringBuffer()
			outmessage << pe.getMessage() << "\n"
			pe.getAllMessages().each { msg -> outmessage << "$msg \n" }
			KeywordUtil.markFailed(outmessage as String)
			return false
		}
	}
}


