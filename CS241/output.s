.section .data

message:
.ascii "HELLO\n"

.section .text
.globl _start
_start:

movl $4, %eax
movl $1, %ebx
movl $message, %ecx
movl $6, %edx

int $0x080

movl $4, %esi
movb message( , %esi,1), %al
movl $1, %edi
movb %al, message( , %edi, 1)

movl $4, %eax
movl $1, %ebx
movl $message, %ecx
movl $6, %edx

int $0x080

movl $1, %eax
movl $0, %ebx
int $0x080

