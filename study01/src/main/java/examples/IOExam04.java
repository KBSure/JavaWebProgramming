package examples;

import java.io.*;

// 키보드(System.in)로 부터 한줄씩 입력받아,
// 파일 input.txt에 한줄씩 저장하시오.
// quit[enter]를 입력하면 프로그램이 종료됩니다.
// BufferedReader의 readLine()
// 주인공 : FileOutputStream을 이용하여 저장.
// PrintWriter의 println()
public class IOExam04 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        FileOutputStream fos = new FileOutputStream("input.txt");
        PrintWriter pw = new PrintWriter(fos);
        String line = null;
        while((line = br.readLine()) != null){
            if("quit".equals(line))
                break;
            pw.println(line);
        }
        pw.close();
    }
}