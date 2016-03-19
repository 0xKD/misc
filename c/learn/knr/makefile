SRCDIR=src
CC=cc

all: $(patsubst $(SRCDIR)/%.c, %, $(wildcard $(SRCDIR)/*.c))
clean:
	rm -f bin/*

%: $(SRCDIR)/%.c
	$(CC) -o bin/$@ $<

