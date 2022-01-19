package refactown.cleancode.c10classes.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import refactown.cleancode.c10classes.enums.Mao;

import static org.junit.jupiter.api.Assertions.*;

class MelhorDeTresTest {


    /**
     * O ideal é serem vários métodos de teste para cada cenário específico,
     * foi inserido em um único método pela velocidade do curso apenas
     */
    @Test
    public void testJogo(){
        // parte 1: cenário
        Jogador bill = new JogadorMock("Bill", Mao.PAPEL);
        Jogador bob = new JogadorMock("Bob", Mao.PEDRA);
        Jogada jogada = new JogadaSimples(bill, bob);
        MelhorDeTres melhorDeTres = new MelhorDeTres(jogada, 7);
        // parte 2: ação
        melhorDeTres.jogar();
        // parte 3: validação
        assertTrue(melhorDeTres.temVencedor()); // DSL - função semântica
        assertEquals(bill, melhorDeTres.getVencedor());
        assertSame(bill, melhorDeTres.getVencedor());
        // Como são 7 rodadas em que Bill vence todas, deve parar na 4ª rodada
        assertEquals(4, melhorDeTres.getResultados().size());
    }

}