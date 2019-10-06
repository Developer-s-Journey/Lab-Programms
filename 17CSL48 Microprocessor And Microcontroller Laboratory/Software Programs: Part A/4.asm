;Develop an assembly language program to compute nCr using recursive procedure. Assume that ‘n’ and ‘r’ are non-negative integers.

.MODEL SMALL
.STACK 64

.DATA
	N DB 6
	R DB 3
	RES DB 0

.CODE
	MOV AX,@DATA
	MOV DS,AX

	MOV AL,N
	MOV BL,R

	CALL NCR

	MOV AH,4CH
	INT 21H

	NCR PROC
		CMP BL,0
		JNE L1
		ADD RES,1
		RET

		L1: CMP BL,AL
			JNE L2
			ADD RES,1
			RET

		L2: CMP BL,1
			JNE L3
			ADD RES,AL
			RET

		L3: DEC AL
			CMP BL,AL
			JNE L4
			INC AL
			ADD RES,AL
			RET

		L4: PUSH AX
			PUSH BX
			CALL NCR
			POP BX
			POP AX

			DEC BX
			PUSH AX
			PUSH BX
			CALL NCR
			POP BX
			POP AX
			RET
	NCR ENDP

END
