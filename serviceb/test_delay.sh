#!/bin/bash

url="http://localhost:8081/service-a/greetings"

# Record the start time in milliseconds
start_time=$(date +%s%3N)

# Polling loop for service registration delay
while true; do
    status=$(curl -s -o /dev/null -w "%{http_code}" $url)

    # Check if the status code is 200 (OK)
    if [ $status -eq 202 ]; then
        echo "Service A is ready"
        break
    else
        echo "Waiting for Service A to be ready... Status code: $status"
        sleep 5
    fi
done

end_time=$(date +%s%3N)

duration=$((end_time - start_time))
echo "Time taken for Service A to be ready: $duration milliseconds"