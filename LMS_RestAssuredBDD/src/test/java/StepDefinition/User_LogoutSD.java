package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import Payload.LmsE2EPayload;
import Payload.ProgramPayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utilities.ExcelReaderData;
import utilities.LoggerLoad;
import utilities.ReusableMethods;
import utilities.ReusableVariables;

public class User_LogoutSD {
	
	ReusableMethods reuseMethods=new ReusableMethods();
	ReusableVariables reuseVariables=new ReusableVariables();
	
	//ExcelReaderData read = ExcelReaderData.getInstance();
	String reqBody;
	Response programResponse;
	ValidatableResponse valid_resp;
	
	@Given("Admin RequestLog_out from {string} for the LMS API from Excel")
	public void admin_request_log_out_from_for_the_lms_api_from_excel(String feature) throws IOException {
		List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 // create batch Pojo
			 ProgramPayload programReqbody=new  ProgramPayload();
			 programReqbody.makeProgramPayloadByMap(recordMap);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 //System.out.println("Excel Row S.No: "+recordMap.get("Program ID-endpoint"));
			 
			 System.out.println("New Program creatin  i ----"+i);
			try {
				this.programResponse = RestAssured.given()
						.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(programReqbody).when()
						.get(ReusableVariables.baseURL+recordMap.get("End Point"));
					valid_resp = programResponse.then().log().all()
						.assertThat()
						.statusCode(Integer.parseInt(recordMap.get("Status Code")));
					ReusableVariables.bearerToken = "";
					LoggerLoad.info("User logged out and making token invalid...");
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  New program  ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
				LoggerLoad.logBug("Excel Row S.No: "+recordMap.get("S.no") +"\t"+
						feature+"\t"+
						e.getLocalizedMessage());
			}
		 }
			
		 }
	
	@Then("update bug log and report")
	public void update_bug_log_and_report() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		  System.out.println("-------------- Bug Report Start --------------------------------");
		LoggerLoad.info("-------------- Bug Report Start --------------------------------");
		LoggerLoad.info(" Total Assertion Error bug count "+ LmsE2EPayload.bugCount);
		  System.out.println(" Total Assertion Error bug count "+ LmsE2EPayload.bugCount);
		  System.out.println(LmsE2EPayload.getBugLog());
		  LoggerLoad.info(LmsE2EPayload.getBugLog().toString());
		  System.out.println("-------------- Bug Report End --------------------------------");
		 LoggerLoad.info("-------------- Bug Report End --------------------------------");
		  		
		
	}

	}
	
	


