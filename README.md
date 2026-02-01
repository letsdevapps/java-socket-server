# Java Socket Server

Demonstração de servidor via socket utilizando Java. Criado o loop principal para o processo permanecer ativo e threads para os clientes enviarem os dados, conexão do cliente fica fora da thread por ja ser um processo auto-bloqueante.

	localhost:5000

## Telnet

Teste via Telnet

    sudo apt-get install telnet
    
    telnet localhost 5000

    {"text": "Message from terminal telnet!"}

## Netcat

Teste via Netcat

    sudo apt-get install netcat

    echo '{"text": "Message from terminal netcat!"}' | nc localhost 5000
