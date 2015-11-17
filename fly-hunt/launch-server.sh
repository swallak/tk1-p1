#! /bin/bash

cd build/classes/
rmiregistry &
cd ../..
java -cp build/classes/ -Djava.rmi.server.codebase=file:./build/classes/ -Djava.rmi.server.hostname=localhost -Djava.security.debug=access,failure -Djava.security.policy=server.policy server.Server
