#!/bin/sh

cd `dirname $0 `

../gradlew -Psign=true :ipplus360-awdb-java:publish