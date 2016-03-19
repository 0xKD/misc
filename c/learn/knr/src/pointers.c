#include<stdio.h>

int main(int argc, char* argv[]) {
	char* names[] = {"Apple", "Ball", "Chimera", "Doggy", "Foo"};
	int values[] = {91, 22, 73, 14, 31};

	printf("sizeof(argv) %ld\n", sizeof(argv));

	/* sizeof(int) will be 4 */
	printf("sizeof(values): %ld, sizeof(int): %ld\n",
			sizeof(values), sizeof(int));

	/*
	 * sizeof(char) is 1, but we have array of pointers
	 * sizeof(char*) will be 8
	 * names is pointer to char array
	 *
	 * Why does sizeof(names) work but not sizeof(argv)
	 * Given both are char* x[].
	 *
	 * Answer: In main(), char* is defined/treated as array
	 * so sizeof(names) will give sizeof array (of pointers)
	 * --
	 * But when this is passed as function argument
	 * it decays to a pointer that points to first element
	 * of that array. (ptr to ptr to char)
	 */
	printf("sizeof(names): %ld, sizeof(char*): %ld\n",
			sizeof(names), sizeof(char*));

	int len = sizeof(values) / sizeof(int);
	int len2 = sizeof(names) / sizeof(char*);
	printf("Length: %d <=> %d\n", len, len2);

	for(int c=0; c<len; c++)
		printf("%8s : %2d\n", *(names+c), *(values+c));

	return 0;
}

