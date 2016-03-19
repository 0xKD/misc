#include<stdio.h>

int main(int argc, char* argv[]) {
	double nc;
	for(nc = 0; getchar() != EOF; nc++)
		; // empty loop - isolated semicolon - null statement
	printf("%.0f\n", nc);
	return 0;
}
