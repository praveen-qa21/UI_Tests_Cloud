#!/bin/bash

#-------------------------------------------------------------------
#  This script expects the following environment variables
#     HUB_HOST
#     BROWSER
#     THREAD_COUNT
#     TEST_SUITE
#-------------------------------------------------------------------

# Let's print what we have received
echo "============Configs From Test Container================="
echo "seleniumGridHostname    : ${seleniumGridHostname:-hub}"
echo "browserType       : ${browserType:-chrome}"
echo "threadcount  : ${threadcount:-1}"
echo "test_suite    : ${test_suite:-testngSmoke.xml}"
echo "============+++++++====================================="

# Do not start the tests immediately. Hub has to be ready with browser nodes
echo "Checking if hub is ready..!"
count=0
while [ "$( curl -s http://"${seleniumGridHostname:-hub}":4444/status | jq -r .value.ready )" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"
  if [ "$count" -ge 30 ]
  then
      echo "**** HUB IS NOT READY WITHIN 30 SECONDS ****"
      exit 1
  fi
  sleep 1
done

# At this point, selenium grid should be up!
echo "Selenium Grid is up and running. Running the test...."
echo "${seleniumGridHostname}"
echo "${CP}"
# Start the java command
java -cp "$CP" \
          -DseleniumGridHostname="${seleniumGridHostname}" \
          -DseleniumGridEnabled=true \
          -DbrowserType="${browserType:-chrome}" \
          org.testng.TestNG \
         -threadcount "${threadcount:-1}" \
          "${test_suite:-testngSmoke.xml}"