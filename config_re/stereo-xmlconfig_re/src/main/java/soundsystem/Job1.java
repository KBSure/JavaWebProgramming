package soundsystem;

import org.springframework.beans.factory.BeanNameAware;

public class Job1 implements BaseJob, BeanNameAware {
    String id;

    @Override
    public void exec() {
        System.out.println("Job1 exec()!!");
    }

    @Override
    public void setBeanName(String s) {
        this.id = s;
    }
}
