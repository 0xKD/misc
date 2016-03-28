#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	FILE* fp;
	fp = fopen("input.txt", "r");
	int current_floor = 0;
	char current_char;
	const char go_up = '(', go_down = ')';

	while ((current_char = (char) fgetc(fp)) != EOF) {
		if (strncmp(&current_char, &go_up, 1) == 0) {
			current_floor += 1;
		} else if (strncmp(&current_char, &go_down, 1) == 0) {
			current_floor -= 1;
		}
	}

	printf("%d\n", current_floor);
	return 0;
}
