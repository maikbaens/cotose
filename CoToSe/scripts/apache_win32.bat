
Powershell 
wget http://www.apachelounge.com/download/VC14/binaries/httpd-2.4.25-win32-VC14.zip -UseBasicParsing -Outfile apache.zip
Expand-Archive apache.zip -DestinationPath c:\Apache24
start “c:\Apache24\bin\httpd.exe” 
