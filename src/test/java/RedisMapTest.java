import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class RedisMapTest {

    private RedisMap redisMap;
    private String key;
    private String value;

    @BeforeEach
    void setUp() {
        redisMap = new RedisMap();
        key = "testKey";
        value = "testValue";
    }

    @AfterEach
    void tearDown() {
        redisMap.clear();
    }

    @Test
    public void redisMapShouldPutValueAndGetSuccessfully() {
        redisMap.put(key, value);
        assertEquals(value, redisMap.get(key));
    }

    @Test
    public void redisMapShouldReturnSizeSuccessfully() {
        redisMap.put(key, value);
        assertEquals(1, redisMap.size());
    }

    @Test
    public void redisMapShouldDeleteSuccessfully() {
        redisMap.put(key, value);

        assertEquals("DELETED", redisMap.remove(key));
        assertEquals(0, redisMap.size());
    }

    @Test
    public void redisMapShouldAddAllSuccessfully() {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        map.put("key1", "value1");
        redisMap.putAll(map);
        assertEquals(2, redisMap.size());
    }

    @Test
    public void redisMapShouldThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> redisMap.get("testKey"));
    }
}
