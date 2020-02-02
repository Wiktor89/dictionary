FROM wiktor89/custom-alpine
MAINTAINER afonin.vitia2000@yandex.ru

COPY target/dictionary-*.jar /srv/service.jar

ENV  JAVA_OPTS="-server -Xms32m -Xmx128M -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heap_log.hprof" \
	 CREATE_SHEMA="none" \
	 DB_USER="" \
	 DB_PASSWORD="" \
	 DATA_BASE_IP=""

EXPOSE 8080
WORKDIR /srv
HEALTHCHECK --start-period=90s --interval=60s --timeout=15s CMD /usr/bin/curl -sS --fail http://localhost:8080/health || exit 1
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /srv/service.jar"]