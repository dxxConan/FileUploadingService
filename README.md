## FileUploadingService

####Description
This is a rest webservice, which can be used to upload, download files(files will store in local hard disk) and store the metadata of those files in H2 database

####Installation
You can plugin the whole project using github, or download the project and import as maven project

**please change the configuration in application.properties file**

####Functions and Usage

1. /files/singleFileupload
	upload a single file
1. /files/multipleFileUpload
	upload multiple files
1. /files/{fileId}/metadata
	get the specific metadata info given id
1. /files/all
	get the metadata of all files
1. /files/search/{type}
	get the metadata of specific files given file type

####DataBase table

| File_ID       | File_Name     | File_Path      | File_Type     | Time_Stamp    |
| ------------- |:-------------:| --------------:| ------------- |:-------------:|
| 				| 				| 				 | ------------- |:-------------:| 
| 	 			|  		        |     			 | ------------- |:-------------:|
| 				| 		        |   			 | ------------- |:-------------:|
| 			    | 			    |   			 | ------------- |:-------------:|

