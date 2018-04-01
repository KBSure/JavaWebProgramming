package examples;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// GuestbookListServlet  ---->  GuestbookService(조회)
// GuestbookWriteServlet ---->  GuestbookService(저장)
// 싱글턴 : 메모리에 오직 한개의 인스턴스만 생성하도록한다.
//list를 메모리에 하나만 올리고, Guestbookservice가 관리하도록 하려고 함
public class GuestbookService {
    // 필드 선언
    List<Guestbook> list;

    // 1. private생성자를 만든다.
    private GuestbookService(){
        File file = new File("guestbook.dat");
        if(file.exists()){
            ObjectInputStream ois = null;
            try{
                System.out.println(file.getAbsolutePath());
                ois = new ObjectInputStream(new FileInputStream(file));
                list = (List)ois.readObject();
            }catch(Exception ex){
                ex.printStackTrace();
            }finally {
                try{ ois.close(); }catch(Exception e){}
            }
        }else {
            //쓰레드에 안전하지 않은 ArrayList를 safe하도록
            //벡터는 쓰레드에 safe하다. 그러나 쓰레기야.
            //synchronized 를 Arraylist 메서드들에 막 붙여서 반환한 것이다.
            // 그래서 쓰레드들 줄선다.
            list = Collections.synchronizedList(new ArrayList());
        }
    }
    // 2. private static 하게 자기자신을 참조하는 변수를 생성. 이때 초기화도 한다.
    private static GuestbookService service = new GuestbookService();

    // 3. 2.에서 생성한 인스턴스를 반환하는 public static 한 메소드를 만든다.
    public static GuestbookService getService(){
        return service;
    }

    public void addGuestbook(Guestbook guestbook){
        list.add(0,guestbook);
    }

//    public List<Guestbook> getGuestbooks2(){
//        return list;
//    }

    public Iterator<Guestbook> getGuestbooks(){
        return list.iterator();
    }

    public void save(){
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("guestbook.dat"));
            oos.writeObject(list);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try{ oos.close(); }catch(Exception e){}
        }
    }

} // GuestbookService


