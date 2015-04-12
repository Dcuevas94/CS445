# MakeFile
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
	B.java \
	A.java \
	C.java \
	D.java \
	E.java \
	F.java \
	ImprovedRandom.java \
	ImprovedStringTokenizer.java

default: classes
	java ImprovedRandom
	java ImprovedStringTokenizer

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
	java ImprovedRandom
	java ImprovedStringTokenizer
	
