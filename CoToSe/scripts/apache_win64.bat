@echo off
powershell.exe -ExecutionPolicy Bypass -Command ".\apache64.ps1"
cd c:\Apache24\Apache24\bin
httpd.exe -k install

