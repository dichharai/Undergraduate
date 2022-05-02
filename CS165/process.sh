#!/bin/bash
for afile in ./*
do
 if [ -f $afile ]
 then
 echo "$afile is in this directory"
 else
 echo "This is a dir"
 fi
done
