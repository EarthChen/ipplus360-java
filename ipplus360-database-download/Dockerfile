FROM openjdk:8

WORKDIR application

ENV downloadId=""

ENV filename=""

ENV databaseType="awdb"

ENV downloadPath="/tmp"

ENV targetFilenamePath=""

ENV fixedDelay=-1

COPY ./application.jar application.jar

CMD java application.jar \
    -i=${downloadId} \
    -f=${filename} \
    -t=${targetFilenamePath} \
    -p=${downloadPath} \
    -d=${fixedDelay}