package fuzzymatcher_server.main;

import java.io.IOException;
import java.net.UnknownHostException;

import fuzzymatcher_server.core.client.FuzzyMatcher_Client;
import fuzzymatcher_server.core.datamodel.Message_Matcher;

public class Main_Example_Client {
	
	
	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		
		
		/* default values : localhost, port 6666 */
		FuzzyMatcher_Client fuzzymatcher_client = new FuzzyMatcher_Client();
		fuzzymatcher_client.setPort(6666);
		fuzzymatcher_client.setHost("localhost");
		
		/* ping server */
		boolean isAlive = fuzzymatcher_client.pingServer();
		
		/* verify if a source contains a pattern */
		/* positive example */
		Message_Matcher msg_matcher = fuzzymatcher_client.analyse("Source example", "exeemple");

		/* get information */
		System.out.println("Matched : " + msg_matcher.getMatching());
		System.out.println("Start : " + msg_matcher.getStart());
		System.out.println("End : " + msg_matcher.getEnd());
		System.out.println("Result : " + msg_matcher.getResult());
		System.out.println("Matched string source : " + msg_matcher.getMatchedSource());
		
		
		
		/* Negative example */
		msg_matcher = fuzzymatcher_client.analyse("Source example", "AABB AAB");

		/* get information */
		System.out.println("Matched : " + msg_matcher.getMatching());
		System.out.println("Start : " + msg_matcher.getStart());
		System.out.println("End : " + msg_matcher.getEnd());
		System.out.println("Result : " + msg_matcher.getResult());
		System.out.println("Matched string source : " + msg_matcher.getMatchedSource());
		
	}

	

}
