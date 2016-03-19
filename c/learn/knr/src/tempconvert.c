#include<stdio.h>

float c_to_f(float temp) {
	return temp * (9.0/5.0) + 32.0;
}

float f_to_c(float temp) {
	return (temp - 32.0) * 5.0/9.0;
}

int main(){
	for(float i=0;i<=100;i+=10) {
		// %6.2f => At least 6 chars wide, with 2 chars after decimal point
		printf("%6.2f : %6.2f\n", i, c_to_f(i));
	}

	/*
	 * %x => Hexadecimal. unsigned int only
	 * %o => Octal. unsigned int only.
	 * %f => Float. Floating point only. 6 decimal places by default.
	 * %d => Decimal Integer. Integer.
	 */
	printf("0x%x, O%o, %f, %d\n", 65, 90, 7.5, 8);

	/*
	 * Interesting: If you supply incorrect type to %?
	 * %d increases by 256 for each printf.
	 * (Starting from 0, presumably, as there are 12 printf calls before this one)
	 */
	printf("%d\n", 10.0);
	printf("%d\n", 10.0);
	printf("%d\n", 10.0);
	printf("%d\n", 30.8);

	float temp = 3.365;  // this doesn't affect printf call
	// For %f it prints last floating point passed to printf?
	printf("%f\n", 55);
}
