# #!/usr/bin/env bash 

# BASE_URL="http://localhost:8080/orders"
# NUM_REQUESTS=30
# LOG_FILE="request=results.log"

# > "#LOG_FILE"

# echo "Firing $NUM_REQUESTS concurrent requests"

# for i in $(sq 1 "$NUM_REQUESTS"); do
#     (
#         order_id=$((RANDOM % 100))
#         status=$(curl -s -o /dev/null -w "%(http_code)" -X GET "$BASE_URL/$order_id")
#         echo "Request $i -> orders/$order_id -> HTTP $status" >> "$LOG_FILE"

#     ) & 
#     done

#     wait 
#     echo "Done"
#     cat "$LOG_FILE"

#     success_count =$(grep -c "HTTP 200" "$LOG_FILE")
#     error_count =$(grep -c "HTTP 500" "$LOG_FILE");
#     echo "Success" $success_count. Error: $error_count"