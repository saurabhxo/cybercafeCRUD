𝐎𝐯𝐞𝐫𝐯𝐢𝐞𝐰

A comprehensive web service for managing a cyber cafe, facilitating user registration, computer details, and seamless assignment management. It efficiently assign and remove computers for users, ensuring a smooth cyber cafe experience.

𝐅𝐞𝐚𝐭𝐮𝐫𝐞𝐬


1.User Management: Add, view user details.

2.Computer Management: Add, view computer details.

3.Assignment: User can send request for assign a available computers if any free computers are there it will assigned to requested user.

4.Unassignment: User can send request for unassigning assigned computers.

𝐃𝐚𝐭𝐚𝐛𝐚𝐬𝐞 𝐝𝐞𝐬𝐢𝐠𝐧:-

<img width="571" alt="Screenshot 2023-12-22 222511" src="https://github.com/saurabhxo/cybercafeCRUD/assets/56174993/66e9e473-2bf4-44d7-8c14-ceeac74c9256">


𝐃𝐢𝐫𝐞𝐜𝐭𝐨𝐫𝐲 𝐒𝐭𝐫𝐮𝐜𝐭𝐮𝐫𝐞 𝐈𝐧𝐟𝐨:-

This is the structure of working directory.

<img width="242" alt="Screenshot 2023-12-22 223556" src="https://github.com/saurabhxo/cybercafeCRUD/assets/56174993/0ef08421-01a6-4412-a87e-1ade8d6eaf1f">

I am start explaining with controller:-
So, in controller directory we have 4 classes.

1.ComputerController:-

It includes endpoints for creating a new computer (/create) and retrieving all computers (/getAll) by utilizing the corresponding methods from the ComputerRepository. The controller interacts with a Spring Data JPA repository to perform database operations for computer entities.

2.UserController:-

It includes endpoints for creating a new user (/create) and retrieving all users (/getAll) by utilizing the corresponding methods from the UserRepository. The controller interacts with a Spring Data JPA repository to perform database operations for user entities.

3.UserWithComputerController:-

The UserWithComputerController class is a Spring Boot RESTful controller managing user-computer assignments. It provides endpoints for assigning a free computer to a user (/assign), unassigning a computer from a user (/unassign), and retrieving a list of all users with their assigned computers (/getAll). The controller interacts with UserRepository and ComputerRepository to handle user and computer entities, ensuring proper assignment status updates in the database.

4.UserWithComputerResponse.

The UserWithComputerResponse class represents a response object containing a User and an optional Computer associated with the user, facilitating the representation of user-computer relationships in the context of the UserWithComputerController.

Now We have two model:-

1.User:-

The User model class represents a user entity with attributes such as userId, userName, emailId, and phoneNumber. It is annotated for JPA persistence, includes a bidirectional relationship with the Computer entity through the assignedComputerId, and incorporates annotations for JSON serialization control. The class also provides constructors, getters, setters, and a toString method for convenient object manipulation and representation.

2.Computer:-

The Computer model class represents a computer entity with attributes such as computerId, modelName, ram, and hardDisk. It is annotated for JPA persistence, includes fields for computer status, and utilizes JSON serialization annotations for control. The class provides constructors, getters, setters, and a toString method for convenient object manipulation and representation. Additionally, the default constructor initializes the computerStatus to "Free" by default.

We have two Repository:-

1.ComputerRespositoru:

The ComputerRepository is a Spring Data JPA interface extending JpaRepository for the Computer entity, providing standard CRUD operations and a custom query method (findByComputerStatus) to retrieve a list of computers based on their status.

2. UserRepository:-

The UserRepository is a Spring Data JPA interface extending JpaRepository for the User entity, providing standard CRUD operations for user data in the underlying database.

𝐝𝐢𝐫𝐞𝐜𝐭𝐨𝐫𝐲 𝐬𝐫𝐜/𝐦𝐚𝐢𝐧/𝐫𝐞𝐬𝐨𝐮𝐫𝐜𝐞𝐬/𝐚𝐩𝐩𝐥𝐢𝐜𝐚𝐭𝐢𝐨𝐧.𝐩𝐫𝐨𝐩𝐞𝐫𝐭𝐢𝐞𝐬:-
In this directory database related authentication are there you can configure it by providing your DBname and username, password of your DB.

𝐓𝐞𝐜𝐡𝐧𝐨𝐥𝐨𝐠𝐢𝐞𝐬 𝐔𝐬𝐞𝐝

-> Java

-> Spring Boot

-> Hibernate (JPA)

-> RESTful APIs

-> MySQL

𝐆𝐞𝐭𝐭𝐢𝐧𝐠 𝐒𝐭𝐚𝐫𝐭𝐞𝐝

-> Clone the Repository using below command:

git clone https://github.com/saurabhxo/cybercafeCRUD.git

->Database Configuration:

Configure your database details in "application.properties".

Build and Run:

./mvnw clean install

./mvnw spring-boot:run


The application will be accessible at http://localhost:8080.


𝐀𝐏𝐈 𝐄𝐧𝐝𝐩𝐨𝐢𝐧𝐭𝐬:

1.User-related APIs: "/users".

    Creating new user:-
    
    i) curl -X GET http://localhost:8080/users/create

    Retriving All the users.
    
    ii) curl -X GET http://localhost:8080/users/getAll

2.Computer-related APIs: "/computers".

    Creating new computer:-
    
    i) curl -X GET http://localhost:8080/computers/create

    Retriving All the computers.
    
    ii) curl -X GET http://localhost:8080/computers/getAll

3.User with Computer Assignment APIs: "/usersWithComputer".

      AssignUser Endpoint:
      
      i)curl -X POST http://localhost:8080/usersWithComputer/assign -d "userId=1"

      unAssignUser Endpoint:

      ii)curl -X POST http://localhost:8080/usersWithComputer/unassign -d "userId=1"

      getAllUsersWithComputers Endpoint:

      iii)curl -X GET http://your-api-url.com/usersWithComputer/getAll
      
      

𝐒𝐚𝐦𝐩𝐥𝐞 𝐑𝐞𝐪𝐮𝐞𝐬𝐭𝐬:

Use tools like Postman to interact with the APIs.

