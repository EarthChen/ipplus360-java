#!/bin/sh

cd `dirname $0 `

REGISTRY="ghcr.io"

NAME="ipplus360-database-download"

VERSION=1.0.1

DOCKER_NAME="${REGISTRY}/earthchen/${NAME}:${VERSION}"

../gradlew -Pversion=${VERSION} :ipplus360-database-download:shadowJar

mv build/libs/ipplus360-database-download-${VERSION}-all.jar ./application.jar

echo $GITHUB_ACCESS_TOKEN | docker login ghcr.io -u USERNAME --password-stdin

docker build -t ${DOCKER_NAME} .

rm application.jar

docker push ${DOCKER_NAME}