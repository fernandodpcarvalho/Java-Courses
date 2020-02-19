# JMS - Java Message Service

Project developed at JMS course at www.alura.com.br


Instructions:

1)Install ActiveMQ Docker:
https://hub.docker.com/r/rmohr/activemq
docker pull rmohr/activemq
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq

2)Configure ActiveMQ Docker:
Access: http://localhost:8161/admin/
login = admin
password = admin
Create queues: fila.financeiro and ActiveMQ.DLQ
Create topics: topico.loja



