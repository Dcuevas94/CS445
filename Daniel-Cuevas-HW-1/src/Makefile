# MakeFile
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
	Thing.java \
	Creature.java \
	Ant.java \
	Flyer.java \
	Bat.java \
	Fly.java \
	Tiger.java \
	TestCreature.java

default: classes
	java TestCreature

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

java: 
	sudo apt-get update
	sudo apt-get install default-jre
	sudo apt-get install default-jdk

all: 
	sudo apt-get update
	sudo apt-get install default-jre
	sudo apt-get install default-jdk
	make
	java TestCreature
	
allwithkill:
	sudo apt-get update
	sudo apt-get install default-jre
	sudo apt-get install default-jdk
	make
	java TestCreature
	make clean
