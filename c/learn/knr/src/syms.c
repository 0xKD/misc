#include<stdio.h>

// symbolic constants, not variables.
#define LOWER 0
#define UPPER 300
#define STEP 20

/* print Fahrenheit - Celcius Table */
int main() {
	int fahr;
	for (fahr = LOWER; fahr <= UPPER; fahr += 20) {
		printf("%3d : %6.2f\n", fahr, (5.0/9.0) * (fahr - 32));
	}
}
