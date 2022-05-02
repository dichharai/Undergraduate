#!/bin/bash
afile=$1
name=${afile%.*}
#echo $name
obj=$name.o
prog=$name.s
as=`as --32 -o $obj $prog`
ld=`ld -melf_i386 -o $name $obj`
run=`./$name`
