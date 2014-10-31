package fuzzymatcher_server.main;

import fuzzymatcher_server.core.server.FuzzyMatcher_Server;

public class Main_Example_Server {

	public static void main(String[] args) {
		
		/* default port */
		int port = 6666;
		
		/* init. FuzzyMatcher-Server */
		FuzzyMatcher_Server fuzzymatcher_server = new FuzzyMatcher_Server();
		fuzzymatcher_server.setPort(port);
		fuzzymatcher_server.process();

	}

}
