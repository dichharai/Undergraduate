.section .data
n:
.long 10
result:
.long 0

.section .text
.globl _start
_start:
pushl n
call sum
addl $4,%esp
movl %eax,result

movl result, %ebx
movl $1, %eax
int $0x080



sum:
pushl %ebp
movl %esp, %ebp

subl $4, %esp #room for sum -4(%ebp)
subl $4, %esp #room for i -8(%ebp)
movl -8(%ebp), %ecx #moving i room in c reg

while:
movl 8(%ebp),%edx #moving var n in d reg
cmpl %ecx,%edx 
jl done
addl %ecx,-4(%ebp)
incl %ecx
jmp while


done:
movl -4(%ebp), %eax
movl %ebp, %esp
popl %ebp
ret

