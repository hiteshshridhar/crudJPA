This is a simple Spring Crud Application where:
  
    we create a student Entity, this is used for connecting with DB which is "MySQL"
    Then we create an Interface whch has methods declared in it. 
    Then we create the implementation of the interface, which defines the methods what they do.

Then we use **CommandLineRunner** to instantiate out **studentDAO** interface, and we call the methods defined in it using it. 
Not the best approach but a simple one to understand the workflow of the code. 

How it works:
    
    Main Application is loaded first. It checks and injects the dependencies
    Calls the method defined in it which in return are used to instantiate connection with the db.
    Using dependency Injection of the Interface creates loose coupling between modules which is a better approach.

## There are 2 SQL files which we need to run initially at the project start since we are inserting data by ourselves

### Please note down the file names:     
     Inside folder:  00-starter-sql-scripts
        **01-create-user.sql**
        **02-student-tracker.sql**
    

    Then we can create student without really inserting records manually, using the createMultipleStudent() method.  


  
