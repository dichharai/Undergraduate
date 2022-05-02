.section .data
n:
.long 11

result:
.long 0

.section .text

.globl _start
_start:

	pushl n 
	call square
	addl $4, %esp
	movl %eax, result

	movl result, %ebx
	movl $1, %eax
	int $0x080

square:
	pushl %ebp
	movl %esp, %ebp
	subl $4, %esp
	
	movl 8(%ebp),%eax
	imull 8(%ebp)
	movl %eax, -4(%ebp) #moved to temp var

	movl -4(%ebp), %eax
	movl %ebp, %esp
	popl %ebp
	ret
	
	

