.section .data
a:
.long 4
b:
.long 3
answer:
.long 0 

.section .text

.globl _start
_start:

pushl a #12(%ebp)
pushl b #8(%ebp)
call power
addl $8, %esp
movl %eax, answer

movl answer, %ebx
movl $1,%eax
int $0x080


power:
pushl %ebp
movl %esp,%ebp

subl $4,%esp #room for result -4(%ebp)
subl $4,%esp #room for i -8(%ebp)

movl $1, -4(%ebp)
movl $1, -8(%ebp)

while:
movl 8(%ebp),%ecx
cmpl -8(%ebp),%ecx
jl done

movl -4(%ebp), %eax
imull 12(%ebp)
movl %eax, -4(%ebp)
incl -8(%ebp)
jmp while

done:
movl -4(%ebp), %eax
movl %ebp, %esp
popl %ebp
ret

