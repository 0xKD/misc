#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <string.h>

struct Person {
	char* name;
	int age;
	int height;
	int weight;
};

struct Person* person_create(char* name, int age, int height, int weight) {
	struct Person* this = malloc(sizeof(struct Person));
	assert(this != NULL);

	this->name = strdup(name);
	/*
	 * alternate way:
	 * malloc(t+1) will allocate memory for char[]
	 * stncpy returns dst (ptr resulting from malloc)
	 */
	// size_t t = strlen(name);
	// this->name = strncpy(malloc(t+1), name, t);
	this->age = age;
	this->height = height;
	this->weight = weight;
	return this;
}

/* If we don't do this, there will be memory-leaks */
void person_destroy(struct Person* person) {
	assert(person != NULL);
	free(person->name);
	free(person);
}

int main(int argc, char** argv) {
	struct Person* p = person_create("Johnny Appleseed", 21, 120, 80);
	printf("Name: %s\n", p->name);
	/* Alternate way */
	// printf("Name: %s\n", (*p).name);

	person_destroy(p);
	/* equivalent to */
	// person_destroy(*(&p)); // dereference address of a pointer
	
	/* allocating on stack */
	struct Person p2;
	p2.name = "Smithsonianfury";
	p2.age = 1337;
	p2.height = 199;
	p2.weight = 33;

	printf("Another name: %s\n", p2.name);
	return 0;
}

