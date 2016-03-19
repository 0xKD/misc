/*
 * Print histogram of length of words
 */
#include <stdio.h>

#define MAX_WORD_SIZE 100
#define IN_BLANKS  1
#define OUT_BLANKS 0

int main(int argc, char* argv[]) {
	int lengths[MAX_WORD_SIZE];
	int max = 0;
	int curr_word_size = 0;

	for (int i=0; i<MAX_WORD_SIZE; i++)
		lengths[i] = 0;

	/*
	 * Uncomment putchar() lines to make the program
	 * output each word on a new line
	 */
	int c, state = OUT_BLANKS;
	while ((c = getchar()) != EOF) {
		if (c == ' ' || c == '\t' || c == '\x0D' || c == '\x0A')
			state = IN_BLANKS;
		else if ((c != ' ' || c != '\t' || c == '\x0D'
					|| c == '\x0A') && state == IN_BLANKS) {
			state = OUT_BLANKS;
			lengths[++curr_word_size] += 1;
			max = lengths[curr_word_size] > max ? lengths[curr_word_size] : max;
			curr_word_size = 0;
			// putchar('\n'); putchar(c);
		}
		else {
			curr_word_size += 1;
			// putchar(c);
		}
	}

	if (curr_word_size != 0)
		lengths[++curr_word_size] += 1;
	max = lengths[curr_word_size] > max ? lengths[curr_word_size] : max;

	char hist[max+1];
	for(int i=0;i<max;i++)
		hist[i] = '-';
	hist[max] = '\0';

	printf("-- Size of words vs frequency --\n");
	for (int i=0; i<MAX_WORD_SIZE; i++) {
		if (lengths[i] > 0)
			/*
			 * hist + x acts as substring.
			 * But it will only work for position x till end
			 * Also, strings must be null terminated.
			 */
			printf("%2d: %s\n", i, hist+(max-lengths[i]));
	}
	return 0;
}

