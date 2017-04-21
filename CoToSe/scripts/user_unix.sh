#!/bin/bash

#USAGE:
#user_unix.sh user passwd mysql(0 no 1 yes) mysql_root_pwd

user = "$1"
pass = "$2"
mysql = "$3"
mysqlpwd = "$4"

#user not empty
if [ -n $user ]; then
    #Check if user already exists
    usr = $(grep $1 /etc/passwd | cut -d : -f 1)
    if [[ usr -eq $user ]]; then
        #Return error user already exists
        echo 2
        return
    else
        #User does not exist, create
        useradd $user
        #Change passwd to selected. Blank passwd is accepted so no check
        echo "$user:$pass" | chpasswd
        echo 0 # User creation OK
    fi
else
    echo 1 #User empty
    return
fi

if [ -n $mysql ]; then
    mysql -u root -p $sqlpwd -e "create database db_$user; grant all privileges on db_$user.* to udb_$user identified by '$passwd';" || \
    echo 3 #Root password not correct or already db/user exists
    echo 0
fi

return