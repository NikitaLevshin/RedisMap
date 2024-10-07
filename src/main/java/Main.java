public class Main {

    public static void main(String[] args) {
        RedisMap rm = new RedisMap();
        rm.put("test1", "test2");
        rm.put("test6", "test2");
        rm.put("test3", "test4");
        rm.put("test5", "test5");

        var result = rm.keySet();
        for (String key : result) {
            System.out.println(key);
        }

        System.out.println("values");
        var values = rm.values();
        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("entrySet");
        var entrySet = rm.entrySet();
        for (var entry : entrySet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
