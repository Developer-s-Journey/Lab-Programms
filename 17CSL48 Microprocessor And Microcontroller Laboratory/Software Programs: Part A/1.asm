;Design and develop an assembly language program to search a key element “X” in a list of ‘n’ 16-bit numbers. Adopt Binary search algorithm
;in your program for searching.

.MODEL SMALL

.DATA
	ARRAY DW 1122H,2345H,3333H,4455H,6666H
	LEN DW ($-ARRAY)/2
	SRCH EQU 2345H
	SUCMSG DB 'Element found at position:'
	RESULT DB ?,'$'
	FAILMSG DB 'Element NOT found $'

.CODE
	MOV AX,@DATA
	MOV DS,AX

	MOV BX,1
	MOV DX,LEN
	MOV CX,SRCH

	AGAIN: CMP BX,DX
		   JA FAILURE
		   MOV AX,BX
		   ADD AX,DX
		   SHR AX,1
		   MOV SI,AX
		   DEC SI
		   ADD SI,SI
		   CMP CX,ARRAY[SI]
		   JAE BIGGER
		   DEC AX
		   MOV DX,AX
		   JMP AGAIN

	BIGGER: JE SUCCESS
			INC AX
			MOV BX,AX
			JMP AGAIN

	SUCCESS:ADD AL,'0'
			MOV RESULT,AL
			LEA DX,SUCMSG
			JMP DISPLAY

	FAILURE:LEA DX,FAILMSG

	DISPLAY:MOV AH,09H
			INT 21H

	MOV AH,4CH
	INT 21H

END
