.section .data
m:
.long 24
n:
.long 10
answer:
.long 0

.section .text
.globl _start
_start:
pushl m #12(%ebp)
pushl n #8(%ebp)
call gcd
addl $8, %esp #removing the gobal vars
movl %eax, answer

movl answer, %ebx
movl $1, %eax
int $0x080

gcd:
pushl %ebp
movl %esp, %ebp

cmpl $0,8(%ebp)#comparing 0 and n
jg recurse
movl 12(%ebp),%eax #answer is here
movl %ebp, %esp
popl %ebp
ret

recurse:
movl 12(%ebp), %eax #m, which is a dividend
cdq 
movl 8(%ebp), %ebx #n, divisor

idivl %ebx

pushl %ebx # new m=n
pushl %edx # new n=m%n
call gcd

addl $8, %esp #removes local parameter
movl %ebp, %esp
popl %ebp
ret



