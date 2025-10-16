package com.padroes.criacionais.factorymethod;

// =========================================================
// MOLDE: PADRÃO FACTORY METHOD (CLÁSSICO GOF)
// =========================================================

// 1. O Cliente (CLASSE PRINCIPAL DE EXECUÇÃO)
// CLASSE [NomeDoSeuExemploDemo]:
public class FactoryMethod1 { // NomeDoSeuExemploDemo

    // MÉTODO Estático principal (main):
    public static void main(String[] args) {
        System.out.println("--- Factory Method Demo 1: Shapes (Static Factory Model) ---");

        // CENÁRIO A: Cria a fábrica e chama o método de negócio.
        // criador_a.MetodoDeNegocio("ParamA") 
        Shape circle = ShapeFactory.getShape("CIRCLE"); // Chamada direta ao método estático
        if (circle != null) {
            System.out.print("Circle: ");
            circle.draw(); // MetodoDeNegocio (ação do produto)
        }

        System.out.println("-------------------------");

        // CENÁRIO B: Cria a segunda fábrica e chama o método de negócio.
        // criador_b.MetodoDeNegocio("ParamB")
        Shape rectangle = ShapeFactory.getShape("RECTANGLE"); // Chamada direta ao método estático
        if (rectangle != null) {
            System.out.print("Rectangle: ");
            rectangle.draw(); // MetodoDeNegocio (ação do produto)
        }

        // Teste de caso inválido
        Shape unknown = ShapeFactory.getShape("TRIANGLE");
        if (unknown == null) {
            System.out.println("\nUnknown shape requested. Factory returned null.");
        }
    }
}


// 2. O Contrato (A Interface do Produto)
// INTERFACE [NomeDoProdutoAbstrato]:
interface Shape { // NomeDoProdutoAbstrato
    // MÉTODO AcaoPrincipal(parâmetro)
    void draw(); // Revertido: Sem parâmetros
}


// 3. O Criador Abstrato (Define a estrutura) -> SIMULADO PELA CLASSE ShapeFactory
// CLASSE ABSTRATA [NomeDoCriadorAbstrato]:
class ShapeFactory { // Simula o Criador (Modelo Estático)
    
    // O FACTORY METHOD (Estático): Encapsula a lógica de instanciação (NOVA ProdutoConcretoX)
    // MÉTODO ABSTRATO CriarProduto()
    public static Shape getShape(String shapeType) { // O Factory Method é estático

        if (shapeType == null) {
            return null;
        }

        // 4. Os Criadores Concretos (Decidem qual Produto criar) -> Lógica implementada aqui.
        // CLASSE CriadorConcretoA: MÉTODO CriarProduto(): RETORNAR NOVA ProdutoConcretoA
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(); 
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null;
    }
    // O Método MetodoDeNegocio está ausente neste modelo estático.
}


// 5. Os Produtos Concretos (As implementações reais)

// CLASSE [ProdutoConcretoA] IMPLEMENTA [ProdutoAbstrato]:
class Circle implements Shape { // ProdutoConcretoA
    // MÉTODO AcaoPrincipal(parâmetro):
    @Override
    public void draw() { // Revertido: Sem parâmetros
        // Lógica Específica A
        System.out.println("Inside Circle::draw() method.");
    }
}

// CLASSE [ProdutoConcretoB] IMPLEMENTA [ProdutoAbstrato]:
class Rectangle implements Shape { // ProdutoConcretoB
    // MÉTODO AcaoPrincipal(parâmetro):
    @Override
    public void draw() { // Revertido: Sem parâmetros
        // Lógica Específica B
        System.out.println("Inside Rectangle::draw() method.");
    }
}

// CLASSE ProdutoConcretoC IMPLEMENTA Produto:
class Square implements Shape { // ProdutoConcretoC
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}