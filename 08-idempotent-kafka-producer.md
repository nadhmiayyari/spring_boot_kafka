once the broker receives a message it will send an ack to kafka producer 

if the ack for some reason would not be delivered 


==> producer will send the message again therefore 
==> having 2 identic messages 


to avoid these situations ==> you would make your kafka producer idempotent 
==> kafka producer will send the same message multiple times but kafka broker would store 
it only one time and keep it in the correct order

kafka broker will send an ack saying that the message is already existent


property == 
enable.idempotence= true
spring.kafka.producer.properties.enable.idempotence=true



spring.kafka.producer.properties.max.in.flight.requests.per.connection=5 

producer can send up to five requests or batches of messages without waiting for acks ==> can improve throughput and performance of your broker  
 