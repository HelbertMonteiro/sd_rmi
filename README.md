# sd_rmi

Trabalho de Sistemas Distribuídos utilizando RMI

O projeto consiste na implementação de um sistema de ordenação de números escolhidos por um cliente, sendo a ordenação do lado do servidor. O cliente envia quantos números quiser na ordem que desejar, envia os números para o servidor que se encarrega de organizar os números em ordem crescente e retornar a sequência ordenada para o cliente, além de salvar em um banco de dados.

A comunicação entre cliente e servidor, que são executadas em máquinas separadas é realizada através da arquitetura RMI (Remote Method Invocation), que é uma interface de programação que permite a execução de chamadas remotas. O RMI cria um serviço do lado do servidor e possibilita seu acesso através de uma url, um serviço e a interface remota de ambos os lados Cliente e Servidor, onde a implementação dessa interface fica do lado do servidor que trata os dados e retorna o resultado para o cliente.

A linguagem de programação usada é o Java que já possui bibliotecas nativas para o uso do RMI e o banco de dados foi construído com MySql.
