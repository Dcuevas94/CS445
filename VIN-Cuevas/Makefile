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
	sudo apt-get upgrade
	sudo apt-get dist-upgrade
	sudo apt-get install default-jre
	sudo apt-get install default-jdk
	sudo apt-get install maven
	mvn -version

chrome:
	sudo apt-get install libxss1 libappindicator1 libindicator7
	wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
	sudo dpkg -i google-chrome*.deb

all: 
	make java
	make chrome
	make