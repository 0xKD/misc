/*
 * Remove trailing spaces and tabs from input
 */
#include<stdio.h>
#include<string.h>

#define MAX_STDIN 1000

int main(int argc, char* argv[]) {
	char line[MAX_STDIN];
	long len;

	while(fgets(line, MAX_STDIN, stdin) != NULL) {
		len = (long) strlen(line)-2;
		while(len > 0 && (line[len] == ' ' || line[len] == '\t')) {
			line[len] = '\0';
			len -= 1;
		}
		line[len+1] = '\n';
		printf("%s", line);
	}
	return 0;
}
