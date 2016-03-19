#include<stdio.h>

int main(int argc, char* argv[]) {
	long cc = 0; // long integers are at least 32 bits
	while(getchar() != EOF) {
		++cc;
	}
	/*
	 * ld -> long integer
	 * Will print number of chars + 1 (for LF)
	 * Count is printed as 4D (where count is 4)
	 * if count is < 10 (?)
	 */
	printf("%ld\n", cc);
	return 0;
}
