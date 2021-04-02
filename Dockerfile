#### Frontend build otomation it was not realized because if it was; than need copy build 
#### files, to backend and start maven build. But maven build it was note realized because
#### always need dependencies download from maven repo when change code. It is not reasonable 
#### so I give up this idea but now I don't delete that just comment. With tis solution you 
#### need to get frontend build then copy to backend resource path. Than get backend build 
#### then get jar. So this jar actual thin of this docker image.  

### FRONTEND REACT BUILD
##<=====================================================================================>##

# #GET NODE IMAGE
# FROM node:8 AS frontend-build
# 
# WORKDIR /opt/ToDoApp-Frontend 
# COPY ToDoApp-Frontend .
# RUN npm install && npm run build


### BACKEND MAVEN BUILD
##<=====================================================================================>##

#GET MAVEN IMAGE
# FROM maven:3.6.3-openjdk-8-slim AS build
# 
# WORKDIR /opt/ToDoApp-Backend
# COPY ToDoApp-Backend .
# COPY --from=frontend-build /opt/ToDoApp-Frontend/build src/main/resources/static
# RUN mvn clean package


### RUN WEB APP
##<=====================================================================================>##

# GET JAVA IMAGE
FROM openjdk:8-jdk

WORKDIR /app
COPY ToDoApp-Backend/target/*.jar app.jar
#COPY --from=build /opt/ToDoApp-Backend/target/todoapp-1.0.0-RELEASED.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]