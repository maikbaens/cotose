#!/bin/bash
DISTR_OUTPUT = $(uname -a)
#Check distro to see if apt-get or something else
if [[ 'Ubuntu' == *distroutput* ]]; then
    GET = 'apt-get install'
fi

#Install package
sudo ${GET} mysql-server -y
if [ $? != 0 ]; then
    echo "Something went wrong with the installation"
    exit
fi

echo "Completed successfully"