#!/bin/sh

cd `dirname $0 `

VERSION=1.0.0

../gradlew -Pversion=${VERSION} :ipplus360-database-download:shadowJar

mv build/libs/ipplus360-database-download-${VERSION}-all.jar ./application.jar

docker build .