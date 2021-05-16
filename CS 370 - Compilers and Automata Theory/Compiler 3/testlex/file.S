	.text
	.section	.rodata
.LC0:
	.string "hello world!"
.LC1:
	.string "goodbye"
.LC2:
	.string "second"
.LC3:
	.string "printf call %s %d\n"
.LC4:
	.string "and more"
.LC5:
	.string "Hello World!"
	.text
	.globl func
	.type func, @function
	.globl main
	.type main, @function
	.data
