.section .data
items:
.long 5,2,7,4,9,4
i:
.long 1
max:
.long 0

.section .text
.globl _start
_start:

movl max, %ebx
movl items, %eax #items[0] is the number of items
movl i, %ecx #moving counter to c register

for:
movl %ecx, %esi #moving counter to index register because reg#==counter# 
movl items( ,%esi,4), %edx #index addressing

cmpl %ecx,%eax

jl done

incl %ecx
cmpl %ebx,%edx
jle for

movl %edx, %ebx
jmp for
 
done:
movl $1, %eax
int $0x080
