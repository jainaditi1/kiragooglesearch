
## Kira Google Search
UI automation to search "Kira Systems" in Google Cananda.

The tests executes as search results appear after search criteria is entered. 


## How to execute test
Process #1 
* Go to `kiragooglesearch/src/test/java/com/uiautomation/kira/googlesearch/GoogleSearchTest.java`, that holds testcases
* Right click on file name in Package Explorer and `run as` TestNG Test

Process #2
 * Right click on  `testNG.xml`, that holds test class(es) name to be executed

Process #3
 * execute mvn command from command line
 `mvn clean test -DsuiteXMLFile=testNG.xml`


## Framework
This is a Maven project and framework consist of following JARs:
  * Selenium
  * TestNG
  * extentreport
  * Java 1.8+

### Structure
This project is your standard Maven Java project with `src` folders, `testNG.xml` and `POM.xml`.

### Models
`src/main/java/model` represents UI screen properties equivalent to respective page objects. 
Each model consist of UI elements with respect to their unique locators, with an impertaive assertion of element to be enabled or displayed in order to make sure of accessibility during test run. 
Models contains representation of entities like Search.Java, SearchResult.java etc.

### Properties
`src/main/resources/configs/runConfig.properties` is a simple properties file to store various common configurations that are required by any/all tests to be executed.
`src/main/resources/drivers` consist of drivers for each browser. Currently it contains only `Chrome` driver, but `firefox`, `IE`, `Safari`, or `Netgear` drivers can be included here. 
`src/main/testdata/data.properties` consist of testdata like text search on provider name. 


### Pre-configuration
`src/main/java/BasicSetup.java` is the tests superclass for configuration and common code

### Tests
`kiragooglesearch/src/test/java/com/uiautomation/kira/googlesearch/GoogleSearchTest.java` holds test classes (TestNG)

### Reports
extentreports get generated as soon as the test are run. Test results are saved insidee `test-output` directory under root. 
HTML file is generated for each run with prefix `testReport-` followed by date and time of the run. 

### Screenshots
All screenshots are stored in `System.getProperty("user.dir") + "/screenshots/searchResult.png"`

 
