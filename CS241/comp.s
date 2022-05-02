.section .data 
m:
.long 9
n:
.long 3
.section .text
.globl _start
_start:
movl n, %ecx
cmpl %ecx , m
jg falsepart
movl %ecx, %ebx
jmp done
falsepart:
movl m, %ebx
done:
movl $1,%eax
int $0x80

