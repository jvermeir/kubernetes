#!/bin/bash

(cd myservice && mvn clean package dockerfile:push) &
(cd leftorrightservice && mvn clean package dockerfile:push) &
(cd datacollector && mvn clean package dockerfile:push) &

wait < <(jobs -p)
