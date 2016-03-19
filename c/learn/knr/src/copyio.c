#include<stdio.h>

int main(int argc, char* argv[]) {
	unsigned int c;
	/*
	 * EOF is defined in stdio
	c = getchar();
	while (c != EOF) {
		putchar(c);
		c = getchar();
	}
	*/

	/*
	 * alternative version
	 * != has higher precedence than =
	 * so c = getchar() != EOF will be equivalent to
	 *     c = (getchar() != EOF)
	 * which will cause c to have a value of 0 or 1
	 * This is why we use parens
	 *
	 * Multiple characters are buffered and passed
	 * ony be one. (?)
	 */
	while ((c = getchar()) != EOF) {
		// This will print 10 for every char sequence (LF)
		printf("Integer value: %d\n", c);
		putchar(c); putchar('\n');
	}
	printf("-- end -- : %d\n", EOF);

	// Program doesn't wait for input.
	// getchar() still returns EOF.
	int t = getchar();
	printf("%d\n", (t == EOF));
	return 0;
}
