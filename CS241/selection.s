.section .data

alist:
.ascii "PONMLKponmlkkjigKLLMNaAbBcD"

println:
.ascii "\n"

int $0x080
i:
.long 26
j:
.long 1
max_pos:
.long 0

.section .text
.globl _start
_start:
movl $4, %eax
movl $1, %ebx
movl $alist, %ecx
movl $27, %edx

int $0x080
movl $4, %eax
movl $1, %ebx
movl $println, %ecx
movl $1, %edx
int $0x080

movl i, %ecx #moving i to c reg
start:
movl j, %esi #moving j to s index reg
movl max_pos,%edi #moving max_pos=0 to d reg
cmpl $0,%ecx #comparing if i <0
jl done #if less then done


forj:

cmpl %esi,%ecx # comparing i and j 

jl swap #if i<j then end of i loop therefore needs to go to swap

movb alist( ,%edi,1),%al #supposed max in al reg
movb alist( ,%esi,1),%ah #alist[j]

cmpb %al,%ah #comparing al and ah
jg change #if alist[h] is greater than suppsed max than go and change max idex#
incl %esi #else go to next index
jmp forj #jump to j

change:
movl %esi,%edi #changing max index to new one
incl %esi #increasing the j index
jmp forj #go to j

swap:
movl %ecx,%esi #index reg for i-last index
movb alist( ,%esi,1),%bh #keeping i-last index in bh reg
movb alist( ,%edi,1),%bl #moving largest value to bl reg
movb %bl,alist( ,%esi,1) #moving value from %bl to esi reg
movb %bh, alist( ,%edi,1)#moving i-last value to %edi reg 
decl %ecx
jmp start

done:
movl $4, %eax
movl $1, %ebx
movl $alist, %ecx
movl $27, %edx

int $0x080

movl $4, %eax
movl $1, %ebx
movl $println, %ecx
movl $1, %edx
int $0x080
movl $1, %eax
movl $0, %ebx

int $0x080


