import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import queue.no_621_任务调度器;

public class unitTest {
    @Test
    void testFact(){
        no_621_任务调度器 fun = new no_621_任务调度器();
        char[] chars = {'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'};
        Assertions.assertEquals(52,fun.leastInterval(chars,2));
    }
}
