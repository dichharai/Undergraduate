.section .data
n:
.long 9
.section .text
.globl _start
_start:
movl $1, %eax
movl n, %ebx
int $0x80
