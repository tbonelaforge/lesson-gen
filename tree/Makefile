all: nodetest

nodetest: NodeTest.class
	@echo "Writing shortcut script nodetest..."
	@echo '#! /bin/sh' > nodetest
	@echo 'java -cp ../ tree.NodeTest ' >> nodetest
	@chmod +x nodetest

NodeTest.class: NodeTest.java Node.class
	javac -cp ../ NodeTest.java

Node.class: Node.java
	javac -cp ../ Node.java

.PHONY: clean

clean:
	rm -f nodetest
	rm *.class
