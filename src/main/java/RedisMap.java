import redis.clients.jedis.Jedis;

import java.util.*;

public class RedisMap implements Map<String, String> {

    private Jedis jedis;

    public RedisMap() {
        this.jedis = new Jedis("localhost", 6379);
    }

    @Override
    public int size() {
        return (int) jedis.dbSize();
    }

    @Override
    public boolean isEmpty() {
        return jedis.dbSize() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public String get(Object key) {
        if (jedis.get(key.toString()) == null) {
            throw new NoSuchElementException();
        }
        return jedis.get(key.toString());
    }

    @Override
    public String put(String key, String value) {
        return jedis.set(key, value);
    }

    @Override
    public String remove(Object key) {
        if (jedis.del(key.toString()) > 0) {
            return "DELETED";
        } else {
            return "NO SUCH ELEMENT";
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        m.forEach((k, v) -> jedis.set(k, v));
    }

    @Override
    public void clear() {
        jedis.flushDB();
    }

    @Override
    public Set<String> keySet() {
        return Set.of();
    }

    @Override
    public Collection<String> values() {
        return List.of();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return Set.of();
    }
}
