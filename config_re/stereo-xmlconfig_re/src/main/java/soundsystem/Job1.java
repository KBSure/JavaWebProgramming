package soundsystem;

import org.springframework.beans.factory.BeanNameAware;

public class Job1 implements BaseJob, BeanNameAware {
    String id;

    @Override
    public void exec() {
        System.out.println(id + " exec()!!");
    }

    @Override
    public void setBeanName(String s) {
        this.id = s;
    }
}

//BeanNameAware는 쓰는 경우 거의 없으려나?ㅎㅎ
