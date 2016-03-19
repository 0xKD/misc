#include<stdio.h>
#include<string.h>

#define MAX_STDIN_LINE 1000

int factorial(int n);

int factorial(int n) {
	if (n < 2)
		return 1;
	else
		return n * factorial(n-1);
}

int main(int argc, char* argv[]) {
	char a[MAX_STDIN_LINE];
	printf("Factorial of %d is %d\n", 5, factorial(5));

	/*
	 * strlen includes newline character in
	 * length of string
	 */
	while (fgets(a, MAX_STDIN_LINE, stdin) != NULL)
		printf("%sLength: %ld\n", a, strlen(a)-1);

	return 0;
}
