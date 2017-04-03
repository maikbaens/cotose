#!/bin/sh

if [ $# -eq 0 ]   # en local, no parametros
  then
	sudo apt-get install apache2 -y
	sudo service apache2 restart
else 	#remoto, $1 = param 1 = username. 127.0.0.1 provisional, va la MAQ. VIRTUAL 
	sudo apt-get install sshpass
	sshpass -e ssh $1@127.0.0.1 'sudo apt-get install apache2'   
fi
