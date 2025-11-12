#!/bin/bash

rm -rf bin
mkdir -p bin

find src -name "*.java" > sources.txt
javac -d bin @sources.txt

if [ $? -eq 0 ]; then
	echo "Compilation successful!"
	rm sources.txt
else
	echo "Compilation failed!"
	rm sources.txt
	exit 1
fi
