///////////////////////////////////////////////////////////////////////////////
//Copyright (C) 2012 Jean-Philippe Fauconnier
//
//This file is part of TalismaneClient.
//
//TalismaneClient is free software: you can redistribute it and/or modify
//it under the terms of the GNU Affero General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//Talismane is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU Affero General Public License for more details.
//
//You should have received a copy of the GNU Affero General Public License
//along with Talismane.  If not, see <http://www.gnu.org/licenses/>.
//////////////////////////////////////////////////////////////////////////////
package fuzzymatcher_server.main;

import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import fuzzymatcher_server.core.server.FuzzyMatcher_Server;


public class Main_Jar_Client {

	/**
	 * Main class for jar. Use 'ant dist' to build a new jar.
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws InterruptedException
	 * @author Jean-Philippe Fauconnier
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException, InterruptedException {

		/* default values */
		int port = 6666;

		/* dirty quick solution to parse args */
		Pattern pathFileStdin_pattern = Pattern.compile("true",
				Pattern.CASE_INSENSITIVE);
		for (String currArgs : args) {
			 if (currArgs.matches("port=([0-9])*")) {
				port = Integer
						.parseInt(currArgs.substring(5, currArgs.length()));
			}else if (currArgs.matches("--help")) {
				printUsage();
			}
		}

		/* init. FuzzyMatcher-Server */
		FuzzyMatcher_Server fuzzymatcher_server = new FuzzyMatcher_Server();
		fuzzymatcher_server.setPort(port);
		fuzzymatcher_server.process();
		
	}
	
	static void printUsage() {
		/* usage */
		System.err.println("Usage:\njava -jar fuzzymatcher-server-0.1b.jar "
				+ "port=[*6666] source=source pattern=pattern"
				+ "\n\t* indicates default values for args.");
		System.exit(1);
	}

}
