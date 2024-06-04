package design_pattern;

/**
 * 單例設計模式測試
 */
public class SingletonTest extends Thread {
    String myId;
    public SingletonTest(String id) {
        myId = id;
    }

    // 執行緒執行的時候就去呼叫Singleton.getInstance()
    public void run() {
        Singleton singleton = Singleton.getInstance();
    }
}