.section .data
a:
.long 5
answer:
.long 0

.section .text
.globl _start
_start:

pushl a
call factorial
addl $4, %esp
movl %eax, answer

movl answer, %ebx
movl $1,%eax
int $0x080

factorial:
pushl %ebp
movl %esp, %ebp

cmpl $0, 8(%ebp)
jg recurse
movl $1, %eax
movl %ebp,%esp
popl %ebp
ret

recurse:
movl 8(%ebp),%ebx
decl %ebx
pushl %ebx #pushl n-1

call factorial
imull 8(%ebp), %eax
addl $4, %esp
movl %ebp,%esp
popl %ebp
ret





