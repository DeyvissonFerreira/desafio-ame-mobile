# Projeto Desafio Mobile Ame Digital #

- Apk utilizado: **product_registration.apk**

### Construção e Execução dos Testes

 - Execução do teste pode ser realizadas via suite.xml através do TestNG utilizando uma IDE; ou
 - Através do comando "mvn clean install" utilizando um terminal na pasta raiz do projeto.
 
 OBS.: Será necessário alterar os parâmetro abaixo na suíte de acordo com o device/emulator e a porta disponível para execução mobile.
 
 		<parameter name="udid" value="emulator-5554" />
		<parameter name="systemPort" value="8220" />
 
 ### Geração do Relatório Allure Reports
 
 - Após execução dos testes, através do comando "allure serve" utilizando um terminal na pasta raiz do projeto.

### Preparando o Ambiente para Geração do Relatório no Allure

- Ralizar o download do Allure, para um diretório de preferência, no link: https://github.com/allure-framework/allure2/releases/tag/2.13.4

- Configurar a variável de ambiente do allure conforme exemplo abaixo:

![2020-10-25_09h46_43](https://user-images.githubusercontent.com/58958711/97107685-9d56e800-16a7-11eb-8fb0-e0d7efb8fd31.jpg)

### 🛠️ Ferramentas Utilizadas
- Selenium-java 3.141.59
- testng 6.9.8
- maven-compiler-plugin 3.1
- maven-resources-plugin 2.4
- maven-surefire-plugin 2.14.1
- allure-testng 2.8.1
- appium-java-cliente 7.0.0
- Java 8
- Maven 3.6.1
