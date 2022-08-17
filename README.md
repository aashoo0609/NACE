# Nomenclature of Economic Activities

API is used to : 
1. Persist the data in in-memory data base from a CSV file which is present at:
https://ec.europa.eu/eurostat/ramon/nomenclatures/index.cfm?TargetUrl=LST_CLS_DLD&StrNom=NACE_REV2&StrLanguage

2. Retrives all the NACE details based on Order_id.

How to Build and Run:
Option 1: Via Maven

    Step 1: Open Terminal and navigate to the root of the project.
    Step 2: To Build-
            mvn clean install
    Step 3: To Run-
            mvn spring-boot:run

Option 2: Via IDE - IntelliJ

    Step 1: Open the project source into IntelliJ/Ecllipse.
    Step 2: To Build : From the main menu, select Build | Build Project.
    Step 3: To Run: Go to NaceApplication.java file and then right click and select "Run NaceApplication.main()"
    Also Execute the maven commands in IDE's terminal window

Swagger URL:

    http://localhost:8080/swagger-ui.html#/nace-controller

H2 Database:
    
    http://localhost:8080/h2-console
    url : jdbc:h2:mem:dcbapp
    username : sa
    password : 

Postman:

    POST : 
        Request : http://localhost:8080/api/NACEDetails
        Response : 201 Created

    GET : 
        Request : http://localhost:8080/api/NACEDetails/398481
        Response : 
            {
                "order_id": 398481,
                "level_id": 1,
                "code": "A",
                "parent": "",
                "description": "AGRICULTURE, FORESTRY AND FISHING",
                "itemIncludes": "This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.",
                "itemAlsoIncludes": "",
                "rulings": "",
                "itemExcludes": "",
                "reference": "A"
            }
