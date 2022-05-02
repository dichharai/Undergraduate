#!/bin/bash
word=$1
Lfreq=0
for afile in ./*
do 
if [ -f $afile ]
 then
  fname=$( basename $afile ) 
  #echo $fname
  search=`grep $word $afile|wc -l`
  #echo "$search"
  #echo "$search $fname"
  if [ $search -gt 0 -a $search -gt $Lfreq ]
   then 
    Lfreq=$search
    file=$fname
   fi
fi
done
if [ $Lfreq -eq 0 ]
then
 echo "There are no files that contains the word $word."
else
 echo "$file file contains $Lfreq line(s) with the word $word."
fi

  
  
  
 
 
 #line=`wc -l< $fname`
 #echo "$line $fname"
 #fi 
#done

