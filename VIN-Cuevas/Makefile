# MakeFile
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

default: 
	mvn compile exec:java
	
clean:
	mvn compile

java: 
	sudo apt-get update
	sudo apt-get install default-jre
	sudo apt-get install default-jdk
	sudo apt-get install maven
	mvn -version

all: 
	sudo apt-get update
	sudo apt-get install default-jre
	sudo apt-get install default-jdk
	mvn clean
	make