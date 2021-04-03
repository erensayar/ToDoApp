# Prepared Docker Image

I prepared a docker image on Docker Hub. If you don't want to installations requirements, you can use it quickly docker image.

Image Source: https://hub.docker.com/repository/docker/erensayar/todoapp

* First Of All Get Docker https://docs.docker.com/engine/install/ubuntu/#install-from-a-package (I paste for linux setup. And this method install docker with downloaded packages. If you want you can use another way)

* Download docker image. 
        
        docker pull erensayar/todoapp:latest

* Then Run:

        $ sudo docker container run -p <your-choose-port>:8081 --rm <image-name>


# Requirements

Backend Requirements

* JDK 1.8 http://jdk.java.net/java-se-ri/8-MR3 (OpenJDK)
* Maven http://jdk.java.net/java-se-ri/8-MR3
    
Frontend Ruquirements:

* Node.js https://nodejs.org/en/download/ 

---

Requirements Setup For GNU/Linux:
--

1.You can use package manager:

Java:

    $ sudo apt-get update \
    && sudo apt-get install openjdk-8-jdk \
    && java -version

Maven:

    $ sudo apt install maven \
    && mvn -version

2.Manuel Setup:

* Get JDK And Maven compressed files.

* Then extract.

* Give name without space to files. (Java File: OpenJDK-1.8 | Maven: Maven)

* Then move files to any where permanently.

* Last thing you should set PATH and ENVIRONMENT VARIABLE:

    * Open terminal and open .bashrc file with any editor for edit this file. (I choose gedit for this example)

            $ gedit .bashrc

    * And then add this lines.        


    Maven:

        export M2_HOME=/${PATH}/${MAVEN-MAIN-DIRECTORY}
        export PATH=$M2_HOME/bin:$PATH

    Java:        

        export JAVA_HOME=/${PATH}/${JAVA-MAIN-DIRECTORY}
        export PATH=$JAVA_HOME/bin:$PATH

# Build And Run Application

* Get application source code with Git. (You should have git program for run this command or you can just download source code from browser)

        $ git clone https://github.com/erensayar/ToDoApp.git
        $ cd ToDoApp

* Compilation and build with maven.
    
        $ mvn package
    
* Now we have a jar file.

        java -jar target/ToDoApp.jar
        

# Default Application Configurations

* Server Port : 8081
* Swagger Directory : /swagger-ui.html
* H2 Console Directory : /h2-console/login
* H2 Console Configurations: 
    * User Name: sa
    * Datasource.url: jdbc:h2:mem:testdb
* Application Some User Name And Password For Authentication:
    * eren P4ssword
    * user1 P4ssword
    * user2 P4ssword...

# I Prepared Requests
You can find .har and .json file for import to request program. (Authorization information is embedded some files. Check the header.)

Directory: Backend > Requests
Request Samples:

Some Requests:

![Requests](/ToDoApp-Backend/Requests/SomeRequestsIMG.PNG) 

# Prepare Docker Image:

* Switch to project directory to access dockerfile and then create docker image.

        $ sudo docker image build -t <image-name> .

* For run this created image. Run a container.

        $ sudo docker container run -p <your-choose-port>:8081 --rm <image-name>

# Used Technologies And Softwares
<a href="https://getbootstrap.com" > <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="100" height="100"/> </a> 
<a href="https://www.w3schools.com/css/" > <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="100" height="100"/> </a> 
<a href="https://www.docker.com/" > <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="100" height="100"/> </a> 
<a href="https://www.w3.org/html/" > <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="100" height="100"/> </a> 
<a href="https://www.java.com" > <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="100" height="100"/> </a> 
<a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" > <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="100" height="100"/> </a> 
<a href="https://www.linux.org/" > <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/linux/linux-original.svg" alt="linux" width="100" height="100"/> </a>
<a href="https://reactjs.org/" > <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/react/react-original-wordmark.svg" alt="react" width="100" height="100"/> </a> 
<a href="https://sass-lang.com"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/sass/sass-original.svg" alt="sass" width="100" height="100"/> </a> 
<a href="https:/www.spring.io"><img src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg" height="100" width="300" alt="Spring"></a>
<a href="https://spring.io/projects/spring-boot"><img src="https://spring.io/images/projects/spring-boot-7f2e24fb962501672cc91ccd285ed2ba.svg" height="100"></a>
<a href="https://spring.io/projects/spring-data"><img src="https://spring.io/images/projects/spring-data-79cc203ed8c54191215a60f9e5dc638f.svg" height="100"></a>
<a href="https://junit.org/junit5/"><img src="https://junit.org/junit5/assets/img/junit5-logo.png" height="100"></a>
<a href="https://spring.io/projects/spring-security"><img src="https://spring.io/images/projects/spring-security-b712a4cdb778e72eb28b8c55ec39dbd1.svg" height="100"></a>
<a href="https://swagger.io/"><img src="https://static1.smartbear.co/swagger/media/assets/images/swagger_logo.svg" height="100" width="300" alt="Swagger Logo"></a>
<a href="https://maven.apache.org/" id="bannerRight"><img src="https://maven.apache.org/images/maven-logo-black-on-white.png" height="100" width="350" alt=""></a>
<a href="https://redux.js.org/"><img src="https://redux.js.org/img/redux.svg" height="100" width="100" alt="Redux Logo"></a>
<a href="/https://hibernate.org/"> <img alt="Hibernate" height="100" src="https://hibernate.org/images/hibernate-logo.svg" width="300"></a> 


# Application Screenshots
Login:
![Login](/ImagesForReadMe/ApplicationSS/Login.PNG) 

Signup:
![Signup](/ImagesForReadMe/ApplicationSS/SignUp.PNG)

Home:
![Home](/ImagesForReadMe/ApplicationSS/HomePage.PNG) 

Login Error Scenerio 1:
![LoginError1](/ImagesForReadMe/ApplicationSS/LoginError1.jpg) 

Login Error Scenerio 2:
![LoginError2](/ImagesForReadMe/ApplicationSS/LoginError2.jpg) 

Login Error Scenerio 3:
![LoginError3](/ImagesForReadMe/ApplicationSS/LoginError3.jpg) 

Login Error Scenerio 4:
![LoginError4](/ImagesForReadMe/ApplicationSS/LoginError4.jpg) 

# Frontend Notes
PS: You don't have to get node.js if you will not developing front side. I already got React App build and put to backend's resource.

PS: If you will developing front side, delete old builded files from backend side (resource/static) then move new builded files same directory. 

# What Needs To Be Fixed?
* Language Bug From Backend
* Home Page Get Data, Send Data
* Home Page Responsive Design
* Turkish Font Character Problem