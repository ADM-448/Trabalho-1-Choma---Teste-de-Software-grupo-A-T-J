// TESTE RED E GREEN
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class CalculadoraDeDescontosTest {
//
//    private CalculadoraDeDescontos calc;
//
//    @BeforeEach
//    void setUp() {
//        // Instanciamos a calculadora antes de cada teste
//        calc = new CalculadoraDeDescontos();
//    }
//
//    /*
//     * Teste 1: Regra 4 - Valor Negativo
//     * Este é o primeiro teste que escreveríamos.
//     * Ele falhará ao compilar, pois a classe CalculadoraDeDescontos não existe.
//     */
//    @Test
//    void deveLancarExcecaoParaValorNegativo() {
//        // Verifica se a exceção esperada (IllegalArgumentException) é lançada
//        // quando o método calcular() é chamado com -50.0
//        assertThrows(IllegalArgumentException.class, () -> {
//            calc.calcular(-50.0);
//        });
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            calc.calcular(-0.01);
//        });
//    }
//
//    /*
//     * Após fazer o Teste 1 passar (GREEN), escreveríamos o Teste 2.
//     * Teste 2: Regra 1 - Abaixo de R$ 100,00
//     */
//    @Test
//    void deveRetornarZeroDescontoParaCompraAbaixoDeCem() {
//        double desconto = calc.calcular(99.99);
//        assertEquals(0.0, desconto, "Desconto deveria ser 0.0 para R$ 99.99");
//
//        desconto = calc.calcular(0.0);
//        assertEquals(0.0, desconto, "Desconto deveria ser 0.0 para R$ 0.00");
//    }
//
//    /*
//     * Após fazer o Teste 2 passar, escreveríamos os testes para a Regra 2.
//     * Teste 3: Regra 2 - Exatamente R$ 100,00 (Limite)
//     */
//    @Test
//    void deveRetornarCincoPorcentoDescontoParaCompraDeCemExatos() {
//        // 5% de 100.00 = 5.0
//        double desconto = calc.calcular(100.00);
//        assertEquals(5.0, desconto, "Desconto deveria ser 5.0 para R$ 100.00");
//    }
//
//    /*
//     * Teste 4: Regra 2 - Entre R$ 100,00 e R$ 500,00
//     */
//    @Test
//    void deveRetornarCincoPorcentoDescontoParaCompraEntreCemEQuinhentos() {
//        // 5% de 300.00 = 15.0
//        double desconto = calc.calcular(300.00);
//        assertEquals(15.0, desconto, "Desconto deveria ser 15.0 para R$ 300.00");
//    }
//
//    /*
//     * Teste 5: Regra 2 - Exatamente R$ 500,00 (Limite)
//     */
//    @Test
//    void deveRetornarCincoPorcentoDescontoParaCompraDeQuinhentosExatos() {
//        // 5% de 500.00 = 25.0
//        double desconto = calc.calcular(500.00);
//        assertEquals(25.0, desconto, "Desconto deveria ser 25.0 para R$ 500.00");
//    }
//
//    /*
//     * Após fazer os testes da Regra 2 passarem, escreveríamos o teste da Regra 3.
//     * Teste 6: Regra 3 - Acima de R$ 500,00
//     */
//    @Test
//    void deveRetornarDezPorcentoDescontoParaCompraAcimaDeQuinhentos() {
//        // 10% de 500.01 = 50.001
//        double desconto = calc.calcular(500.01);
//        assertEquals(50.001, desconto, "Desconto deveria ser 50.001 para R$ 500.01");
//
//        // 10% de 1000.00 = 100.0
//        desconto = calc.calcular(1000.00);
//        assertEquals(100.0, desconto, "Desconto deveria ser 100.0 para R$ 1000.00");
//    }
//}

// TESTE REFACTOR

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeDescontosTest {

    private CalculadoraDeDescontos calc;

    // Define a margem de erro (delta) para todas as comparações de double
    private static final double DELTA = 0.001;

    @BeforeEach
    void setUp() {
        calc = new CalculadoraDeDescontos();
    }

    /*
     * Teste 1: Regra 4 - Valor Negativo
     */
    @Test
    void deveLancarExcecaoParaValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcular(-50.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcular(-0.01);
        });
    }

    /*
     * Teste 2: Regra 1 - Abaixo de R$ 100,00
     */
    @Test
    void deveRetornarZeroDescontoParaCompraAbaixoDeCem() {
        double desconto = calc.calcular(99.99);
        // O esperado é 0.0
        assertEquals(0.0, desconto, DELTA, "Desconto deveria ser 0.0 para R$ 99.99");

        desconto = calc.calcular(0.0);
        // O esperado é 0.0
        assertEquals(0.0, desconto, DELTA, "Desconto deveria ser 0.0 para R$ 0.00");
    }

    /*
     * Teste 3: Regra 2 - Exatamente R$ 100,00 (Limite)
     */
    @Test
    void deveRetornarCincoPorcentoDescontoParaCompraDeCemExatos() {
        double desconto = calc.calcular(100.00);
        // O esperado é 5.0
        assertEquals(5.0, desconto, DELTA, "Desconto deveria ser 5.0 para R$ 100.00");
    }

    /*
     * Teste 4: Regra 2 - Entre R$ 100,00 e R$ 500,00
     */
    @Test
    void deveRetornarCincoPorcentoDescontoParaCompraEntreCemEQuinhentos() {
        double desconto = calc.calcular(300.00);
        // O esperado é 15.0
        assertEquals(15.0, desconto, DELTA, "Desconto deveria ser 15.0 para R$ 300.00");
    }

    /*
     * Teste 5: Regra 2 - Exatamente R$ 500,00 (Limite)
     */
    @Test
    void deveRetornarCincoPorcentoDescontoParaCompraDeQuinhentosExatos() {
        double desconto = calc.calcular(500.00);
        // O esperado é 25.0
        assertEquals(25.0, desconto, DELTA, "Desconto deveria ser 25.0 para R$ 500.00");
    }

    /*
     * Teste 6: Regra 3 - Acima de R$ 500,00
     */
    @Test
    void deveRetornarDezPorcentoDescontoParaCompraAcimaDeQuinhentos() {
        double desconto = calc.calcular(500.01);
        // O esperado é 50.001 (aqui que estava o erro de precisão)
        assertEquals(50.001, desconto, DELTA, "Desconto deveria ser 50.001 para R$ 500.01");

        desconto = calc.calcular(1000.00);
        // O esperado é 100.0
        assertEquals(100.0, desconto, DELTA, "Desconto deveria ser 100.0 para R$ 1000.00");
    }
}