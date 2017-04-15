#!/bin/bash

PACKAGE="MySQL"

install_mysql () {
    #Try to install for Ubuntu/Debian. If it fails, Centos. If it fails, return failed.
    sudo apt-get install mysql-server -y &>/dev/null || \ #Ubuntu, Debian
    sudo yum install mysql-server -y &>/dev/null     || \ #Centos
    #echo test || \
    return -1                                             #Failed to install
    #Finished correctly. Returns 0 by default.
    #return 0
}

install_mysql

if [ -z $? ]; then  #Instalation failed (-1)
    echo "$PACKAGE - Something went wrong with the installation"
else                #Instalation OK (0)
    echo "$PACKAGE - Completed successfully"
fi

echo "Instalation finished"