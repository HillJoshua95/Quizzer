build:
	@javac src/*.java -d classes/

clean:
	@rm classes/*.class

run:
	@java -cp classes/ Driver
