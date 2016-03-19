#include <stdio.h>

/*
 * Count blanks, tabs and newlines in given
 * input stream.
 */
int main(int argc, char* argv[]) {
	unsigned int blanks = 0;
	unsigned int tabs = 0;
	unsigned int newlines = 0;
	int c;

	while ((c = getchar()) != EOF) {
		if (c == ' ')
			blanks += 1;
		else if (c == '\t')
			tabs += 1;
		else if (c == '\n')
			newlines += 1;
	}

	printf("%10s: %u\n", "Blanks", blanks);
	printf("%10s: %u\n", "Tabs", tabs);
	printf("%10s: %u\n", "Newlines", newlines);
	return 0;
}
