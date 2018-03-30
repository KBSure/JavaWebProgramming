package examples;

// 싱글턴 : 메모리에 오직 한개의 인스턴스만 생성하도록 한다.
public class GuestbookService {
    // 1. private생성자를 만든다.
    private GuestbookService(){

    }
    // 2. private static하게 자기자신을 참조하는 변수를 생성
    private static GuestbookService service = new GuestbookService();
    // 3.  2번에서 생성한 인스턴스를 반환하는 public static한 메소드를 만든다.
    public static GuestbookService getService(){
        return service;
    }
}
