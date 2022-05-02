.section .data
.section .text
.globl _start
_start:
movl $10, %ebx
incl %ebx
imull $10, %ebx
movl %ebx, %eax
movl $2, %ecx
idiv %ecx
movl %eax, %ebx
movl $1, %eax
int $0x80

