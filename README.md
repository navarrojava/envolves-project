# Involves, projeto de apresentação.

## Configurações :
 
  Para ler um arquivo com a extensão ".csv", ele deve estar na pasta resources.
  o nome padrão do arquivo é "test.csv" porém pode ser passado via argumento para a maquina virtual caso deseje abrir um arquivo com  nome diferente deste, 

# JVMArgs:

 -Dapp.document.csv.filename = o nome do arquivo que será  lido e armazenado pelo sistema, para futuras pesquisas.
  
 
# Comandos disponiveis:

count * - escreve no console a contagem total de registros importados (não deve considerar a linha de cabeçalho)
count distinct [propriedade] - escreve no console o total de valores distintos da propriedade (coluna) enviada
filter [propriedade] [valor] - escreve no console a linha de cabeçalho e todas as linhas em que a propriedade enviada possua o valor enviado