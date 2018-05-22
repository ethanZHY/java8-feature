package demo.interfaces;
@FunctionalInterface
public interface Converter<T, F>{
    T convert (F from);
}