# Use the official MySQL image as the base image
FROM mysql:9
COPY ladepunktverwaltung.sql /docker-entrypoint-initdb.d/

#VORHER volume löschen (docker volume rm <volume>), 
#Skripte werden nur ausgeführt, wenn Volume (z.B. /var/lib/mysql) nicht existiert