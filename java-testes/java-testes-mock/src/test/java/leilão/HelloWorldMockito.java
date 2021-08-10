package leilão;

import br.com.alura.leilao.dao.LeilaoDao;
import br.com.alura.leilao.model.Leilao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class HelloWorldMockito {

    @Test
    void hello() {
        //cria uma classe similar à classe original, métodos e campos, mas sem o código
        LeilaoDao leilaoDaoMock = Mockito.mock(LeilaoDao.class);
        List<Leilao> todos = leilaoDaoMock.buscarTodos();
        Assert.assertTrue(todos.isEmpty());


    }
}
