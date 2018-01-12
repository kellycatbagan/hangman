all: Hangman.java
	javac Hangman.java
	java Hangman

jar: Hangman.java
	javac Hangman.java
	jar cfe Hangman.jar Hangman Hangman.class

clean: 
	rm -rf *.class *.jar
