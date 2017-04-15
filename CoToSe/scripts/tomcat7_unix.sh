#!/bin/bash

if [ $# -eq 0 ]   # en local, no parametros
  then
    DISTR_OUTPUT=$(uname -a)

    if [[ $DISTR_OUTPUT == *"Ubuntu"* ]]; then
        GET='apt-get install'
    fi

    #Install package
    sudo $GET tomcat7 -y
    if [ $? != 0 ]; then
        echo "Something went wrong with the installation"
        exit
    fi
    sudo service tomcat7 restart
    echo "Completed successfully"
else 	#remoto, $1 = param 1 = username. 127.0.0.1 provisional
	sudo apt-get install sshpass
	sshpass -e ssh $1@127.0.0.1 'sudo apt-get install tomcat7'   
fi

