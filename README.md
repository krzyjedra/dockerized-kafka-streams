#Dockerized Kafka Streams App

App counts each single mark input by user and gives quantity of it.

How to run:

1. Start docker compose `docker compose up`
2. Create topic and start producer `docker compose exec broker /bin/bash` `cd /usr/bin` `./kafka-console-producer --topic input -broker-list :9092`
3. Start consumer `docker compose exec broker /bin/bash` `cd usr/bin` `./kafka-console-consumer --topic output -bootstrap-server :9092`
