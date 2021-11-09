public class Processor {
    public String name() {
        System.out.println(getClass().getCanonicalName());
        return getClass().getSimpleName();
    }
}
