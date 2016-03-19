/*
 * Replace each tab by \t, space by \s
 * and backslash by \\
 * ^ That's the original exercise.
 * This one will highlight spaces / tabs / newlines.
 */
#include<stdio.h>

int main(int argc, char* argv[]) {
	char* red = "\x1B[97m\x1B[41m%s\x1B[0m";
	char* blue = "\x1B[97m\x1B[44m%s\x1B[0m";
	char* green = "\x1B[97m\x1B[42m%s\x1B[0m";
	// printf(red, "Hello, world!");

	int c;
	while ((c = getchar()) != EOF) {
		if (c == ' ')
			printf(blue, " ");
		else if (c == '\t')
			printf(red, "<Tab>");
		// \n won't handle cross-platform newlines.
		else if (c == '\x0D')
			printf(green, "›");
		else if (c == '\x0A') {
			printf(green, "$"); putchar('\n');
		}
		else
			putchar(c);
	}
	return 0;
}
