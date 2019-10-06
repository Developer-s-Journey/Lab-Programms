;Develop an assembly language program to reverse a given string and verify whether it is a palindrome or not. Display the appropriate message.

.MODEL SMALL
.STACK

.DATA
	ARRAY1 DB 30 DUP(?)
	ARRAY2 DB 30 DUP(?)
	M1 DB 10,13,'Enter the string: ',10,13,'$'
	M2 DB 10,13,'Entered string is PALINDROME$'
	M3 DB 10,13,'Entered string is NOT PALINDROME$'

.CODE
	MOV AX,@DATA
	MOV DS,AX
	MOV ES,AX

	LEA SI,ARRAY1
	LEA DI,ARRAY2

	LEA DX,M1
	MOV AH,4CH
	INT 21H

	MOV CX,00H

	UP1:MOV AH,01H
		INT 21H
		CMP AL,13
		JZ UP2
		MOV [SI],AL
		INC SI
		JMP UP1

	UP2:DEC SI

	UP3:MOV AL,[SI]
		MOV [DI],AL
		INC DI
		DEC SI
		JNZ UP2

	LEA SI,ARRAY1
	LEA DI,ARRAY2

	CLD

	REPE CMPSB
	JE PALIN

	LEA DX,M3
	MOV AH,09H
	INT 21H
	JMP EXIT1

	PALIN:  LEA DX,M2
			MOV AH,09H
			INT 21H

	EXIT1:  MOV AH,4CH
			INT 21H

END
