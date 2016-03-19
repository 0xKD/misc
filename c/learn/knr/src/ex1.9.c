/*
 * Copy input to output, replacing each string
 * of one or more blanks with a single blank.
 */
#include<stdio.h>

#define IN_BLANK  1
#define OUT_BLANK 0

int main(int argc, char* argv[]) {
	int c, state = OUT_BLANK;

	while ((c = getchar()) != EOF) {
		if (c == ' ')
			state = IN_BLANK;
		else if (state == IN_BLANK) {
			putchar(' '); putchar(c);
			state = OUT_BLANK;
		}
		else {
			putchar(c);
		}
	}
	return 0;
}
