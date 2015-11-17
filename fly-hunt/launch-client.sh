#! /bin/bash
java -cp build/classes/ -Djava.rmi.server.codebase=file:./build/classes/ -Djava.security.policy=server.policy client.ClientViewer
