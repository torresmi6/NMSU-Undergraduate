	.file	"test2.c"
	.text
	.section .rdata,"dr"
.LC0:
	.ascii "hello world!\0"
	.text
	.globl	func
	.def	func;	.scl	2;	.type	32;	.endef
	.seh_proc	func
func:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$32, %rsp
	.seh_stackalloc	32
	.seh_endprologue
	leaq	.LC0(%rip), %rcx
	call	puts
	nop
	addq	$32, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.def	__main;	.scl	2;	.type	32;	.endef
	.section .rdata,"dr"
.LC1:
	.ascii "second\0"
.LC2:
	.ascii "goodbye\0"
.LC3:
	.ascii "and more\0"
.LC4:
	.ascii "printf call %s %d\12\0"
.LC5:
	.ascii "Hello World!\0"
	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
main:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$32, %rsp
	.seh_stackalloc	32
	.seh_endprologue
	call	__main
	movl	$42, %r8d
	leaq	.LC1(%rip), %rdx
	leaq	.LC2(%rip), %rcx
	call	func
	movl	$53, %r8d
	leaq	.LC3(%rip), %rdx
	leaq	.LC4(%rip), %rcx
	call	printf
	leaq	.LC5(%rip), %rcx
	call	puts
	movl	$0, %eax
	addq	$32, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.ident	"GCC: (GNU) 9.3.0"
	.def	puts;	.scl	2;	.type	32;	.endef
	.def	printf;	.scl	2;	.type	32;	.endef
