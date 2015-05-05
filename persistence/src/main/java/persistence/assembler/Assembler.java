package persistence.assembler;


public interface Assembler<T, U> {

    U toBusinessObject(T t);

    T toEntity(U u);

    Iterable<T> toEntityList(Iterable<U> list);

    Iterable<U> toBusinessList(Iterable<T> list);
}
