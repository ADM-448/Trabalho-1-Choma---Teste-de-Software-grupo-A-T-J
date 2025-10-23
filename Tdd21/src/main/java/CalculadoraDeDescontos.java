///** TESTE RED
// * Classe que calcula descontos com base no valor da compra,
// * desenvolvida seguindo os princípios do TDD.
// */
//public class CalculadoraDeDescontos {
//
//    /**
//     * Calcula o valor do desconto com base nas regras de negócio.
//     *
//     * Regras:
//     * 1. < 100.00 -> 0%
//     * 2. >= 100.00 E <= 500.00 -> 5%
//     * 3. > 500.00 -> 10%
//     * 4. < 0 -> IllegalArgumentException
//     *
//     * @param valorCompra O valor total da compra.
//     * @return O valor do desconto a ser aplicado.
//     * @throws IllegalArgumentException Se o valor da compra for negativo.
//     */
//    public double calcular(double valorCompra) {
//
//        // Passo 1: Implementação da Regra 4 (Guard Clause)
//        // Faz o Teste 1 (deveLancarExcecaoParaValorNegativo) passar.
//        if (valorCompra < 0) {
//            throw new IllegalArgumentException("O valor da compra não pode ser negativo.");
//        }
//
//        // A ordem aqui é importante para a eficiência.
//        // Verificamos o maior valor primeiro.
//
//        // Passo 2: Implementação da Regra 3
//        // Faz o Teste 6 (deveRetornarDezPorcentoDescontoParaCompraAcimaDeQuinhentos) passar.
//        if (valorCompra > 500.00) {
//            return valorCompra * 0.10; // 10% de desconto
//        }
//
//        // Passo 3: Implementação da Regra 2
//        // Faz os Testes 3, 4 e 5 (faixa 100-500) passarem.
//        // Não precisamos verificar se é <= 500, pois o 'if' anterior já tratou disso.
//        if (valorCompra >= 100.00) {
//            return valorCompra * 0.05; // 5% de desconto
//        }
//
//        // Passo 4: Implementação da Regra 1
//        // Faz o Teste 2 (deveRetornarZeroDescontoParaCompraAbaixoDeCem) passar.
//        // Se não caiu em nenhuma das condições acima, é < 100.
//        return 0.0; // Sem desconto
//    }
//}

// TESTE GREEN e REFACTOR
// Este é o código mínimo apenas para a compilação funcionar
/**
 * Classe que calcula descontos com base no valor da compra,
 * desenvolvida seguindo os princípios do TDD.
 */
public class CalculadoraDeDescontos {

    /**
     * Calcula o valor do desconto com base nas regras de negócio.
     *
     * Regras:
     * 1. < 100.00 -> 0%
     * 2. >= 100.00 E <= 500.00 -> 5%
     * 3. > 500.00 -> 10%
     * 4. < 0 -> IllegalArgumentException
     *
     * @param valorCompra O valor total da compra.
     * @return O valor do desconto a ser aplicado.
     * @throws IllegalArgumentException Se o valor da compra for negativo.
     */
    public double calcular(double valorCompra) {

        // 1. Lógica para o Teste de Exceção (já estava passando)
        if (valorCompra < 0) {
            throw new IllegalArgumentException("O valor da compra não pode ser negativo.");
        }

        // 2. Lógica para o Teste de 10% (Acima de 500)
        if (valorCompra > 500.00) {
            return valorCompra * 0.10; // 10% de desconto
        }

        // 3. Lógica para os Testes de 5% (Entre 100 e 500)
        if (valorCompra >= 100.00) {
            // Não precisamos verificar se é <= 500, pois o 'if' anterior já tratou disso.
            return valorCompra * 0.05; // 5% de desconto
        }

        // 4. Lógica para o Teste de 0% (Abaixo de 100)
        // Se não caiu em nenhuma das condições acima, é < 100.
        return 0.0; // Sem desconto
    }
}