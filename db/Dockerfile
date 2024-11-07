FROM postgres:alpine
ADD ./scripts/01-schema.sql /docker-entrypoint-initdb.d
ADD ./scripts/02-ddl.sql /docker-entrypoint-initdb.d
ADD ./scripts/03-dml.sql /docker-entrypoint-initdb.d
RUN chmod a+r /docker-entrypoint-initdb.d/*
EXPOSE 5432