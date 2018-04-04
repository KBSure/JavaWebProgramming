package soundsystem;

import org.springframework.beans.factory.BeanNameAware;

public class Job3 implements BaseJob, BeanNameAware {
    String id;

    @Override
    public void exec() {
        System.out.println("Job3 exec()!!");
    }

    @Override
    public void setBeanName(String s) {
        this.id = s;
    }
}
