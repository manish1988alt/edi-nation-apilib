# Getting started

## How to Build

The generated code uses a few Maven dependencies e.g., Jackson, UniRest,
and Apache HttpClient. The reference to these dependencies is already
added in the pom.xml file will be installed automatically. Therefore,
you will need internet access for a successful build.

* In order to open the client library in Eclipse click on ``` File -> Import ```.

![Importing SDK into Eclipse - Step 1](https://apidocs.io/illustration/java?step=import0&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

* In the import dialog, select ``` Existing Java Project ``` and click ``` Next ```.

![Importing SDK into Eclipse - Step 2](https://apidocs.io/illustration/java?step=import1&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

* Browse to locate the folder containing the source code. Select the detected location of the project and click ``` Finish ```.

![Importing SDK into Eclipse - Step 3](https://apidocs.io/illustration/java?step=import2&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

* Upon successful import, the project will be automatically built by Eclipse after automatically resolving the dependencies.

![Importing SDK into Eclipse - Step 4](https://apidocs.io/illustration/java?step=import3&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

## How to Use

The following section explains how to use the EdiNationAPI library in a new console project.

### 1. Starting a new project

For starting a new project, click the menu command ``` File > New > Project ```.

![Add a new project in Eclipse](https://apidocs.io/illustration/java?step=createNewProject0&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

Next, choose ``` Maven > Maven Project ```and click ``` Next ```.

![Create a new Maven Project - Step 1](https://apidocs.io/illustration/java?step=createNewProject1&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

Here, make sure to use the current workspace by choosing ``` Use default Workspace location ```, as shown in the picture below and click ``` Next ```.

![Create a new Maven Project - Step 2](https://apidocs.io/illustration/java?step=createNewProject2&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

Following this, select the *quick start* project type to create a simple project with an existing class and a ``` main ``` method. To do this, choose ``` maven-archetype-quickstart ``` item from the list and click ``` Next ```.

![Create a new Maven Project - Step 3](https://apidocs.io/illustration/java?step=createNewProject3&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

In the last step, provide a ``` Group Id ``` and ``` Artifact Id ``` as shown in the picture below and click ``` Finish ```.

![Create a new Maven Project - Step 4](https://apidocs.io/illustration/java?step=createNewProject4&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

### 2. Add reference of the library project

The created Maven project manages its dependencies using its ``` pom.xml ``` file. In order to add a dependency on the *EdiNationAPILib* client library, double click on the ``` pom.xml ``` file in the ``` Package Explorer ```. Opening the ``` pom.xml ``` file will render a graphical view on the cavas. Here, switch to the ``` Dependencies ``` tab and click the ``` Add ``` button as shown in the picture below.

![Adding dependency to the client library - Step 1](https://apidocs.io/illustration/java?step=testProject0&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

Clicking the ``` Add ``` button will open a dialog where you need to specify EdiNationAPI in ``` Group Id ``` and EdiNationAPILib in the ``` Artifact Id ``` fields. Once added click ``` OK ```. Save the ``` pom.xml ``` file.

![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?step=testProject1&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

### 3. Write sample code

Once the ``` SimpleConsoleApp ``` is created, a file named ``` App.java ``` will be visible in the *Package Explorer* with a ``` main ``` method. This is the entry point for the execution of the created project.
Here, you can add code to initialize the client library and instantiate a *Controller* class. Sample code to initialize the client library and using controller methods is given in the subsequent sections.

![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?step=testProject2&workspaceFolder=EdiNation%20API-Java&workspaceName=EdiNationAPI&projectName=EdiNationAPILib&rootNamespace=com.edination.api)

## How to Test

The generated code and the server can be tested using automatically generated test cases. 
JUnit is used as the testing framework and test runner.

In Eclipse, for running the tests do the following:

1. Select the project *EdiNationAPILib* from the package explorer.
2. Select "Run -> Run as -> JUnit Test" or use "Alt + Shift + X" followed by "T" to run the Tests.

## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| ocpApimSubscriptionKey | API key to authenticate requests |



API client can be initialized as following.

```java
// Configuration parameters and credentials
String ocpApimSubscriptionKey = "ocpApimSubscriptionKey"; // API key to authenticate requests

EdiNationAPIClient client = new EdiNationAPIClient(ocpApimSubscriptionKey);
```


# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [EdifactController](#edifact_controller)
* [EdiModelController](#edi_model_controller)
* [X12Controller](#x12_controller)

## <a name="edifact_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.edination.api.controllers.EdifactController") EdifactController

### Get singleton instance

The singleton instance of the ``` EdifactController ``` class can be accessed from the API Client.

```java
EdifactController edifact = client.getEdifact();
```

### <a name="read_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.EdifactController.readAsync") readAsync

> Reads an EDIFACT file and returns its contents translated to an array of EdifactInterchange objects.


```java
void readAsync(
        final File fileName,
        final Boolean ignoreNullValues,
        final Boolean continueOnError,
        final String charSet,
        final String model,
        final Boolean eancomS3,
        final APICallBack<List<EdifactInterchange>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| fileName |  ``` Required ```  | Upload File |
| ignoreNullValues |  ``` Optional ```  ``` DefaultValue ```  | Whether to ignore all null values in the response. The default is false. |
| continueOnError |  ``` Optional ```  ``` DefaultValue ```  | Whether to continue reading if a corrupt interchange is encountered. The default is false. |
| charSet |  ``` Optional ```  ``` DefaultValue ```  | The encoding of the file contents. The default is utf-8. The available values are: unicodeFFFE, utf-32, utf-32BE, us-ascii, iso-8859-1, utf-7, utf-8, utf-16. |
| model |  ``` Optional ```  | The model to use. By default, the API will infer the model based on the transaction and version identifiers. |
| eancomS3 |  ``` Optional ```  ``` DefaultValue ```  | The default syntax for EANCOM transactions. By default all EANCOM transactions will be translated and validated according to the rules of Syntax 4. Set this flag to true if you need Syntax 3 to be used. |


#### Example Usage

```java
File fileName = new File("PathToFile");
Boolean ignoreNullValues = false;
Boolean continueOnError = false;
String charSet = "utf-8";
String model = "model";
Boolean eancomS3 = false;
// Invoking the API call with sample inputs
edifact.readAsync(fileName, ignoreNullValues, continueOnError, charSet, model, eancomS3, new APICallBack<List<EdifactInterchange>>() {
    public void onSuccess(HttpContext context, List<EdifactInterchange> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="write_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.EdifactController.writeAsync") writeAsync

> Translates an EdifactInterchange object to a raw EDIFACT interchange and returns it as a stream.


```java
void writeAsync(
        final Boolean preserveWhitespace,
        final String charSet,
        final String postfix,
        final Boolean sameRepetionAndDataElement,
        final Boolean eancomS3,
        final String contentType,
        final EdifactInterchange body,
        final APICallBack<InputStream> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| preserveWhitespace |  ``` Optional ```  ``` DefaultValue ```  | Whether to preserve blank data elements so the output contains multiple delimiters instead of omitting any excess delimiters. The default is false. |
| charSet |  ``` Optional ```  ``` DefaultValue ```  | The encoding of the file contents. The default is utf-8. The available values are: unicodeFFFE, utf-32, utf-32BE, us-ascii, iso-8859-1, utf-7, utf-8, utf-16. |
| postfix |  ``` Optional ```  | The postfix to be applied at the end of each segment, just after the segment separator. This is usually a carriage return (CR), line feed (LF) or both. By default, there is no postfix. |
| sameRepetionAndDataElement |  ``` Optional ```  ``` DefaultValue ```  | Sometimes the same delimiter is used to denote data element separator and repetition separator as in IATA transactions. By default, this is false. |
| eancomS3 |  ``` Optional ```  ``` DefaultValue ```  | The default syntax for EANCOM transactions. By default all EANCOM transactions will be translated and validated according to the rules of Syntax 4. Set this flag to true if you need Syntax 3 to be used. |
| contentType |  ``` Optional ```  ``` DefaultValue ```  | TODO: Add a parameter description |
| body |  ``` Optional ```  | The EdifactInterchange object to translate to raw EDIFACT. |


#### Example Usage

```java
try {
    Boolean preserveWhitespace = false;
    String charSet = "utf-8";
    String postfix = "postfix";
    Boolean sameRepetionAndDataElement = false;
    Boolean eancomS3 = false;
    String contentType = "application/json";
    EdifactInterchange body = new EdifactInterchange();
    // Invoking the API call with sample inputs
    edifact.writeAsync(preserveWhitespace, charSet, postfix, sameRepetionAndDataElement, eancomS3, contentType, body, new APICallBack<InputStream>() {
        public void onSuccess(HttpContext context, InputStream response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="validate_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.EdifactController.validateAsync") validateAsync

> Validates an EdifactInterchange object according to the EDIFACT standard rules for each version and transaction.


```java
void validateAsync(
        final String syntaxSet,
        final Boolean skipTrailer,
        final Boolean structureOnly,
        final String decimalPoint,
        final Boolean eancomS3,
        final String contentType,
        final EdifactInterchange body,
        final APICallBack<OperationResult> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| syntaxSet |  ``` Optional ```  | In case you need to validate against a syntax set, different than UNOA and UNOB, populate this filed with all of the allowed symbols, url-escaped. All data elements with alpha (A) or alphanumeric (AN) data types are validated against a syntax set of allowed characters. The supported syntax sets are UNOA and UNOB. The validator infers the correct syntax set from EdifactInterchange.UNB.SYNTAXIDENTIFIER_1.SyntaxIdentifier_1. The symbols added to this field will override the corresponding sets in both UNOA and UNOB. |
| skipTrailer |  ``` Optional ```  ``` DefaultValue ```  | You are allowed to validate an EdifactInterchange with missing interchange, functional group or transaction trailers (UNZ, UNE, UNT). This is because these will be automatically applied during the Write oprtaion so you don't have to worry about counting the items. By default it is expected that all trailers are present when you validate the EdifactInterchange and by default, this is set to false. To skip all trailer validation, set this to true. |
| structureOnly |  ``` Optional ```  ``` DefaultValue ```  | This is equivalent to HIPAA Snip level 1, where only the structure and control segments are validated. By default, this is set to false, however if you want to not validate things such as data types, number of repeteitions or dates, set this to true. |
| decimalPoint |  ``` Optional ```  ``` DefaultValue ```  | This could be either point . (default) or comma ,. |
| eancomS3 |  ``` Optional ```  ``` DefaultValue ```  | The default syntax for EANCOM transactions. By default all EANCOM transactions will be validated according to the rules of Syntax 4. Set this flag to true if you need Syntax 3 to be used. |
| contentType |  ``` Optional ```  ``` DefaultValue ```  | TODO: Add a parameter description |
| body |  ``` Optional ```  | The EdifactInterchange object to validate. |


#### Example Usage

```java
try {
    String syntaxSet = "syntaxSet";
    Boolean skipTrailer = false;
    Boolean structureOnly = false;
    String decimalPoint = ".";
    Boolean eancomS3 = false;
    String contentType = "application/json";
    EdifactInterchange body = new EdifactInterchange();
    // Invoking the API call with sample inputs
    edifact.validateAsync(syntaxSet, skipTrailer, structureOnly, decimalPoint, eancomS3, contentType, body, new APICallBack<OperationResult>() {
        public void onSuccess(HttpContext context, OperationResult response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="ack_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.EdifactController.ackAsync") ackAsync

> Generates functional and/or technical CONTRL acknowledment(s) for the requested EdifactInterchange.


```java
void ackAsync(
        final String syntaxSet,
        final Boolean detectDuplicates,
        final Integer tranRefNumber,
        final Integer interchangeRefNumber,
        final Boolean ackForValidTrans,
        final Boolean batchAcks,
        final String technicalAck,
        final Boolean eancomS3,
        final String contentType,
        final EdifactInterchange body,
        final APICallBack<List<EdifactInterchange>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| syntaxSet |  ``` Optional ```  | In case you need to validate against a syntax set, different than UNOA and UNOB, populate this filed with all of the allowed symbols, url-escaped. All data elements with alpha (A) or alphanumeric (AN) data types are validated against a syntax set of allowed characters. The supported syntax sets are UNOA and UNOB. The validator infers the correct syntax set from EdifactInterchange.UNB.SYNTAXIDENTIFIER_1.SyntaxIdentifier_1. The symbols added to this field will override the corresponding sets in both UNOA and UNOB. |
| detectDuplicates |  ``` Optional ```  ``` DefaultValue ```  | If you need to detect duplicates as in functional groups or transactions with the same reference number, set this flag to true. The default is false. |
| tranRefNumber |  ``` Optional ```  ``` DefaultValue ```  | The default is 1. Set this to whatever the CONTRL UNH.MessageReferenceNumber_01 needs to be. |
| interchangeRefNumber |  ``` Optional ```  ``` DefaultValue ```  | The default is 1. Set this to whatever the CONTRL EdifactInterchange.UNB.InterchangeControlReference_5 needs to be. |
| ackForValidTrans |  ``` Optional ```  ``` DefaultValue ```  | The default is false. Set this to true if you need UCM loops included for all valid transaction as well. By default UCM loops are generated only for invalid transactions. |
| batchAcks |  ``` Optional ```  ``` DefaultValue ```  | The default is true. Set this to false if you need to generate separate EdifactInterchange for each acknowledgment. By default all acknowledgments are batched in the same EdifactInterchange. |
| technicalAck |  ``` Optional ```  | The default technical acknowledgment CONTRL is generated according to EdifactInterchange.UNB.AcknowledgementRequest_9. You can either enforce it to always generate technical CONTRLs or supress it to never generate any technical CONTRLs. This will override the flag in EdifactInterchange.UNB.AcknowledgementRequest_9. The available values are: default, enforce, suppress. |
| eancomS3 |  ``` Optional ```  ``` DefaultValue ```  | The default syntax for EANCOM transactions. By default all EANCOM transactions will be validated according to the rules of Syntax 4. Set this flag to true if you need Syntax 3 to be used. |
| contentType |  ``` Optional ```  ``` DefaultValue ```  | TODO: Add a parameter description |
| body |  ``` Optional ```  | The EdifactInterchange object to acknowledge. |


#### Example Usage

```java
try {
    String syntaxSet = "syntaxSet";
    Boolean detectDuplicates = false;
    Integer tranRefNumber = 1;
    Integer interchangeRefNumber = 1;
    Boolean ackForValidTrans = false;
    Boolean batchAcks = true;
    String technicalAck = "technicalAck";
    Boolean eancomS3 = false;
    String contentType = "application/json";
    EdifactInterchange body = new EdifactInterchange();
    // Invoking the API call with sample inputs
    edifact.ackAsync(syntaxSet, detectDuplicates, tranRefNumber, interchangeRefNumber, ackForValidTrans, batchAcks, technicalAck, eancomS3, contentType, body, new APICallBack<List<EdifactInterchange>>() {
        public void onSuccess(HttpContext context, List<EdifactInterchange> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



[Back to List of Controllers](#list_of_controllers)

## <a name="edi_model_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.edination.api.controllers.EdiModelController") EdiModelController

### Get singleton instance

The singleton instance of the ``` EdiModelController ``` class can be accessed from the API Client.

```java
EdiModelController ediModel = client.getEdiModel();
```

### <a name="upload_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.EdiModelController.uploadAsync") uploadAsync

> Uploads a model file to a subscription. It must be a valid DOT NET assembly.


```java
void uploadAsync(
        final File fileName,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| fileName |  ``` Required ```  | Upload File |


#### Example Usage

```java
File fileName = new File("PathToFile");
// Invoking the API call with sample inputs
ediModel.uploadAsync(fileName, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="get_models_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.EdiModelController.getModelsAsync") getModelsAsync

> Retrieves all models for a subscription.


```java
void getModelsAsync(
        final Boolean system,
        final APICallBack<List<EdiModel>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| system |  ``` Optional ```  ``` DefaultValue ```  | Whether to retrieve EdiNation's or custom uploaded models. |


#### Example Usage

```java
Boolean system = true;
// Invoking the API call with sample inputs
ediModel.getModelsAsync(system, new APICallBack<List<EdiModel>>() {
    public void onSuccess(HttpContext context, List<EdiModel> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="get_model_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.EdiModelController.getModelAsync") getModelAsync

> Retrieve a particular model file as a stream.


```java
void getModelAsync(
        final String id,
        final Boolean system,
        final APICallBack<InputStream> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| id |  ``` Required ```  | The model name. |
| system |  ``` Optional ```  ``` DefaultValue ```  | Whether to search in EdiNation's or custom uploaded models. |


#### Example Usage

```java
String id = "id";
Boolean system = true;
// Invoking the API call with sample inputs
ediModel.getModelAsync(id, system, new APICallBack<InputStream>() {
    public void onSuccess(HttpContext context, InputStream response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="delete_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.EdiModelController.deleteAsync") deleteAsync

> Deletes a particular model from the custom models.


```java
void deleteAsync(
        final String id,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| id |  ``` Required ```  | The model name. |


#### Example Usage

```java
String id = "id";
// Invoking the API call with sample inputs
ediModel.deleteAsync(id, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



[Back to List of Controllers](#list_of_controllers)

## <a name="x12_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.edination.api.controllers.X12Controller") X12Controller

### Get singleton instance

The singleton instance of the ``` X12Controller ``` class can be accessed from the API Client.

```java
X12Controller x12 = client.getX12();
```

### <a name="read_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.X12Controller.readAsync") readAsync

> Reads an X12 file and returns its contents translated to an array of X12Interchange objects.


```java
void readAsync(
        final File fileName,
        final Boolean ignoreNullValues,
        final Boolean continueOnError,
        final String charSet,
        final String model,
        final APICallBack<List<X12Interchange>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| fileName |  ``` Required ```  | Upload File |
| ignoreNullValues |  ``` Optional ```  ``` DefaultValue ```  | Whether to ignore all null values in the response. The default is false. |
| continueOnError |  ``` Optional ```  ``` DefaultValue ```  | Whether to continue reading if a corrupt interchange is encountered. The default is false. |
| charSet |  ``` Optional ```  ``` DefaultValue ```  | The encoding of the file contents. The default is utf-8. The available values are: unicodeFFFE, utf-32, utf-32BE, us-ascii, iso-8859-1, utf-7, utf-8, utf-16. |
| model |  ``` Optional ```  | The model to use. By default, the API will infer the model based on the transaction and version identifiers. |


#### Example Usage

```java
File fileName = new File("PathToFile");
Boolean ignoreNullValues = false;
Boolean continueOnError = false;
String charSet = "utf-8";
String model = "model";
// Invoking the API call with sample inputs
x12.readAsync(fileName, ignoreNullValues, continueOnError, charSet, model, new APICallBack<List<X12Interchange>>() {
    public void onSuccess(HttpContext context, List<X12Interchange> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="write_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.X12Controller.writeAsync") writeAsync

> Translates an X12Interchange object to a raw X12 interchange and returns it as a stream.


```java
void writeAsync(
        final Boolean preserveWhitespace,
        final String charSet,
        final String postfix,
        final String contentType,
        final X12Interchange body,
        final APICallBack<InputStream> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| preserveWhitespace |  ``` Optional ```  ``` DefaultValue ```  | Whether to preserve blank data elements so the output contains multiple delimiters instead of omitting any excess delimiters. The default is false. |
| charSet |  ``` Optional ```  ``` DefaultValue ```  | The encoding of the file contents. The default is utf-8. The available values are: unicodeFFFE, utf-32, utf-32BE, us-ascii, iso-8859-1, utf-7, utf-8, utf-16. |
| postfix |  ``` Optional ```  | The postfix to be applied at the end of each segment, just after the segment separator. This is usually a carriage return (CR), line feed (LF) or both. By default, there is no postfix. |
| contentType |  ``` Optional ```  ``` DefaultValue ```  | TODO: Add a parameter description |
| body |  ``` Optional ```  | The X12Interchange object to translate to raw X12. |


#### Example Usage

```java
try {
    Boolean preserveWhitespace = false;
    String charSet = "utf-8";
    String postfix = "postfix";
    String contentType = "application/json";
    X12Interchange body = new X12Interchange();
    // Invoking the API call with sample inputs
    x12.writeAsync(preserveWhitespace, charSet, postfix, contentType, body, new APICallBack<InputStream>() {
        public void onSuccess(HttpContext context, InputStream response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="validate_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.X12Controller.validateAsync") validateAsync

> Validates an X12Interchange object according to the X12 standard rules for each version and transaction.


```java
void validateAsync(
        final Boolean basicSyntax,
        final String syntaxSet,
        final Boolean skipTrailer,
        final Boolean structureOnly,
        final String contentType,
        final X12Interchange body,
        final APICallBack<OperationResult> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| basicSyntax |  ``` Optional ```  ``` DefaultValue ```  | All data elements with alpha (A) or alphanumeric (AN) data types are validated against a syntax set of allowed characters. The default syntax set is the Extended, hence the default for this parameter is false. By setting this to true, validation will use the Basic syntax set. |
| syntaxSet |  ``` Optional ```  | In case you need to validate against a syntax set, different than Basic and Extended, populate this filed with all of the allowed symbols, url-escaped. |
| skipTrailer |  ``` Optional ```  ``` DefaultValue ```  | You are allowed to validate an X12Interchange with missing interchange, functional group or transaction trailers (IEA, GE, SE). This is because these will be automatically applied during the Write oprtaion so you don't have to worry about counting the items. By default it is expected that all trailers are present when you validate the X12Interchange and by default, this is set to false. To skip all trailer validation, set this to true. |
| structureOnly |  ``` Optional ```  ``` DefaultValue ```  | This is equivalent to HIPAA Snip level 1, where only the structure and control segments are validated. By default, this is set to false, however if you want to not validate things such as data types, number of repeteitions or dates, set this to true. |
| contentType |  ``` Optional ```  ``` DefaultValue ```  | TODO: Add a parameter description |
| body |  ``` Optional ```  | The X12Interchange object to validate. |


#### Example Usage

```java
try {
    Boolean basicSyntax = false;
    String syntaxSet = "syntaxSet";
    Boolean skipTrailer = false;
    Boolean structureOnly = false;
    String contentType = "application/json";
    X12Interchange body = new X12Interchange();
    // Invoking the API call with sample inputs
    x12.validateAsync(basicSyntax, syntaxSet, skipTrailer, structureOnly, contentType, body, new APICallBack<OperationResult>() {
        public void onSuccess(HttpContext context, OperationResult response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



### <a name="ack_async"></a>![Method: ](https://apidocs.io/img/method.png "com.edination.api.controllers.X12Controller.ackAsync") ackAsync

> Generates functional/implementation and/or technical acknowledment(s) for the requested X12Interchange.


```java
void ackAsync(
        final Boolean basicSyntax,
        final String syntaxSet,
        final Boolean detectDuplicates,
        final Integer tranRefNumber,
        final Integer interchangeRefNumber,
        final Boolean ackForValidTrans,
        final Boolean batchAcks,
        final String technicalAck,
        final String ack,
        final Boolean ak901isP,
        final String contentType,
        final X12Interchange body,
        final APICallBack<List<X12Interchange>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| basicSyntax |  ``` Optional ```  ``` DefaultValue ```  | All data elements with alpha (A) or alphanumeric (AN) data types are validated against a syntax set of allowed characters. The default syntax set is the Extended, hence the default for this parameter is false. By setting this to true, validation will use the Basic syntax set. |
| syntaxSet |  ``` Optional ```  | In case you need to validate against a syntax set, different than Basic and Extended, populate this filed with all of the allowed symbols, url-escaped. |
| detectDuplicates |  ``` Optional ```  ``` DefaultValue ```  | If you need to detect duplicates as in functional groups or transactions with the same reference number, set this flag to true. The default is false. |
| tranRefNumber |  ``` Optional ```  ``` DefaultValue ```  | The default is 1. Set this to whatever the 997 or 999 X12Interchange.ST.TransactionSetControlNumber_02 needs to be. In case there are multiple acknowledgments (for multiple functional groups), this will be starting reference number and every subsequent acknowledgment will have the previous reference number incremented with 1. |
| interchangeRefNumber |  ``` Optional ```  ``` DefaultValue ```  | The default is 1. Set this to whatever the 997 or 999 X12Interchange.ISA.InterchangeControlNumber_13 needs to be. |
| ackForValidTrans |  ``` Optional ```  ``` DefaultValue ```  | The default is false. Set this to true if you need AK2 loops included for all valid transaction as well. By default AK2 loops are generated only for invalid transactions. |
| batchAcks |  ``` Optional ```  ``` DefaultValue ```  | The default is true. Set this to false if you need to generate separate X12Interchange for each acknowledgment. By default all acknowledgments are batched in the same X12Interchange. |
| technicalAck |  ``` Optional ```  | The default technical acknowledgment TA1 is generated according to X12Interchange.ISA.AcknowledgementRequested_14. You can either enforce it to always generate TA1s or supress it to never generate any TA1s. This will override the flag in X12Interchange.ISA.AcknowledgementRequested_14. The available values are: default, enforce, suppress. |
| ack |  ``` Optional ```  ``` DefaultValue ```  | The default value is 997. The type of acknowledgment being generated. Set this to 999 if you need to generate an implementation instead of functional acknowledgment. The available values are: 997, 999. |
| ak901isP |  ``` Optional ```  ``` DefaultValue ```  | The value of the AK9's first element. By default it is "E". Set this to true if you want this value to be "P" instead. |
| contentType |  ``` Optional ```  ``` DefaultValue ```  | TODO: Add a parameter description |
| body |  ``` Optional ```  | The X12Interchange object to acknowledge. |


#### Example Usage

```java
try {
    Boolean basicSyntax = false;
    String syntaxSet = "syntaxSet";
    Boolean detectDuplicates = false;
    Integer tranRefNumber = 1;
    Integer interchangeRefNumber = 1;
    Boolean ackForValidTrans = false;
    Boolean batchAcks = true;
    String technicalAck = "technicalAck";
    String ack = "997";
    Boolean ak901isP = false;
    String contentType = "application/json";
    X12Interchange body = new X12Interchange();
    // Invoking the API call with sample inputs
    x12.ackAsync(basicSyntax, syntaxSet, detectDuplicates, tranRefNumber, interchangeRefNumber, ackForValidTrans, batchAcks, technicalAck, ack, ak901isP, contentType, body, new APICallBack<List<X12Interchange>>() {
        public void onSuccess(HttpContext context, List<X12Interchange> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request |
| 500 | Server Error |



[Back to List of Controllers](#list_of_controllers)



