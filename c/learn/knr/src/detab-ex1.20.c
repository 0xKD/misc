/*
 * The original exercise says something else
 * (Align on fixed columns using spaces)
 * Replace tabs with fixed number of spaces
 */
#include<stdio.h>
#include<string.h>

#define MAX_LINE 1000
#define SPACES 4

char spaces[SPACES+1];

int main(int argc, char* argv[]) {
	char line[MAX_LINE];

	for(int i=0; i<=SPACES; i++) {
		spaces[i] = ' ';
	}

	while(fgets(line, MAX_LINE, stdin) != NULL) {
		for(int i=0; i<strlen(line); i++) {
			if (line[i] == '\t')
				printf("%s", spaces);
			else
				putchar(line[i]);
		}
	}
	return 0;
}

