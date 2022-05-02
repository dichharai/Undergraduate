.section .data
n:
.long 5
i:
.long 1
sum:
.long 0

.section .text
.globl _start
_start:
movl i, %ecx
movl sum,%eax
movl n, %edx
while:
cmpl %ecx,%edx
jge falsepart
movl %eax, %ebx
jmp done
falsepart:
addl %ecx, %eax
incl %ecx
jmp while
done:
movl $1,%eax
int $0x80



