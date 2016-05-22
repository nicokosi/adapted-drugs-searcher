rm -rf mocked-service
mkdir mocked-service
cd mocked-service

wget http://repo1.maven.org/maven2/com/github/tomakehurst/wiremock/1.57/wiremock-1.57-standalone.jar

mkdir mappings
touch mappings/adapted-drugs.json
echo "{
    \"request\": {
        \"method\": \"POST\",
        \"url\": \"/rest/api/adapted-drugs\"
    },
    \"response\": {
        \"status\": 200,
        \"body\": \"More content\"
    }
}" > mappings/adapted-drugs.json

java -jar wiremock-1.57-standalone.jar --port 8088

