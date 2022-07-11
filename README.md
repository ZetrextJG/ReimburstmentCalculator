# reimburstment_calc

## Description

A small web app consistent of a frontend and backend parts.
Main usage of the app is to calculate reimbursement claims.

Backend uses basic java httpServer to handle http requests to the API.

Frontend is written in Vue.js (Vue version 3)

## Requirements

### JAVA 11

The easiest way to install Java 11 on Windows is to download 
and install the Microsoft build of OpenJDK 11.

[OpenJDK 11 build by Microsoft](https://docs.microsoft.com/en-us/java/openjdk/download)

Scroll down and find "OpenJDK 11" and download the x64 msi executable for Windows

![Download page](.\intructions\MicrosoftOpenJDK.png)

During installation select to create JAVA_HOME variable.

![Java Installation](.\intructions\InstallingJava.PNG)

#### Changing PATH variable

If you have more than one instance of Java JDKs installed on your system 
you may need to fix your PATH to point to our Java at version 11.

To do that add following line to your PATH variable.
```html
%JAVA_HOME%/bin/
```
and remove all lines that reverent other Java executables.

[How to change PATH on Windows 10](https://www.architectryan.com/2018/03/17/add-to-the-path-on-windows-10/)

### Maven
Maven is a build tool that allows us to easily test compile and run Java projects.

To install Maven all you have to do is download zip with binaries from:
[Apache Maven Download Page](https://maven.apache.org/download.cgi)

![Maven Download Page](.\intructions\MavenDownload.PNG)

Download "Binary zip archive" and unpack it to an easily accessible location on your drive.
For example:
- C:\apache-maven-3.8.6

#### Adding Maven to PATH

After unpacking maven binaries to a known folder we need to add bin folder 
to system PATH.

In our case we need to add:
- C:\apache-maven-3.8.6\bin\
 
[How to change PATH on Windows 10](https://www.architectryan.com/2018/03/17/add-to-the-path-on-windows-10/)

### Node.js

Go to the Node.js site and download the Latest version of node (Current version)
[Node.js Site](https://nodejs.org/en/)
![](.\intructions\Node.PNG)

Download the installer and go through the basic installation.

### Yarn

To install Yarn globally open console by pressing Ctrl-X and typing cmd.
The console should appear.
After that happens input command:
```bash
npm -g install yarn
```

## Building and using the app

### Clone the repository

If you are familiar with git, you need to simply clone the repository

In other case download and unpack zip:
![Github Clone Repo](.\intructions\clone.PNG)

You should have a folder structure similar to this:
![Folder structure](.\intructions\Folders.PNG)

### Startup a backend server
Enter the BackendServer folder and click on the top bar and input cmd
in order to start a console with working directory set to our BackendServer folder.
![Before](.\intructions\TopBarBefore.PNG)
![After](.\intructions\TopBarAfter.png)

If you have installed Maven correctly you will have access to mvn command.

Now to test build and run our server input command:
```bash
mvn verify test compile exec:java
```
If you have already built the app once then you can do only:
```bash
mvn exec:java
```
to skip the building and testing part.

Keep the console open while the server is running in order to use the app.

### Launch Frontend part

Open the console similarly to the backend part in the main folder of the app:
**\reimbursement_calc**

Using Yarn install required dependencies:
```bash
yarn
```

#### Option 1. Development server

To run the frontend in development mode run:

```bash
yarn serve
```

#### Option 2. Build website

Use Yarn to build our app:
```bash
yarn build
```
Install local-web-server:
```bash
npm -g install local-web-server
```

**There is no need to build app and install web-server more than once**

Now run the local-web-server on port 8080:

```bash
ws -p 8080
```

### Using the app

Now if the backend server and frontend site is running. 
You can go to your browser and use the app, which will be available for your
at: [localhost:8080]("http://localhost:8080").

## Known issues
Sometimes buttons do not respond, in that case it is necessary to click then again.
