# Desafio Fuel Calculator App

Construir uma app Android com Kotlin que calcula o gasto total de combustível de uma viagem, com base no preço do combustível, no consumo médio do veículo e na distância percorrer.

Desafio prático com o objetivo de aplicar **Jetpack Compose** e navegação declarativa com estado partilhado (shared view model).

---

## Funcionalidades

- ✅ **Splash Screen** - Ecrã inicial de boas-vindas com botão de arranque ("Iniciar") para iniciar o fluxo de cálculo.
- ✅ **Passo 1: Preço do Combustível** - Introdução e validação do preço por litro do combustível (`FuelPriceScreen`).
- ✅ **Passo 2: Consumo do Carro** - Introdução da média de consumo do veículo em quilómetros por litro (`CarConsumptionScreen`).
- ✅ **Passo 3: Distância do Trajeto** - Introdução da distância total até ao destino em quilómetros (`DistanceScreen`).
- ✅ **Cálculo e Resultado Final** - Cálculo automático do valor total gasto e exibição em destaque (`FinalAmountScreen`), juntamente com a revisão detalhada dos dados inseridos.
- ✅ **Validação de Dados e Tratamento de Erros** - Controlo de entrada para aceitar apenas valores numéricos válidos e maiores que zero, exibindo estados de erro visuais.
- ✅ **Navegação com Estado Partilhado** - Transição fluida entre ecrãs e opção de reiniciar todo o processo ("Novo Cálculo").

---

## Arquitetura

O projeto segue a arquitetura **MVVM (Model-View-ViewModel)** com **Jetpack Compose**, garantindo separação de conceitos e reatividade na UI:

```
✅ UI LAYER (Presentation)
--> Screens (SplashScreen, FuelPriceScreen, CarConsumptionScreen, DistanceScreen, FinalAmountScreen)
--> Navigation (NavHost + NavController com rotas na sealed class Screen, em Screen.kt)
--> Components & Theme (IllustrationBackground, Custom Colors, Typography)

✅ STATE & LOGIC LAYER (ViewModel)
--> Shared ViewModel (FuelCalculatorViewModel)
--> Single Source of Truth para o fluxo multi-passos
--> Lógica de cálculo do custo total de combustível

```

---

## 🛠️ Tecnologias Utilizadas

### UI & Design
- **Jetpack Compose**: Interface declarativa moderna desenvolvida inteiramente com Composables.
- **Material Design 3**: Componentes modernos como `TextField`, `Button`, cores e tipografia personalizadas.
- **Custom Components**: Layouts estilizados com ilustrações integradas (`IllustrationBackground`).

### **Arquitetura & Ciclo de Vida**
- **ViewModel & State (`mutableStateOf`)**: Preservação e reatividade dos dados ao longo dos diferentes passos do cálculo.
- **Navigation Compose**: Gestão declarativa das rotas e fluxo entre os ecrãs da aplicação.

---

## **Lógica de Cálculo**

O cálculo do custo total de combustível é realizado na `FuelCalculatorViewModel` através da fórmula:

FÓRMULA --> Custo Total = (distância / consumo por litro) * preço do litro do combustível

---

## **Build**
- **Gradle**: 8.x / 9.x
- **Kotlin**: 2.0+
- **Android SDK**: 36 (Compile SDK 37)
- **Min SDK**: 24

### Configuração e Execução do Projeto
1. Efetuar o clone do repositório.
2. Abrir o projeto no Android Studio.
3. Executar a sincronização do Gradle.
4. Compilar e executar a app num dispositivo ou emulador (API 24+).

---

## Autor

**Rui Martins**
- 💻 GitHub: [https://github.com/Rui-Martins23](https://github.com/Rui-Martins23)
- 🔗 LinkedIn: [https://www.linkedin.com/in/rui-pedro-martins-913219169/](https://www.linkedin.com/in/rui-pedro-martins-913219169/)
