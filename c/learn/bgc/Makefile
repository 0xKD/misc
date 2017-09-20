SRCDIR=src
OBJDIR=bin
CC=cc

all: $(patsubst $(SRCDIR)/%.c, %, $(wildcard $(SRCDIR)/*.c))
clean:
	rm -f $(OBJDIR)/*

%: $(SRCDIR)/%.c
	test -d $(OBJDIR) || mkdir $(OBJDIR)
	$(CC) -o bin/$@ $<
