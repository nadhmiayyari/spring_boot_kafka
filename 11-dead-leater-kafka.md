unless we handle an exception , the kafka consumer will be kept stuck consuming the same message  

what we have done is ignored bad message and left it unprocessed 


this is where the dead letter topic comes to us 

==> message that cannot be deserialized ==> send it to dead letter topic 

create a microservice that will consume messages from dead letter topic and process them differently 
