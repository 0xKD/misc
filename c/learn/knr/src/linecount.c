#include <stdio.h>

int main(){
	int c;
	long lc = 0;
	while ((c = getchar()) != EOF) {
		if (c == '\n')
			lc += 1;
	}
	printf("%ld\n", lc);
}
