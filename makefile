all: Hangman.java
	javac Hangman.java
	java Hangman

clean: 
	rm -rf *.class
