package examples;

import java.io.IOException;

public class IOExam02 {
    public static void main(String[] args) throws IOException {
        int read = -1;

        while((read = System.in.read()) != -1){ //EOF : -1
//            System.out.write(read);
//            System.out.println(read);
        }
    }
}

// Java IO : 데코레이터 패턴
// 가장 핵심인 주인공
// 1) 생성자에 InputStream, OutputStream, Reader, Writer가
// 파라미터에 없는 클래스
// 2) InputStream, OutputStream, Reader, Writer를 상속받고
// 있어야 한다.
// 3) 주인공들은 1byte or 1char, byte[] or char[] 을 읽어들이는
//  read()메소드를 가지고 있다.
// 4) 주인공들은 어디에서 읽을 것인지, 어디에 쓸것인지를 결정한다.
// 5) 장식은 다양한 기능의 메소드를 제공한다.
//    ex> int단위로 읽기, double단위로 읽기, 한줄 읽기 등, 버퍼내장
// java.io 패키지를 선택한 후, 클래스를 찾아본다.

//  System.in, System.out, System.err 도 주인공.
//  ByteArrayInputStream
//  FileInputStream
//  FileOutputStream