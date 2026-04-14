# 🥷 Ninja OOP — Java com Herança, Polimorfismo e Encapsulamento

Projeto educacional em Java que modela ninjas do universo de Naruto utilizando os principais pilares da **Programação Orientada a Objetos (POO)**. O código passou por um processo de refatoração completo, aplicando boas práticas da linguagem.

---

## 📁 Estrutura do Projeto

```
src/
├── Ninja.java       # Classe base abstrata
├── Uzumaki.java     # Subclasse — Naruto Uzumaki
├── Uchiha.java      # Subclasse — Sasuke Uchiha
└── Main.java        # Ponto de entrada da aplicação
```

---

## ⚙️ O que foi alterado e por quê

### `Ninja.java` — Classe Base

**Antes:**
```java
public class Ninja {
    String nome;
    String aldeia;
    int idade;

    public void HabilidadeEspecial() {}
}
```

**Depois:**
```java
public abstract class Ninja {
    private String nome;
    private String aldeia;
    private int idade;

    public Ninja(String nome, String aldeia, int idade) { ... }

    public abstract void habilidadeEspecial();
    public void apresentar() { ... }
}
```

**Mudanças aplicadas:**

| O que mudou | Por quê |
|---|---|
| Classe virou `abstract` | Não faz sentido instanciar um "Ninja genérico" — só subclasses concretas existem |
| Atributos virou `private` | **Encapsulamento**: protege os dados de acesso direto externo |
| Construtor com parâmetros | Evita criar objetos incompletos; garante que todo ninja tenha nome, aldeia e idade |
| `habilidadeEspecial()` virou `abstract` | **Obriga** toda subclasse a implementar o método — contrato garantido em tempo de compilação |
| Método `apresentar()` adicionado | Centraliza a exibição dos dados do ninja na classe pai (reaproveitamento de código) |
| Getters adicionados | Permitem leitura dos atributos privados de forma controlada |
| Nome do método em `camelCase` | Padrão de nomenclatura do Java (`habilidadeEspecial` em vez de `HabilidadeEspecial`) |

---

### `Uzumaki.java` e `Uchiha.java` — Subclasses

**Antes:**
```java
public class Uzumaki extends Ninja {
    @Override
    public void HabilidadeEspecial() {
        System.out.println("Habilidade Especial: Rasengan");
    }
}
```

**Depois:**
```java
public class Uzumaki extends Ninja {
    public Uzumaki(String nome, String aldeia, int idade) {
        super(nome, aldeia, idade);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(getNome() + " usa: Rasengan! 💨");
    }
}
```

**Mudanças aplicadas:**

| O que mudou | Por quê |
|---|---|
| Construtor com `super()` | Repassa os dados para a classe pai — padrão de herança em Java |
| Uso de `getNome()` na mensagem | Acesso ao atributo privado via getter, respeitando o encapsulamento |
| Nome do método corrigido para `camelCase` | Convenção Java |

---

### `Main.java` — Ponto de Entrada

**Antes:**
```java
static void main(String[] args) {
    Uzumaki Naruto = new Uzumaki();
    Naruto.nome = "Naruto Uzumaki";
    Naruto.HabilidadeEspecial();
}
```

**Depois:**
```java
public static void main(String[] args) {
    Ninja naruto = new Uzumaki("Naruto Uzumaki", "Konoha", 17);
    naruto.apresentar();
    naruto.habilidadeEspecial();
}
```

**Mudanças aplicadas:**

| O que mudou | Por quê |
|---|---|
| `public` adicionado ao `main` | Sem `public`, a JVM não consegue executar o método |
| Variável declarada como `Ninja` | **Polimorfismo**: referência do tipo pai aponta para objeto filho |
| Dados passados no construtor | Elimina a necessidade de setar atributos manualmente um por um |
| Nomes de variáveis em `camelCase` | Convenção Java (`naruto` em vez de `Naruto`) |

---

## 📚 Conceitos de POO Utilizados

### 🔒 Encapsulamento
Atributos declarados como `private`, acessíveis somente via **getters**. Protege os dados de modificações externas indesejadas.

```java
private String nome;
public String getNome() { return nome; }
```

---

### 🧬 Herança
`Uzumaki` e `Uchiha` herdam os atributos e comportamentos de `Ninja` usando `extends`. O construtor filho chama `super()` para inicializar a classe pai.

```java
public class Uzumaki extends Ninja {
    public Uzumaki(String nome, String aldeia, int idade) {
        super(nome, aldeia, idade);
    }
}
```

---

### 🎭 Polimorfismo
A variável é do tipo `Ninja`, mas aponta para um objeto `Uzumaki` ou `Uchiha`. O método correto é chamado em tempo de execução.

```java
Ninja naruto = new Uzumaki("Naruto Uzumaki", "Konoha", 17);
naruto.habilidadeEspecial(); // chama o método de Uzumaki
```

---

### 🏛️ Abstração
A classe `Ninja` é `abstract` — define o contrato (`habilidadeEspecial()`) sem implementar. Cada subclasse decide como implementar.

```java
public abstract class Ninja {
    public abstract void habilidadeEspecial();
}
```

---

## ▶️ Como Executar

### Pré-requisitos
- Java 11 ou superior instalado
- IntelliJ IDEA (recomendado) ou qualquer IDE Java

### Pelo terminal

```bash
# Compilar todos os arquivos
javac Ninja.java Uzumaki.java Uchiha.java Main.java

# Executar
java Main
```

### Saída esperada

```
Nome: Naruto Uzumaki | Aldeia: Konoha | Idade: 17
Naruto Uzumaki usa: Rasengan! 💨

Nome: Sasuke Uchiha | Aldeia: Konoha | Idade: 17
Sasuke Uchiha usa: Chidori! ⚡
```

---

## 🛠️ Tecnologias

- **Java** — Linguagem principal
- **POO** — Paradigma utilizado (Encapsulamento, Herança, Polimorfismo, Abstração)

---

## 💡 Possíveis Melhorias Futuras

- Adicionar interface `Lutador` com método `lutar(Ninja oponente)`
- Implementar mais clãs (ex: `Hyuga`, `Nara`)
- Criar um sistema de batalha entre ninjas
- Migrar para um projeto **Spring Boot** com API REST para gerenciar ninjas
