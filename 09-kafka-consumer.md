when kafka messages are consumed there is no order guarantee which messages from which partitions will be read first 
from the same partition , messages are read in the same order , there is an offset 
but there is no order between partitions 


if we have 3 consumers : 
each consumer will be assigned to read from a partition 


create a new class for kafka handler 