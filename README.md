## Projeto para Agregação Curricular
Criar um sistema Web composto de um Front-end SPA (Single Page Application) Angular e um Back-end Java Spring Boot para envio de arquivos XML e posterior processamento deles.

### Requisitos
•	Criar uma interface Web para upload de um ou mais arquivos com extensão .xml.
•	Para o desenvolvimento da interface, deve ser utilizado o tema Indigo do Angular Material.
•	Durante o envio do(s) arquivo(s) mostrar um loader para informar ao usuário que estão sendo processados, e ao final esse loader deve desaparecer (utilizar componentes do Angular Material).
•	Os arquivos contêm uma lista de agentes com código e data em formato ISO, e uma lista com quatro regiões (SE, S, NE, N) com sete valores numéricos de geração, compra e preço médio.
•	Todos os arquivos seguem o mesmo formato, como nos exemplos em anexo:
o	exemplo_01.xml
o	exemplo_02.xml
o	exemplo_03.xml
•	Não é necessário validar os dados dos arquivos, considere que eles estarão sempre corretos e no formato especificado acima.
•	Os arquivos devem ser lidos e enviados um a um, sequencialmente.
•	Os arquivos podem conter quantidades grandes de dados, por exemplo, 1.000 agentes (agentes/agente[0..999])
•	Os dados de preço médio (/agentes/agente[]/submercado[]/precoMedio) são confidenciais, portanto devem ser removidos ou substituídos por valores em branco antes de serem enviados.
•	Ao receber cada arquivo, o back-end deve apenas imprimir na saída padrão (System.out) os códigos de agentes (/agentes/agente[]/codigo) recebidos.
•	Utlizar 
•	Salvar os itens no Banco de dados.
•	Recuperar um dado consolidado por região.

## Angular 12 Frontend with SpringBoot (Java) Backend
- Java 11
- Maven 3.3.9+
- Node 10+,  
- Angular-cli 12

## In Memory DB (H2)

### Run Frontend
```bash
# Navigate to frontend (should contain package.json )
npm install
# run the project
ng serve --open
```

### Run Spring Boot using Maven
```bash
# Navigate to backend
mvn spring-boot:run
```

### GET BY SIGLAS BACKEND
http://localhost:8080/agente/sigla/{sigla}
