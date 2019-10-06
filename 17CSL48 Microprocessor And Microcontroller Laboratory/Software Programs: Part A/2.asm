;Design and develop an assembly program to sort a given set of ‘n’ 16-bit numbers in ascending order. Adopt Bubble Sort algorithm to sort
;given elements.

.MODEL SMALL

.DATA
	A DW 2200H,7700H,4400H,1100H,5500H
	CNT DW ($-A)/2

.CODE
	MOV AX,@DATA
	MOV DS,AX

	MOV CX,2

	OUTLOOP:MOV DX,CX
			DEC DX
			MOV SI,DX
			ADD SI,SI
			MOV AX,A[SI]
	
	INLOOP: CMP A[SI-2],AX
			JBE INEXIT
			MOV DI,A[SI-2]
			MOV A[SI],DI
			DEC SI
			DEC SI
			DEC DX
			JNZ INLOOP

	INEXIT: MOV A[SI],AX
			INC CX
			CMP CX,CNT
			JBE OUTLOOP

	MOV AH,4CH
	INT 21H

END
