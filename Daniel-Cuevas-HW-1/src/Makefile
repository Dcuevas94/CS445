# MakeFile
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
	Ant.java \
	Bat.java \
	Creature.java \
	Fly.java \
	Flyer.java \
	TestCreature.java \
	Thing.java \
	Tiger.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class