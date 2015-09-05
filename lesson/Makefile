all: tree generatortest

generatortest: GeneratorTest.class
	@echo "Writing shortcut script generatortest..."
	@echo '#! /bin/sh' > generatortest
	@echo 'java -cp ../ lesson.GeneratorTest' >> generatortest
	@chmod +x generatortest

GeneratorTest.class: GeneratorTest.java Generator.class ../tree/Node.class
	javac -cp ../ GeneratorTest.java

Generator.class: Generator.java ../tree/Node.class
	javac -cp ../ Generator.java

.PHONY: clean

clean:
	rm -f generatortest
	rm *.class

.PHONY: tree

tree:
	cd ../tree; make
