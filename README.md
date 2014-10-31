# FuzzyMatcher-server

[FuzzyMatcher-server](https://github.com/jfaucon/fuzzymatcher-server) is a simple java server for [FREJ](frej.sourceforge.net), a library to perform fuzzy regular expressions.


## Install

1. Clone FuzzyMatcher-server
```bash
 git clone https://github.com/jfaucon/fuzzymatcher-server
 cd talismane
```
    
2. Build FuzzyMatcher-server with Ant
```bash
 ant jar
```
 

## Run server

* Run server :
```bash 
 cd fuzzymatcher-server/dist/
 java -Xmx2G -jar fuzzymatcher-sever-0.1b.jar
 
 or
 
 java -Xmx2G -jar fuzzymatcher-server-0.1b.jar port=1010
```     

* By default, FuzzyMatcher-Server runs on port 6666 and can be reached on "localhost" (in a local use).


## Usage in a Java environment


* Import fuzzymatcher-server-0.1.jar in your java project.

```java
 cp fuzzymatcher-srver/dist/fuzzymatcher-server-0.1b.jar /path/toyour/project
 chmod u+x /path/toyour/project/fuzzymatcher-server-0.1b.jar
          
 export CLASSPATH="$CLASSPATH:/path/toyour/project/fuzzymatcher-server-0.1b.jar"
```    
    
* In your project, you can call FuzzyMatcher client like this :
```java
	/* default values : localhost, port 6666 */
		FuzzyMatcher_Client fuzzymatcher_client = new FuzzyMatcher_Client();
		
		/* ping server */
		boolean isAlive = fuzzymatcher_client.pingServer();
		
		/* verify if a source contains a pattern */
		/* positive example */
		Message_Matcher msg_matcher 
				= fuzzymatcher_client.analyse("Source example", "exeemple");

		/* get information */
		System.out.println("Matched : " + msg_matcher.getMatching());
		System.out.println("Start : " + msg_matcher.getStart());
		System.out.println("End : " + msg_matcher.getEnd());
		System.out.println("Result : " + msg_matcher.getResult());
		System.out.println("Matched string source : " + msg_matcher.getMatchedSource());
		
		
		
		/* Negative example */
		msg_matcher 
				= fuzzymatcher_client.analyse("Source example", "AABB AAB");

		/* get information */
		System.out.println("Matched : " + msg_matcher.getMatching());
		System.out.println("Start : " + msg_matcher.getStart());
		System.out.println("End : " + msg_matcher.getEnd());
		System.out.println("Result : " + msg_matcher.getResult());
		System.out.println("Matched string source : " + msg_matcher.getMatchedSource());

```



