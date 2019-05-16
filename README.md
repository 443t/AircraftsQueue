# Exersize "Aircrafts Queue"

A software subsystem of an air-traffic control system is defined to manage a queue of aircraft (AC) in an airport.  

#### Endpoints:
+ **/aircrafts** to show list of all ACs and to insert a new AC into the system
+ **/dequeue** to remove an AC from the system

#### Query examples:
+ curl -v localhost:8080/aircrafts to show list of all ACs
+ curl -v -X POST localhost:8080/aircrafts -H 'Content-Type:application/json' -d '{"type": "CARGO", "size": "BIG"}' to add AC
+ curl -v localhost:8080/dequeue to remove an AC from the system
