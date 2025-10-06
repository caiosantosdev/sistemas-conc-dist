# Nome do programa RPC
PROGRAM = calc
CLIENT = $(PROGRAM)_client
SERVER = $(PROGRAM)_server

# Compilador e flags
CC = cc
CFLAGS = -g -Wall


# Arquivos comuns
XDR = $(PROGRAM)_xdr.c
HDR = $(PROGRAM).h

# Fontes específicas
CLNT_SRC = $(PROGRAM)_clnt.c $(CLIENT).c $(XDR)
SRVR_SRC = $(PROGRAM)_svc.c $(PROGRAM)_server.c $(XDR)

# Objetos
CLNT_OBJ = $(CLNT_SRC:.c=.o)
SRVR_OBJ = $(SRVR_SRC:.c=.o)

# Alvo padrão: compilar tudo
all: $(CLIENT) $(SERVER)

# Compila cliente
$(CLIENT): $(CLNT_OBJ)
	$(CC) -o $@ $(CLNT_OBJ) $(LDLIBS)

# Compila servidor
$(SERVER): $(SRVR_OBJ)
	$(CC) -o $@ $(SRVR_OBJ) $(LDLIBS)

# Regra genérica de compilação
%.o: %.c $(HDR)
	$(CC) $(CFLAGS) -c $< -o $@

# Limpeza
clean:
	rm -f *.o $(CLIENT) $(SERVER)

# Geração dos arquivos RPC (caso precise refazer do .x)
rpcgen:
	rpcgen -C -a calc.x