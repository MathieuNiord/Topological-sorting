default: build

build:
	@echo Building...
	@javac src/*.java

clean:
	@echo Project...
	@rm -rf src/*.class

random:
	@java -jar randomdag.jar 10 0.5 | java -cp src Main

test:
	@echo __________________________________
	@echo testing test_100.txt
	@java -cp src Main < tests_files/test_100.txt
	@echo __________________________________
	@echo testing test_101.txt
	@java -cp src Main < tests_files/test_101.txt
	@echo __________________________________
	@echo testing test_102.txt
	@java -cp src Main < tests_files/test_102.txt
	@echo __________________________________
	@echo testing test_103.txt
	@java -cp src Main < tests_files/test_103.txt
	@echo __________________________________
	@echo testing test_104.txt
	@java -cp src Main < tests_files/test_104.txt
	@echo __________________________________
	@echo testing test_105.txt
	@java -cp src Main < tests_files/test_105.txt
	@echo __________________________________
