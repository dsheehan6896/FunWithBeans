import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot x = new Parrot();
        x.setName("Polly");

        Supplier<Parrot> parrotSupplier = () -> x;

        context.registerBean("parrot1", Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));

        Parrot b = context.getBean("parrot1", Parrot.class);
        System.out.println(b.getName());

        Parrot p = context.getBean("parrot2", Parrot.class);
        System.out.println(p.getName());

        Parrot t = context.getBean(Parrot.class);
        System.out.println(t.getName());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);

    }

}
