#!/bin/bash
for afile in ./*
do
 if [ -f $afile ]
 #echo "$afile"
 then
 line=`cat $afile|wc -l`
 sum=$(( $sum+$line ))
 #echo "$line"
 fi
done
echo "$sum"
