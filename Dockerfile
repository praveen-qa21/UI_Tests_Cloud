FROM bellsoft/liberica-openjdk-alpine:17.0.16-12-cds

WORKDIR /home/ui-test-cloud

COPY target/UI_Tests_Cloud-Package/ ./

ENV CP="ui-test-cloud.jar:ui-test-cloud-tests.jar:libs/*"

RUN apk add --no-cache curl jq

ENTRYPOINT ["sh", "checkgridstatus.sh"]
