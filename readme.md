Projeto de Automação de Testes - Automation Practice

Este projeto realiza testes automatizados das funcionalidades de login e cadastro do site Automation Practice, utilizando Java, Selenium, JUnit 5, Maven e Java Faker.

📋 Descrição do Projeto O objetivo deste projeto é automatizar os testes das funcionalidades de login e cadastro do site Automation Practice, garantindo que essas funcionalidades funcionem conforme o esperado. O projeto foi desenvolvido utilizando as seguintes tecnologias:

Java: Linguagem de programação principal. Selenium: Framework para automação de testes em navegadores. JUnit 5: Framework para execução de testes. Maven: Gerenciador de dependências e build do projeto. Java Faker: Biblioteca para gerar dados fictícios, como nomes, emails, etc. 🚀 Funcionalidades Testadas

Cadastro
Testa o cadastro de um novo usuário com dados válidos. 
Testa o cadastro com um email já registrado. 
Testa o cadastro com campos obrigatórios em branco.

Login
Testa o login com credenciais válidas. 
Testa o login com credenciais inválidas. 
Testa o login com o campo de senha em branco. 
Testa o login com o campo de email em branco. 
Testa o login com um email inválido. 
Testa o login com uma senha inválida.

🛠️ Pré-requisitos Antes de executar o projeto, certifique-se de ter instalado:

Java JDK 23 ou superior: Download JDK Maven: Instalação do Maven

IDE (opcional, mas recomendado): IntelliJ IDEA Eclipse VS Code

⚙️ Configuração do Projeto

Clone o repositório: git clone https://github.com/seu-usuario/seu-repositorio.git

Navegue até o diretório do projeto: cd seu-repositorio Instale as dependências com Maven: mvn clean install

🏃 Executando os Testes Para executar todos os testes, use o seguinte comando: mvn test Executando testes específicos Se você quiser executar apenas os testes de login ou cadastro, use o seguinte comando:

mvn test -Dtest=LoginTest mvn test -Dtest=CadastroTest 📚 Dependências As principais dependências do projeto estão listadas no arquivo pom.xml:

Selenium: org.seleniumhq.selenium:selenium-java JUnit 5: org.junit.jupiter:junit-jupiter-api Hamcrest: org.hamcrest:hamcrest-all Java Faker: com.github.javafaker:javafaker

📝 Relatórios de Teste

Os resultados dos testes são gerados automaticamente pelo Maven e podem ser encontrados no diretório:

target/surefire-reports/

Para gerar um relatório HTML, execute o seguinte comando: mvn surefire-report:report O relatório estará disponível em:

target/site/surefire-report.html

🤝 Contribuição

Se você deseja contribuir para este projeto, siga estas etapas:

Faça um fork do repositório. Crie uma branch para sua feature (git checkout -b feature/nova-feature). Commit suas mudanças (git commit -m 'Adicionando nova feature'). Push para a branch (git push origin feature/nova-feature). Abra um Pull Request.

📧 Contato Se você tiver alguma dúvida ou sugestão, entre em contato:

Nome: Uelton Email: uelton.gomes@uol.com.br 
GitHub: ugomes
Linkedin: https://www.linkedin.com/in/uelton-gomes/
