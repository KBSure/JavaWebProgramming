package examples;

// 표준출력은 io1.txt에 저장
// 에러출력은 io2.txt에 저장
// java examples.IOExam01 > io1.txt 2> io2.txt
public class IOExam01 {
    public static void main(String[] args){
        System.out.println("hello world");
        System.err.println("java world");
    }
}

// IO
// - byte
//      추상클래스 : InputStream , OutputStream
// - char
//      추상클래스 : Reader , Writer
// - 특수한IO
//      System.in(표준 입력 장치), System.out(표준 출력 장치),
//      System.err(표준 에러 출력 장치)