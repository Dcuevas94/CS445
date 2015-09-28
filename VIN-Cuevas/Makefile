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

chrome:
	cd /tmp
	wget https://dl.google.com/linux/direct/google-chrome-stable_current_i386.deb
	sudo dpkg -i google-chrome-stable_current_i386.deb

all: 
	sudo apt-get update
	sudo apt-get install default-jre
	sudo apt-get install default-jdk
	sudo apt-get install maven
	mvn clean
	make