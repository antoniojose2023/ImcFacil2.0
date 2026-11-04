# ⚖️ IMC Fácil 2.0

Aplicativo Android nativo para calcular o **Índice de Massa Corporal (IMC)**, receber a classificação e uma dica de saúde, e manter um **histórico local** dos cálculos realizados.

![Plataforma](https://img.shields.io/badge/plataforma-Android-3DDC84?logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?logo=jetpackcompose&logoColor=white)
![Room](https://img.shields.io/badge/Banco-Room%202.8.4-green)
![minSdk](https://img.shields.io/badge/minSdk-24-blue)

---

## 📱 Screenshots

| Splash | Cálculo | Histórico | Resultado
|:---:|:---:|:---:|:---:|
| <img width="1280" height="2856" alt="Image" src="https://github.com/user-attachments/assets/e2786175-ac0c-4c18-b1ac-0dcfb90bd11d" />| <img width="1280" height="2856" alt="Image" src="https://github.com/user-attachments/assets/6fc2854c-5957-47a3-8d44-536aab9d18ba" /> | <img width="1280" height="2856" alt="Image" src="https://github.com/user-attachments/assets/b9369f43-d2ec-4015-92ff-974b7815796b" /> |  <img width="1280" height="2856" alt="Image" src="https://github.com/user-attachments/assets/267b8f68-92e1-4133-bc0f-fa60f32cc299" />  |

---

## ✨ Funcionalidades

- **Tela de boas-vindas (splash)** com indicador de progresso, exibida por 2 segundos.
- **Cálculo de IMC** a partir de peso (kg) e altura (m). Aceita vírgula ou ponto como separador decimal.
- **Classificação automática** segundo as faixas da Organização Mundial da Saúde (OMS).
- **Dica de saúde** personalizada para cada faixa de classificação.
- **Histórico persistente** de todos os cálculos, salvo localmente no dispositivo (funciona offline).
- **Exclusão de registros** diretamente na lista do histórico.
- **Feedback ao usuário** por meio de `Toast` (salvo, erro, campos inválidos, registro removido).

### Classificação do IMC

| IMC (kg/m²) | Classificação |
|---|---|
| < 18,5 | Abaixo do peso |
| 18,5 – 24,9 | Peso normal |
| 25,0 – 29,9 | Sobrepeso |
| 30,0 – 34,9 | Obesidade Grau I |
| 35,0 – 39,9 | Obesidade Grau II |
| ≥ 40,0 | Obesidade Grau III |

A fórmula utilizada é:

```
IMC = peso / (altura × altura)
```

> ⚠️ **Aviso:** este aplicativo tem caráter informativo e não substitui a avaliação de um médico ou nutricionista.

---

## 🧭 Fluxo de navegação

```
SplashScreen ──(2s)──► CalculoImc ──(Calcular)──► ResultadoIMC
                           │
                           └──(Histórico)──► HistoricoImc
```

| Rota | Tela | Descrição |
|---|---|---|
| `SPLASH_SCREEN` | `SplashScreen` | Boas-vindas e redirecionamento automático |
| `CALCULO` | `CalculoImc` | Entrada de peso e altura, botões **Calcular** e **Histórico** |
| `RESULTADO/{IMC}` | `ResultadoIMC` | Valor do IMC, classificação e dica de saúde |
| `HISTORICO` | `HistoricoImc` | Lista de registros com opção de excluir |

---

## 🛠️ Tecnologias

| Categoria | Tecnologia |
|---|---|
| Linguagem | Kotlin 2.2.10 |
| UI | Jetpack Compose + Material 3 (Compose BOM `2026.02.01`) |
| Navegação | Navigation Compose `2.10.2` |
| Persistência | Room `2.8.4` (com KSP `2.2.10-2.0.2`) |
| Assíncrono | Kotlin Coroutines |
| Layout | ConstraintLayout Compose `1.1.2` |
| Ícones | Material Icons (Composables) `2.2.1` |
| Build | Android Gradle Plugin `9.4.1` · Gradle Kotlin DSL · Version Catalog |


**Configuração do projeto**

- `applicationId`: `br.com.devmobileaj.imcfacil20`
- `minSdk`: 24 (Android 7.0)
- `targetSdk` / `compileSdk`: 37
- Java/Kotlin target: 11
- Orientação: somente retrato

---

## 🏗️ Arquitetura e estrutura

O projeto separa as responsabilidades em camadas simples: **UI**, **domínio** e **dados**.

```
app/src/main/java/br/com/devmobileaj/imcfacil20/
├── data/
│   ├── dao/
│   │   └── ImcDao.kt              # Operações de acesso ao banco (insert, delete, select)
│   ├── database/
│   │   └── ImcDatabase.kt         # Room Database (singleton, arquivo "imc.db")
│   ├── entity/
│   │   └── Imc.kt                 # Entidade da tabela "tb_imc"
│   └── repository/
│       └── ImcRepository.kt       # Camada de acesso aos dados usada pela UI
├── domain/
│   └── CalculoImcModel.kt         # Formatação, classificação e dicas de saúde
└── ui/
    ├── MainActivity.kt            # Activity única
    ├── Screen.kt                  # Constantes das rotas
    ├── SetupNavigation.kt         # NavHost e grafo de navegação
    ├── components/
    │   ├── Header.kt              # Cabeçalho reutilizável
    │   └── ItemImc.kt             # Item da lista do histórico
    ├── telas/
    │   ├── SplashScreen.kt
    │   ├── CalculoImc.kt
    │   ├── ResultadosIMC.kt
    │   └── HistoricoImc.kt
    └── theme/                     # Cores, tipografia e tema Material 3
```

### Modelo de dados

Tabela `tb_imc`:

| Coluna | Tipo | Observação |
|---|---|---|
| `id` | `Long` | Chave primária, autoincremento |
| `imc` | `Double` | Valor do IMC calculado |

### Paleta de cores

| Nome | Hex | Uso |
|---|---|---|
| `Green` | `#136765` | Cabeçalho, splash, botão principal |
| `Green_50` | `#20BBB6` | Botão secundário e destaque do resultado |
| `Green_90` | `#B0EFE9` | Fundo do ícone da calculadora |

---

## 🚀 Como executar

### Pré-requisitos

- [Android Studio](https://developer.android.com/studio) em versão recente, compatível com o AGP `9.4.1`
- JDK 11 ou superior (o projeto também define um toolchain do Gradle em `gradle/gradle-daemon-jvm.properties`)
- Android SDK 37 instalado
- Emulador ou dispositivo físico com Android 7.0 (API 24) ou superior

### Passo a passo

1. Clone o repositório:

   ```bash
   git clone https://github.com/antoniojose2023/ImcFacil2.0.git
   cd ImcFacil2.0
   ```

2. Abra a pasta no **Android Studio** e aguarde a sincronização do Gradle.

3. Selecione um emulador ou dispositivo e clique em **Run ▶**.

### Via linha de comando

```bash
# Gerar o APK de debug
./gradlew assembleDebug

# Instalar em um dispositivo conectado
./gradlew installDebug

# Executar testes unitários
./gradlew test

# Executar testes instrumentados (requer dispositivo/emulador)
./gradlew connectedAndroidTest
```

No Windows, use `gradlew.bat` no lugar de `./gradlew`.

O APK de debug é gerado em `app/build/outputs/apk/debug/`.

---

## 🧪 Testes

O projeto contém a estrutura inicial de testes:

- `app/src/test/` — testes unitários (JUnit)
- `app/src/androidTest/` — testes instrumentados (Espresso / Compose UI Test)

---

## 🗺️ Melhorias futuras

- [ ] Exibir data e hora de cada cálculo no histórico
- [ ] Mostrar peso, altura e classificação em cada item do histórico
- [ ] Migrar o acesso ao banco para um `ViewModel` com `Flow`/`StateFlow`
- [ ] Gráfico de evolução do IMC ao longo do tempo
- [ ] Suporte a tema escuro


---

## 🤝 Contribuindo

Contribuições são bem-vindas!

1. Faça um fork do projeto
2. Crie uma branch: `git checkout -b feature/minha-feature`
3. Faça o commit: `git commit -m "feat: minha feature"`
4. Envie para o seu fork: `git push origin feature/minha-feature`
5. Abra um Pull Request

---

## 👤 Autor

**Antonio José**
GitHub: [@antoniojose2023](https://github.com/antoniojose2023)

---

